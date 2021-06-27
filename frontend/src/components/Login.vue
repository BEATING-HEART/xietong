<template>
    <div class="login_box">
     <!-- 登录表单区域 -->
     <h2 float:center>欢迎使用</h2>
      <el-form ref="form" :model="loginform" :rules="loginrules">
        <!-- 用户名 -->
        <el-form-item prop="username">
          <el-input placeholder="用户名" v-model="loginform.username"></el-input>
        </el-form-item>
        <!-- 密码 -->
        <el-form-item prop="password">
          <el-input placeholder="密码" v-model="loginform.password" show-password></el-input>
        </el-form-item>
        <!-- 登录按钮 -->
        <el-form-item>
          <el-button type="primary" @click="login">登录</el-button>
          <el-button type="info" @click="reset">重置</el-button>
        </el-form-item>
      </el-form>
      <router-view/>
    </div>
</template>

<script>
import qs from 'qs'
export default {
    data(){
        return{
            //登录表单
            loginform:{
                username:'',
                password:''
            },
            loginrules:{
                username:[{ required: true, message: '请输入用户名', trigger: 'blur' }],
                password:[{ required: true, message: '请输入密码', trigger: 'blur' }]
            }
        }
    },
    methods:{
        reset(){
            this.$refs.form.resetFields();
        },
        async login(){
            var url = 'http://39.103.202.215:8080/login';
            var url1 = 'http://39.103.202.215:8080/api/homepage/show';
            this.$refs.form.validate(async valid=>{
                if(!valid) return this.$message.error('请输入账号密码');
                await this.$axios.post(url,qs.stringify(this.loginform))
                .then(async ({data: res,headers: token})=>{
                  console.log(qs.stringify(this.loginform))
                  console.log(res);
                  console.log(token.authorization);
                  window.sessionStorage.setItem("token",token.authorization)
                  await this.$axios.get(url1,{headers:{Authorization:token.authorization}})
                  .then(({data: res1})=>{
                    console.log(res1.data.identity.position)
                    window.sessionStorage.setItem("position","WorkShop")
                    window.sessionStorage.setItem("StaffId",res1.data.identity.staffId)
                    window.sessionStorage.setItem("StaffName",res1.data.identity.name)
                    window.sessionStorage.setItem("StaffPosition",res1.data.identity.position)
                    if(res1.data.identity.position == "超级管理员"){
                      console.log("超级管理员")
                      this.$router.push("/adminhome")
                    }
                    else if(res1.data.identity.position == "车间人员"){
                      console.log("车间人员")
                      this.$router.push("/wshome")
                    }
                    else if(res1.data.identity.position == "仓库人员"){
                      console.log("仓库人员")
                      this.$router.push("/WarehouseHome")
                    }
                    else if(res1.data.identity.position == "仓库经理"){
                      console.log("仓库经理")
                      this.$router.push("/WarehouseHome")
                    }
                    else if(res1.data.identity.position == "销售人员"){
                      console.log("销售人员")
                      this.$router.push("/Sales")
                    }
                    else if(res1.data.identity.position == "销售经理"){
                      console.log("销售经理")
                      this.$router.push("/Sales")
                    }
                    else if(res1.data.identity.position == "财务人员"){
                      console.log("财务人员")
                      this.$router.push("/fhome")
                    }
                    if(res.code == !200) return this.$message.error('登录失败');
                    this.$message.success('登录成功'); 
                  })
                  
                });
                
            })
        //      this.$refs.form.validate(async valid=>{
        //           if(!valid) return this.$message.error('请输入账号密码');
        //           const {data: res,headers: token} = await this.$axios.post(url,qs.stringify(this.loginform));
        //           console.log(qs.stringify(this.loginform))
        //           console.log(res);
        //           console.log(token.authorization);
        //           if(res.code == !200) return this.$message.error('登录失败');
        //           this.$message.success('登录成功');
        //           const {data: res1} = await this.$axios.get(url1,{headers:{Authorization:token.authorization}})
        //           console.log(res1)
        //           window.sessionStorage.setItem("token",token.authorization)
        //           window.sessionStorage.setItem("position","WorkShop")
        //           window.sessionStorage.setItem("StaffId",res1.data.identity.staffId)
        //           window.sessionStorage.setItem("StaffName",res1.data.identity.name)
        //           this.$router.push("/workshophome")
        // })
    }
}
}
</script>

<style scoped>

	.el-row {
		background-color: #fafafa;
		height: 100%;
		display: flex;
		align-items: center;
		text-align: center;
		justify-content: center;
	}
    .el-container{
        align-items: center;
		text-align: center;
		justify-content: center;
    }
    .el-main{
        align-items: center;
		text-align: center;
		justify-content: center;
    }

	.el-divider {
		height: 200px;
	}

	.captchaImg {
		float: left;
		margin-left: 8px;
		border-radius: 4px;
	}
    .login_container {
  /*background-image: url("../images/bg_login.png");*/
  background-repeat: no-repeat;
  background-size: cover;
  height: 100%;
}
.login_box {
  width: 290px;
  height: 350px;
  /* background-color: #fff; */
  border-radius: 5px;
  position: absolute;
  left: 50%;
  top: 50%;
  transform: translate(-50%, -50%);
  align-items: center;
  text-align: center;
  justify-content: center;
}

</style>
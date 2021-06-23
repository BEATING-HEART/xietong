<template>
    <div class="container">
        <h2 style="margin-left:500px">信息修改</h2>
        <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
  <el-form-item label="账号" prop="account" style="margin-left:170px">
                  <el-autocomplete
                    class="inline-input"
                    v-model="ruleForm.account"
                    :fetch-suggestions="querySearch"
                    :trigger-on-focus="false"
                    @select="handleSelect"
                ></el-autocomplete>
  </el-form-item>
  <el-form-item label="姓名" prop="name" style="margin-left:170px">
    <el-input v-model="ruleForm.name" style="width:580px"></el-input>
  </el-form-item>
  <!-- <el-form-item label="密码" prop="password" style="margin-left:170px">
    <el-input v-model="ruleForm.password" style="width:580px"></el-input>
  </el-form-item> -->
  <el-form-item label="职位" prop="positions" style="margin-left:170px">
    <el-select v-model="ruleForm.positions" placeholder="请选择职位" style="width:580px">
      <el-option label="车间人员" value="车间人员"></el-option>
      <el-option label="销售员" value="销售员"></el-option>
      <el-option label="销售经理" value="销售经理"></el-option>
      <el-option label="仓库管理员" value="仓库管理员"></el-option>
      <el-option label="仓库经理" value="仓库经理"></el-option>
      <el-option label="财务员" value="财务员"></el-option>
    </el-select>
  </el-form-item>
  <!-- 按钮 -->
    <el-button type="primary" @click="submitForm('ruleForm')" style="margin-left:700px">修改</el-button>
    <el-button type="info" @click="resetForm('ruleForm')">重置</el-button>
  </el-form-item>
</el-form>
    </div>
</template>

<script>
  export default {
      created(){
        console.log(this.loadAll)
        this.form.StaffId = window.sessionStorage.getItem('StaffId')
        this.form.StaffName = window.sessionStorage.getItem('StaffName')
    },
    data() {
      return {
        ruleForm: {
          account: '',
          positions: '',
          name: '',
          password: '',
        },
        rules: {
          name: [
            { required: true, message: '请输入姓名', trigger: 'blur' },
            { min: 1, max: 20, message: '长度在 1 到 20 个字符', trigger: 'blur' }
          ],
          account: [
            { required: true, message: '请输入账号', trigger: 'blur' },
            { min: 1, max: 10, message: '长度在 1 到 10 个字符', trigger: 'blur' }
          ],
          password: [
            { required: true, message: '请输入密码', trigger: 'blur' },
            { min: 1, max: 20, message: '长度在 1 到 20 个字符', trigger: 'blur' }
          ],
          positions: [
            { required: true, message: '请输入职位', trigger: 'change' },
          ]
        },
        Accounts:[]
      };
    },
    methods: {
      submitForm(formName) {
        console.log('修改')
        this.$refs[formName].validate(async (valid) => {
          if (valid) {
            var url = 'http://39.103.202.215:8080/api/staff/update';
            var temp = {
              staffId: this.ruleForm.account,
              staffName: this.ruleForm.name,
              staffPosition: this.ruleForm.positions,
              staffPwd: this.ruleForm.password,
            }
            console.log(temp)
             await this.$axios.post(url,temp,{headers:{"Content-Type":"application/json"}})
             .then(({data: res}) => {
               console.log(res)
               this.$message.success('修改成功')
             })
             .catch((error) => {
               this.$message.error('修改失败')
               console.log(error);
              });
          } else {
            console.log('修改失败!!');
            return false;
          }
        });
      },
      resetForm(formName) {
        this.$refs[formName].resetFields();
      },
      querySearch(queryString, cb) {
        var Accounts = this.Accounts;
        var results = queryString ? Accounts.filter(this.createFilter(queryString)) : Accounts;
        // 调用 callback 返回建议列表的数据
        cb(results);
      },
      createFilter(queryString) {
        return (accounts) => {
          return (accounts.value.toLowerCase().indexOf(queryString.toLowerCase()) === 0);
        };
      },
       handleSelect(item) {
        this.ruleForm.name=item.name;
        this.ruleForm.password=item.password;
        this.ruleForm.positions=item.position;
      },
      // loadAll() {
      //   return [
      //     { value: "1812480136","name":"庄逸尘","password":"zyc123456","position":"仓库经理"},
      //     { value: "1812480407","name":"蔡俊","password":"cj123456","position":"仓库管理员"},
      //     {value:"1811410626","name":"叶博涛","password":"ybt123456","position":"销售员"}
      //   ];
      // }
    },
    async mounted(){
      var url = 'http://39.103.202.215:8080/api/staff/list';
      await this.$axios.get(url)
      .then(({data: res})=>{
        console.log(res.data)
        const a = res.data
        a.forEach(function (item) {
              item.value = String(item.staffId)
              delete item.staffId
        })
        this.Accounts = a
      })      
    }
  }
</script>

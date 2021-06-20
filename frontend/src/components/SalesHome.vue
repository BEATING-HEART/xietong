<template>
    <el-container class="home-container">
    <!--头部-->
        <el-header>
            <div>
                <span>销售管理</span>
            </div>
            <el-button type="info" @click="logout">退出</el-button>
        </el-header>
        <el-container>
            <el-aside width="250px">
                <el-menu
      :default-active="activePath"
      class="el-menu-vertical-demo"
      background-color="#545c64"
      text-color="#fff"
      active-text-color="#ffd04b"
      router
      >
      <!-- 通过v-if判断哪一个导航栏该被加载，如果表达式值为True则被加载 -->
      <el-menu-item :index="item.path+''" v-if="flag" v-for="item in show" :key="item.id" @click="saveNavState(item.path)">
        <i class="el-icon-menu"></i>
        <span slot="title">{{item.authName}}</span>
      </el-menu-item>
      <el-menu-item :index="item.path+''" v-if="!flag" v-for="item in showManager" :key="item.id" @click="saveNavState(item.path)">
        <i class="el-icon-menu"></i>
        <span slot="title">{{item.authName}}</span>
      </el-menu-item>
    </el-menu>
            </el-aside>
            <el-main>
                <router-view></router-view>
            </el-main>
        </el-container>
    </el-container>
</template>

<script>
export default {
    created(){
        if(window.sessionStorage.getItem("StaffPosition")=="销售人员")
        this.flag=true
        else
        this.flag=false
    },
    data(){
        return{
            flag:'',
            show:[
                {
                "id":101,
                "authName":"首页",
                "path":"/SalesHome"
                },
                {
                "id":102,
                "authName":"销售单查询",
                "path":"/SalesSheetQuery"
                },
                {
                "id":103,
                "authName":"销售单填写",
                "path":"/WriteSales"
                },
                {
                "id":104,
                "authName":"待审核的销售单",
                "path":'/RemainAudit'
                },
                {
                "id":105,
                "authName":"客户信息",
                "path":"/ClientInfo"
                },
                {
                "id":106,
                "authName":"查看发货单",
                "path":"/FaHuoSheet"
                }
                ],
                showManager:[
                {
                "id":101,
                "authName":"首页",
                "path":"/SalesHome"
                },
                {
                "id":102,
                "authName":"待审核的销售单",
                "path":'/RemainAudit'
                },
                {
                    "id":103,
                    "authName":"销售单查询",
                    "path":"/SalesSheetQuery"
                },
                {
                    "id":104,
                    "authName":"客户信息",
                    "path":"/ClientInfo"
                },
                {
                    "id":105,
                    "authName":"查看发货单",
                    "path":"/FaHuoSheet"
                },
                ],
            activePath:'/SalesHome'
        }
    },
    methods:{
        logout(){
            window.sessionStorage.clear()
            this.$router.push('/login')
        },
        saveNavState(activePath){
            window.sessionStorage.setItem('activePath',activePath)
            this.activePath = activePath
        }
    }
}
</script>

<style scoped>
.el-menu{
    border-right: none;
}
.html{
    height: 100%;
}
.body{
    height: 100%;
}
.home-container{
    height: 100%;
}
.el-header{
    background-color: #545c64;
    display: flex;
    justify-content: space-between;
    align-items: center;
    color: #fff;
    font-size: 20px;
}
.el-header.div 
{
    display: flex;
    align-items: center;
}
.el-aside{
    background-color: #545c64;
}
.el-main{
    background-color: #eaedf1;
}
</style>
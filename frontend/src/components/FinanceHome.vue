<template>
    <el-container class="home-container">
    <!--头部-->
        <el-header>
            <div>
                <span>财务管理</span>
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
      <el-menu-item :index="item.path+''" v-for="item in show" :key="item.id" @click="saveNavState(item.path)">
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
        if(!window.sessionStorage.getItem('activePath'))
        this.activePath = '/financehome'
        else
        this.activePath = window.sessionStorage.getItem('activePath')
    },
    data(){
        return{
            show:[
                {
                "id":101,
                "authName":"首页",
                "path":"/financehome"
                },
                {
                "id":102,
                "authName":"对账查账",
                "path":"/financeadd"
                }],
            activePath:'/financehome'
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
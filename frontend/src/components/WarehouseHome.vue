<template>
    <el-container class="home-container">
    <!--头部-->
        <el-header>
            <div>
                <span>仓库管理</span>
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
        if(!window.sessionStorage.getItem('activePath'))
        this.activePath = '/WareHouseHome'
        else
        this.activePath = window.sessionStorage.getItem('activePath')
        if(window.sessionStorage.getItem("StaffPosition")=="仓库人员")
        this.flag=true
        else
        this.flag=false
    },
    data(){
        return{
            show:[
                {
                "id":101,
                "authName":"首页",
                "path":"/WareHouseHome"
                },
                {
                "id":102,
                "authName":"查看入库申请单",
                "path":"/WHApplication"
                },
                {
                "id":103,
                "authName":"查看入库单",
                "path":"/WHInSheet"
                },
                {
                "id":104,
                "authName":"库存查询",
                "path":"/WHStoreQuery"
                },
                {
                "id":105,
                "authName":"待发货订单",
                "path":"/WHRemainOut"
                },
                {
                "id":106,
                "authName":"出库记录",
                "path":"/WHOutRecord"
                }
                ],
                showManager:[
                {
                "id":107,
                "authName":"首页",
                "path":"/WareHouseHome"
                },
                {
                    "id":108,
                    "authName":"查看&审核入库申请单",
                    "path":"/WHApplication"
                },
                {
                    "id":109,
                    "authName":"查看入库单",
                    "path":"/WHInSheet"
                },
                {
                    "id":110,
                    "authName":"库存查询",
                    "path":"/WHStoreQuery"
                },
                {
                    "id":111,
                    "authName":"查看审核出库单",
                    "path":"/WHOutRecord"
                },
                ],
            activePath:'/WareHouseHome',
            flag:'',
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
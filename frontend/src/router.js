import Vue from 'vue'
import Router from 'vue-router'
import Login from './components/Login'
import WSHome from './components/WorkShopHome'
import FHome from './components/FinanceHome'
import AdminHome from './components/AdminHome'
import SalesHome from './components/SalesHome'
import WarehouseHome from './components/WarehouseHome'
import WorkShopHome from './components/WorkShop/Home'
import WorkShopAdd from './components/WorkShop/Add'
import WorkShopSee from './components/WorkShop/See'
import FinanceHome from './components/Finance/Home'
import FinanceAdd from './components/Finance/Add'
import AdminRegister from './components/Admin/Register'
import AdminRevise from './components/Admin/Revise'
import AdminDelete from './components/Admin/Delete'
import AdminHOME from './components/Admin/Home'
import AdminProducts from './components/Admin/Product'
import WareHouseHome from './components/Warehouse/Home'
import WHApplication from './components/Warehouse/Application'
import WHInSheet from './components/Warehouse/InSheet'
import WHOutRecord from './components/Warehouse/OutRecord'
import WHRemainOut from './components/Warehouse/RemainOut'
import WHStoreQuery from './components/Warehouse/StoreQuery' 
import SHome from './components/Sales/Home'
import ClientInfo from './components/Sales/ClientInfo'
import FaHuoSheet from './components/Sales/FaHuoSheet'
import SalesSheetQuery from './components/Sales/SalesSheetQuery'
import WriteSales from './components/Sales/WriteSales'
import RemainAudit from './components/Sales/RemainAudit'
Vue.use(Router)

const router = new Router({
  routes:[
    { 
      path:'/',
      redirect:'/login' 
    },
    { 
      path:'/login',
      component:Login 
    },
    { 
      path:'/wshome',
      component:WSHome,
      redirect:'/workshophome', //'/' + window.sessionStorage.getItem('position') + 'home',
      children:[
        { 
          path:'/workshophome', 
          component:WorkShopHome
        },
        { 
          path:'/workshopadd', 
          component:WorkShopAdd
        },
        { 
          path:'/workshopsee', 
          component:WorkShopSee
        }
      ] 
    },
    { 
      path:'/fhome',
      component:FHome,
      redirect:'/financehome',
      children:[
        { 
          path:'/financehome', 
          component:FinanceHome
        },
        { 
          path:'/financeadd', 
          component:FinanceAdd
        }
      ] 
    },
    {
      path:'/adminhome',
      component:AdminHome,
      redirect:'/Adminhome',
      children:[
        {
          path:'/Adminhome',
          component:AdminHOME
        },
        {
          path:'/AdminRegister',
          component:AdminRegister
        },
        {
          path:'/AdminRevise',
          component:AdminRevise
        },
        {
          path:'/AdminDelete',
          component:AdminDelete
        },
        {
          path:'/Products',
          component:AdminProducts
        }
      ]
    },
    {
      path:'/WarehouseHome',
      component:WarehouseHome,
      redirect:'/WareHouseHome',
      children:[
       {
          path:'/WareHouseHome',
          component:WareHouseHome
       },
       {

        path:'/WHApplication',
        component:WHApplication
       },
       {

        path:'/WHInSheet',
        component:WHInSheet
       },
       {

        path:'/WHOutRecord',
        component:WHOutRecord
       },
       {
         path:'/WHRemainOut',
         component:WHRemainOut
       },
       {
         path:'/WHStoreQuery',
         component:WHStoreQuery
       }
      ]

    },
    {
      path:'/Sales',
      component:SalesHome,
      redirect:'/SalesHome',
      children:[
        {
          path:'/SalesHome',
          component:SHome
        },
        {
          path:"/ClientInfo",
          component:ClientInfo
        },
        {
          path:'/FaHuoSheet',
          component:FaHuoSheet
        },
        {
          path:"/SalesSheetQuery",
          component:SalesSheetQuery
        },
        {
          path:'/WriteSales',
          component:WriteSales
        },
        {
          path:'/RemainAudit',
          component:RemainAudit
        }
      ]
    }
  ]
})

router.beforeEach((to,from,next) => {
  if(to.path === '/login') return next()
  const tokenStr = window.sessionStorage.getItem('token')
  if(!tokenStr) return next('/login')
  next()
})

export default router
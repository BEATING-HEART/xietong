<template>
    <div>
        <el-row :gutter="20">
            <el-col :span="12">
                <el-card class="left-card">
                    <el-container class="search">
                <el-autocomplete
                    class="inline-input"
                    v-model="companyname"
                    :fetch-suggestions="querySearch"
                    placeholder="请输入公司名"
                    @select="handleSelect"
                ></el-autocomplete>
                <el-date-picker
                        v-model="date"
                        type="month"
                        placeholder="选择月"
                        class="date">
                    </el-date-picker>
                    <el-button type="primary" @click="search">确认</el-button>
                    </el-container>
                    <el-divider></el-divider>
                    <el-card class="balance">
                        <el-container class="search1">
                            <span>上月结余：</span>
                            <span>{{balancelast}}</span>
                        </el-container>
                    </el-card>
                    <el-divider></el-divider>
                    <el-card class="detail" v-for="item in bill" :key="item.name">
                        <div slot="header" class="clearfix">
                        <span>{{item.name}}</span>
                        <span style="float: right; padding: 3px 0">{{item.balance}}</span>
                        </div>
                        <div>
                            {{item.date}}
                        </div>
                    </el-card>
                    <h3 style="float:right">合计:{{balancenow}}</h3>
                </el-card>
            </el-col>
            <el-col :span="12">
                <el-card class="right-card">
                <el-card class="k">
                    <div slot="header" class="clearfix">
                        <span>当月总账</span>
                        <span style="float: right; padding: 3px 0">+30</span>
                        </div>
                        <div>
                            <span style="margin-right:200px">总入账：+50</span>
                            <span>总出账：-20</span>
                        </div>
                </el-card>
                        <el-row :gutter="20">
                        <el-col :span="12">
                        <el-card class="box-card">
                        <div slot="header" class="clearfix">
                            <span>当季总账</span>
                            <span style="float: right; padding: 3px 0">+30</span>
                        </div>
                        <div>总入账：+50</div>
                        <div>总出账：-20</div>
                        </el-card>
                        </el-col>
                        <el-col :span="12">
                        <el-card class="box-card">
                        <div slot="header" class="clearfix">
                            <span>当年总账</span>
                            <span style="float: right; padding: 3px 0">+30</span>
                        </div>
                        <div>总入账：+50</div>
                        <div>总出账：-20</div>
                        </el-card>
                        </el-col>
                        </el-row>
                        
                </el-card>
            </el-col>
        </el-row>
    </div>
</template>

<script>
export default{
    data() {
      return {
        restaurants: [],
        companyname: '',
        date:'',
        balancelast:'+20',
        balancenow:'+30',
        bill:[
            {
                name:'asdas',
                date:'2000.1.2',
                balance:'+30',
                id:'1'
            },
            {
                name:'das',
                date:'0320.2.2',
                balance:'-90',
                id:'2'
            },
            {
                name:'dsa',
                date:'6515.23.5',
                balance:'+100',
                id:'3'
            },
            {
                name:'dsa',
                date:'6515.23.5',
                balance:'+100',
                id:'3'
            }
        ]
      };
    },
    methods: {
      querySearch(queryString, cb) {
        var restaurants = this.restaurants;
        var results = queryString ? restaurants.filter(this.createFilter(queryString)) : restaurants;
        // 调用 callback 返回建议列表的数据
        cb(results);
      },
      createFilter(queryString) {
        return (restaurant) => {
          return (restaurant.value.toLowerCase().indexOf(queryString.toLowerCase()) === 0);
        };
      },
      loadAll() {
        return [
          {"value": "A公司"},
          {"value": "B公司"}
        ];
      },
      handleSelect(item) {
        console.log(item);
      },
      search(){
          console.log(this.companyname)
      }
    },
    mounted() {
      this.restaurants = this.loadAll();
    }
}
</script>

<style scoped>
.left-card{
    height: 100%;
}
.right-card{
    height: 100%;
}
.search{
    display: flex;
    margin-bottom: 10px;
}
.balance{
    display: flex;
    margin-bottom: 10px;
}
.k{
    margin-bottom: 10px;
}
.el-autocomplete{
    margin-right: 50px;
}
.el-date-picker{
    margin-right: 50px;
}
.el-button{
    margin-left: 50px;
}
.search1{
    display: flex;
    justify-content: space-between;
}
.detail{
    margin-bottom: 10px;
}
</style>
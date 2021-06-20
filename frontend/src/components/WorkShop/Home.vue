<template>
    <div>
        <h2>待办事项</h2>
        <el-row :gutter="20">
        <el-col :span="6" :index="item.id+''" v-for="item in history" :key="item.id">
        <el-card class="box-card">
            <div slot="header" class="clearfix">
                <span>{{item.detail}}</span>
                <!-- <el-button style="float: right; padding: 3px 0" type="text">操作按钮</el-button> -->
            </div>
        <div>时间：{{item.data}}</div>
        <div>金额：{{item.amount}}</div>
        </el-card>
        </el-col>
        </el-row>
        <el-divider></el-divider>
        <h2>历史操作</h2>
        <el-row :gutter="20">
        <el-col :span="6" :index="item.id+''" v-for="item in history" :key="item.id">
        <el-card class="box-card">
            <div slot="header" class="clearfix">
                <span>{{item.detail}}</span>
                <!-- <el-button style="float: right; padding: 3px 0" type="text">操作按钮</el-button> -->
            </div>
        <div>时间：{{item.data}}</div>
        <div>金额：{{item.amount}}</div>
        </el-card>
        </el-col>
        </el-row>
    </div>
</template>

<script>
export default {
    data(){
        return{
            new:[{
                detail:'a向b汇款',
                data:'2021.1.2',
                id:'1'
            },
            {
                detail:'c向d汇款',
                data:'2021.1.8',
                id:'2'
            }
            ],
            history:[{
                detail:'a向c汇款',
                data:'2021.1.4',
                id:'3',
                amount:'20'
            },
            {
                detail:'aew向feb汇款',
                data:'2021.1.9',
                id:'4',
                amount:'20'
            },
            {
                detail:'aeasdw向fedsab汇款',
                data:'2021.1.d9',
                id:'12',
                amount:'20'
            },
            {
                detail:'aedasw向fedsab汇款',
                data:'2021.1.19',
                id:'32',
                amount:'20'
            }
            ]
        }
    }
}
</script>

<style scoped>
.el-card{
    margin-bottom: 20px;
}
</style>

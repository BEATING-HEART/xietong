<template>
    <div>
        <h2>待办事项</h2>
        <el-row :gutter="20">
        <el-col :span="6" :index="item.id+''" v-for="item in ToDo" :key="item.id">
        <el-card class="box-card">
            <div slot="header" class="clearfix">
                <span>{{item.detail}}</span>
                <!-- <el-button style="float: right; padding: 3px 0" type="text">操作按钮</el-button> -->
            </div>
        <div>单号：{{item.sheetid}}</div>
        <div>时间：{{item.time}}</div>
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
        <div>单号：{{item.sheetid}}</div>
        <div>时间：{{item.time}}</div>
        </el-card>
        </el-col>
        </el-row>
    </div>
</template>

<script>
export default {
    data(){
        return{
            ToDo:[{
                detail:'有新的入库申请单(未处理)',
                time:'2021.1.2',
                sheetid:'190812',
                id:'1'
            },
            {
                detail:'有新的入库申请单(审核通过)',
                time:'2021.1.8',
                sheetid:'3123',
                id:'2'
            }
            ],
            history:[{
                detail:'核实入库申请单',
                time:'2021.6.18',
                sheetid:'3877',
                id:'3',
            },
            {
                detail:'核实入库申请单',
                time:'2021.6.18',
                sheetid:'4399',
                id:'4',
            },
            {
                detail:'核实入库申请单',
                time:'2021.6.17',
                sheetid:'250',
                id:'12',
            },
            {
                detail:'核实入库申请单',
                time:'2021.6.16',
                sheetid:'3123',
                id:'32',
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

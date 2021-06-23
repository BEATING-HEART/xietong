<template>
    <div class="contianer">
        <h2>查看入库申请单</h2>
        <el-card>
            <el-container>
            <el-input v-model="num" placeholder="请输入入库申请单号" style="margin-bottom: 20px;margin-right: 50px"></el-input>
            <el-button type="primary" @click="search" style="float:right;margin-bottom: 20px">查询</el-button>
            <el-button type="danger" @click="cancel" style="float:right;margin-bottom: 20px">取消</el-button>
            </el-container>
            <el-divider></el-divider>
            <el-table
                :data="tableData"
                style="width: 100%"
                :default-sort = "{prop: 'date', order: 'descending'}">
                <el-table-column
                    prop="sheetid"
                    label="入库申请单号">
                </el-table-column>
                <el-table-column
                    prop="date"
                    sortable
                    label="申请时间">
                </el-table-column>
                <el-table-column
                    prop="state"
                    label="申请状态"
                    sortable>
                </el-table-column>
                <el-table-column label="操作">
                    <template slot-scope="scope">
                        <el-button
                            size="mini"
                            type="warning"
                            @click="Detail(scope.$index, scope.row)">查看详情</el-button>
                            <el-button
                            size="mini"
                            type="danger"
                            @click="" v-if="Withdraw(scope.$index, scope.row)">撤回</el-button>
                    </template>
                </el-table-column>
            </el-table>
        </el-card>
        <el-dialog title="详情" :visible.sync="dialogFormVisible">
                <el-table
                    :data="detail"
                    style="width: 100%;margin-bottom: 20px">
                <el-table-column
                    prop="pname"
                    label="产品名">
                </el-table-column>
                <el-table-column
                    prop="pid"
                    label="产品号">
                </el-table-column>
                <el-table-column
                    prop="num"
                    label="车间号">
                </el-table-column>
                <el-table-column
                    prop="good"
                    label="良品">
                </el-table-column>
                <el-table-column
                    prop="bad"
                    label="次品">
                </el-table-column>
                <el-table-column
                    prop="total"
                    label="总计">
                </el-table-column>
                </el-table>
        </el-dialog>
    </div>
</template>

<script>
export default {
    created(){
        //获取申请单数据添加至tableData
    },
    data(){
        return{
            form:{
                date:'',
                sheetid:''
            },
            dialogFormVisible: false,
            detail:[],
            tableData: [{
                date: '2016-05-02',
                state: '审核中',
                sheetid:'104',
                data:[{pname: '螺丝1',
                pid: '123',
                num: '1',
                good:'12',
                bad:'23',
                total:'35'}]
            }, {
                date: '2016-05-04',
                state: '审核中',
                sheetid:'204',
                data:[{pname: '螺丝2',
                pid: '123',
                num: '1',
                good:'12',
                bad:'23',
                total:'35'}]
            }, {
                date: '2016-05-01',
                state: '已通过',
                sheetid:'3',
                data:[{pname: '螺丝3',
                pid: '123',
                num: '1',
                good:'12',
                bad:'23',
                total:'35'}]
            }, {
                date: '2016-05-03',
                state: '已通过',
                sheetid:'4',
                data:[{pname: '螺丝4',
                pid: '123',
                num: '2',
                good:'12',
                bad:'23',
                total:'35'}]
            }]
        }
    },
    methods:{
        search(){
            //修改申请单数据添加至tableData
        },
        cancel(){
            //重新获取完整申请单数据添加至tableData,注意车间人员只能看到自己的入库申请单不要返回全部申请单
        },
        Detail(row, detail){
            this.dialogFormVisible = true
            this.detail = detail.data
            console.log(this.detail)
        },
        Withdraw(row, detail){
            if(detail.state=="审核中")
            return true
            else if(detail.state=="已通过")
            return false
        }
    }
}
</script>

<style scoped>
.container{
    height: 650px;
}
.search{
    display: flex;
    margin-bottom: 10px;
}
</style>

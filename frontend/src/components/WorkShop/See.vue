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
                    prop="num"
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
                    prop="pnum"
                    label="产品号">
                </el-table-column>
                <el-table-column
                    prop="num"
                    label="批次号">
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
                num:''
            },
            dialogFormVisible: false,
            detail:[],
            tableData: [{
                date: '2016-05-02',
                state: '审核中',
                num:'1',
                data:[{pname: '螺丝1',
                pnum: '123',
                num: '567',
                good:'12',
                bad:'23',
                total:'123'}]
            }, {
                date: '2016-05-04',
                state: '审核中',
                num:'2',
                data:[{pname: '螺丝2',
                pnum: '123',
                num: '567',
                good:'12',
                bad:'23',
                total:'123'}]
            }, {
                date: '2016-05-01',
                state: '已通过',
                num:'3',
                data:[{pname: '螺丝3',
                pnum: '123',
                num: '567',
                good:'12',
                bad:'23',
                total:'123'}]
            }, {
                date: '2016-05-03',
                state: '已通过',
                num:'4',
                data:[{pname: '螺丝4',
                pnum: '123',
                num: '567',
                good:'12',
                bad:'23',
                total:'123'}]
            }]
        }
    },
    methods:{
        search(){
            //修改申请单数据添加至tableData
        },
        cancel(){
            //重新获取完整申请单数据添加至tableData
        },
        Detail(row, detail){
            this.dialogFormVisible = true
            this.detail = detail.data
            console.log(this.detail)
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

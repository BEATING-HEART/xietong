<template>
    <div class="contianer">
        <h2>查看入库申请单</h2>
        <el-card>
            <el-container>
            <el-input v-model="id" placeholder="请输入入库申请单号" style="margin-bottom: 20px;margin-right: 50px"></el-input>
            <el-button type="primary" @click="search" style="float:right;margin-bottom: 20px">查询</el-button>
            <el-button type="danger" @click="cancel" style="float:right;margin-bottom: 20px">取消</el-button>
            </el-container>
            <el-divider></el-divider>
            <el-table
                :data="tableData"
                style="width: 100%"
                :default-sort = "{prop: 'time', order: 'descending'}">
                <el-table-column
                    prop="warehousingApplicationId"
                    label="入库申请单号">
                </el-table-column>
                <el-table-column
                    prop="time"
                    sortable
                    label="申请时间">
                </el-table-column>
                <el-table-column
                    prop="statusStr"
                    label="申请状态"
                    sortable>
                </el-table-column>
                <el-table-column label="操作">
                    <template slot-scope="scope">
                        <el-button
                            size="mini"
                            type="warning"
                            @click="Detail(scope.$index, scope.row)">查看详情</el-button>
                            <!-- <el-button
                            size="mini"
                            type="danger"
                            @click="" v-if="Withdraw(scope.$index, scope.row)">撤回</el-button> -->
                    </template>
                </el-table-column>
            </el-table>
        </el-card>
        <el-dialog title="详情" :visible.sync="dialogFormVisible">
                <el-table
                    :data="detail"
                    style="width: 100%;margin-bottom: 20px">
                <el-table-column
                    prop="productName"
                    label="产品名">
                </el-table-column>
                <el-table-column
                    prop="productId"
                    label="产品号">
                </el-table-column>
                <el-table-column
                    prop="batchId"
                    label="车间号">
                </el-table-column>
                <el-table-column
                    prop="goodNum"
                    label="良品">
                </el-table-column>
                <el-table-column
                    prop="badNum"
                    label="次品">
                </el-table-column>
                <el-table-column
                    prop="totalNum"
                    label="总计">
                </el-table-column>
                </el-table>
        </el-dialog>
    </div>
</template>

<script>
export default {
    async created(){
     var url = 'http://39.103.202.215:8080/api/application/list';
      await this.$axios.get(url,{headers:{"Content-Type":"application/json"}})
      .then(({data: res})=>{
        console.log(res.data)
        this.tableData = res.data
      })
      .catch((error)=>{
          console.log(error)
      })   
    },
    data(){
        return{
            form:{
                time:'',
                warehousingApplicationId:''
            },
            dialogFormVisible: false,
            detail:[],
            id:'',
            tableData: [{
                time: '2016-05-02',
                statusStr: '审核中',
                warehousingApplicationId:'104',
                data:[{productName: '螺丝1',
                productId: '123',
                batchId: '1',
                goodNum:'12',
                badNum:'23',
                totalNum:'35'}]
            }, {
                time: '2016-05-04',
                statusStr: '审核中',
                warehousingApplicationId:'204',
                data:[{productName: '螺丝2',
                productId: '123',
                batchId: '1',
                goodNum:'12',
                badNum:'23',
                totalNum:'35'}]
            }, {
                time: '2016-05-01',
                statusStr: '已通过',
                warehousingApplicationId:'3',
                data:[{productName: '螺丝3',
                productId: '123',
                batchId: '1',
                goodNum:'12',
                badNum:'23',
                totalNum:'35'}]
            }, {
                time: '2016-05-03',
                statusStr: '已通过',
                warehousingApplicationId:'4',
                data:[{productName: '螺丝4',
                productId: '123',
                batchId: '2',
                goodNum:'12',
                badNum:'23',
                totalNum:'35'}]
            }]
        }
    },
    methods:{
        async search(){
            var url = 'http://39.103.202.215:8080/api/application/get/' + this.id;
            await this.$axios.get(url,{headers:{"Content-Type":"application/json"}})
            .then(({data: res})=>{
                console.log(res.data)
                var a = [
                    res.data
                ]
                this.tableData = a
                this.$message.success("查询成功")
            })
            .catch((error)=>{
                console.log(error)
                this.$message.error("查询失败")
            })   
        },
        async cancel(){
            var url = 'http://39.103.202.215:8080/api/application/list';
            await this.$axios.get(url,{headers:{"Content-Type":"application/json"}})
            .then(({data: res})=>{
                console.log(res.data)
                this.tableData = res.data
            })
            .catch((error)=>{
                console.log(error)
            }) 
        },
        Detail(row, detail){
            this.dialogFormVisible = true
            this.detail = detail.applicationProducts
            console.log(this.detail)
        },
        // Withdraw(row, detail){
        //     if(detail.statusStr=="审核中")
        //     return true
        //     else if(detail.statusStr=="已通过")
        //     return false
        // }
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

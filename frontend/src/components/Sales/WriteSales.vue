<template>
    <el-container>
  <el-header style="height:100px">
      <h3 align="center">销售单填写</h3>
      <el-button type="success" @click="Submit()" style="float:right;margin-bottom: 20px;margin-left: 20px">提交</el-button>
  </el-header>
  <el-divider style="80em"></el-divider>
  <el-main>
    <el-form ref="form" :model="submitform" label-width="100px">
      <el-row gutter="20">
        <el-col :span="12">
                        <el-form-item label="销售单单号:">
                            <el-input v-model="submitform.SalesSheetId" :readonly="true"></el-input>
                        </el-form-item>
                    </el-col>
                    <el-col :span="12">
                        <el-form-item label="销售员工号:">
                            <el-input v-model="submitform.StaffId" :readonly="true"></el-input>
                        </el-form-item>
                    </el-col>
                </el-row>
                <el-row gutter="20">
        <el-col :span="12">
                        <el-form-item label="客户姓名:">
                            <el-input v-model="submitform.CientName" placeholder="请填写客户姓名"></el-input>
                        </el-form-item>
                    </el-col>
                    <el-col :span="12">
                        <el-form-item label="销售员姓名:">
                            <el-input v-model="submitform.StaffName" :readonly="true"></el-input>
                        </el-form-item>
                    </el-col>
                </el-row>
                <el-divider></el-divider>
                <el-table
                    :data="tableData"
                    style="width: 100%;margin-bottom: 20px">
                <el-table-column
                    prop="pid"
                    label="产品号">
                </el-table-column>
                <el-table-column
                    prop="pname"
                    label="产品名">
                </el-table-column>
                <el-table-column
                    prop="amount"
                    label="数量">
                </el-table-column>
                <el-table-column
                    prop="price"
                    label="单价">
                </el-table-column>
                <el-table-column
                    prop="total"
                    label="小计">
                </el-table-column>
                <el-table-column label="更改" align="center">
                    <template slot-scope="scope">
                        <el-button
                            size="mini"
                            type="primary"
                            style="margin-right: 10px"
                            @click="Edit(scope.$index, scope.row)">编辑</el-button>
                        <el-button
                            size="mini"
                            type="danger"
                            @click="Delete(scope.$index, scope.row)">删除</el-button>
                    </template>
                </el-table-column>
                </el-table>
                <el-button type="primary" @click="Add()" style="float:right;margin-bottom: 20px;margin-left: 20px">添加产品</el-button>
                <br>
                <br>
                <el-divider></el-divider>
                <!-- 下面是批次表 -->
                <el-table
                    :data="BatchTable"
                    style="width: 100%;margin-bottom: 20px">
                <el-table-column
                    prop="batch"
                    label="发货批次">
                </el-table-column>
                <el-table-column
                    prop="pid"
                    label="产品编号">
                </el-table-column>
                <el-table-column
                    prop="pname"
                    label="产品名">
                </el-table-column>
                <el-table-column
                    prop="amount"
                    label="数量">
                </el-table-column>
                <el-table-column
                    prop="date"
                    label="时间">
                </el-table-column>
                <el-table-column
                    prop="status"
                    label="状态">
                </el-table-column>
                <el-table-column label="更改" align="center">
                    <template slot-scope="scope">
                        <el-button
                            size="mini"
                            type="primary"
                            style="margin-right: 10px"
                            @click="EditBatch(scope.$index, scope.row)">编辑</el-button>
                        <el-button
                            size="mini"
                            type="danger"
                            @click="DeleteBatch(scope.$index, scope.row)">删除</el-button>
                    </template>
                </el-table-column>
                </el-table>
                <el-button type="primary" @click="AddBatch()" style="float:right;margin-bottom: 20px;margin-left: 20px">填写发货批次</el-button>

    </el-form>


    <el-dialog title="产品信息" :visible.sync="dialogFormVisible">
            <el-form ref="form" :model="form" label-width="80px">
                <el-form-item label="产品号">
                    <el-autocomplete
                    class="inline-input"
                    v-model="product.pid"
                    :fetch-suggestions="querySearch"
                    :trigger-on-focus="false"
                    @select="handleSelect"
                ></el-autocomplete>
                </el-form-item>
                <el-form-item label="产品名">
                    <el-input v-model="product.pname" readonly="true"></el-input>
                </el-form-item>
                <el-form-item label="数量">
                    <el-input v-model="product.amount"></el-input>
                </el-form-item>
                <el-form-item label="单价">
                    <el-input v-model="product.price"></el-input>
                </el-form-item>
                <el-form-item label="总计">
                    <el-input v-model="product.total" :disabled="true"></el-input>
                </el-form-item>
            </el-form>
            <div slot="footer" class="dialog-footer">
                <el-button @click="dialogFormVisible = false">取消</el-button>
                <el-button type="primary" @click="confirm()">确定</el-button>
            </div>
        </el-dialog>

        <el-dialog title="发货批次填写" :visible.sync="BatchVisible">
            <el-form ref="form" :model="Batchform" label-width="80px">
              <el-form-item label="发货批次">
                    <el-input v-model="Batch.batch" ></el-input>
                </el-form-item>
                <el-form-item label="产品号">
                    <el-autocomplete
                    class="inline-input"
                    v-model="Batch.pid"
                    :fetch-suggestions="querySearch"
                    :trigger-on-focus="false"
                    @select="handleSelectBatch"
                ></el-autocomplete>
                </el-form-item>
                <el-form-item label="产品名">
                    <el-input v-model="Batch.pname" readonly="true"></el-input>
                </el-form-item>
                <el-form-item label="数量">
                    <el-input v-model="Batch.amount"></el-input>
                </el-form-item>
                <el-form-item label="发货状态">
                    <el-input v-model="Batch.status"></el-input>
                </el-form-item>
                <el-date-picker type="date" placeholder="选择日期" v-model="Batch.date" style="width: 100%;"
                format="yyyy 年 MM 月 dd 日" value-format="yyyy-MM-dd"></el-date-picker>
            </el-form>
            <div slot="footer" class="dialog-footer">
                <el-button @click="BatchVisible = false">取消</el-button>
                <el-button type="primary" @click="confirmBatch()">确定</el-button>
            </div>
        </el-dialog>
  </el-main>
</el-container>
</template>


<script>
import qs from 'qs'
export default{
    created(){
        this.submitform.StaffId = window.sessionStorage.getItem('StaffId')
        this.submitform.StaffName = window.sessionStorage.getItem('StaffName')
        console.log(qs.stringify(this.submitform))
    },
    data(){
        return{
            productIndex: [],
            submitform:{
                StaffId:'',
                StaffName:'',
                SalesSheetId:'',
                CientName:'',
                tableData: [{
                pid:'',
                pname: '',
                amount: '',
                price:'',
                total:''
            }],
                BatchTable:[
                    {
                batch:'',
                pid:'',
                pname:'',
                amount:'',
                date:'',
                status:''
            }
                ]
            },
            tableData: [],
            BatchTable:[],
            product:{
                pid:'',
                pname: '',
                amount: '',
                price:'',
                total:'',
                row:0,
                type:''
            },
            Batch:{
                batch:'',
                // 此处的product应该是个数组
                pid:'',
                pname:'',
                amount:'',
                date:'',
                status:'',
                row:0,
                type:''
            },
            dialogFormVisible: false,
            BatchVisible:false,
            flag:true
        }
    },
    methods:{
        Edit(row, detail){
            this.dialogFormVisible = true
            this.product.pid = detail.pid
            this.product.pname = detail.pname
            this.product.amount = detail.amount
            this.product.price = detail.price
            this.product.total = detail.total
            this.product.row = row
            this.product.type = 'edit'
        },
        EditBatch(row, detail){
            this.BatchVisible = true
            this.Batch.batch=detail.batch
            this.Batch.pid = detail.pid
            this.Batch.pname = detail.pname
            this.Batch.amount = detail.amount
            this.Batch.date=detail.date
            this.Batch.row = row
            this.Batch.status=detail.status
            this.Batch.type = 'edit'
        },
         Delete(row,index)
        {
        this.$confirm('此操作将永久删除该记录, 是否继续?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
            this.tableData.splice(row,1)
          this.$message({
            type: 'success',
            message: '删除成功!'
          });
        }).catch(() => {
          this.$message({
            type: 'info',
            message: '已取消删除'
          });          
        });
      },
      DeleteBatch(row,index)
        {
        this.$confirm('此操作将永久删除该记录, 是否继续?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
            this.BatchTable.splice(row,1)
          this.$message({
            type: 'success',
            message: '删除成功!'
          });
        }).catch(() => {
          this.$message({
            type: 'info',
            message: '已取消删除'
          });          
        });
      },
        Add(){
            this.dialogFormVisible = true
            this.product.pid = ''
            this.product.pname = ''
            this.product.amount = ''
            this.product.price = ''
            this.product.total = ''
            this.product.row = ''
            this.product.type = 'add'
        },
        AddBatch(){
            this.BatchVisible = true
            this.Batch.batch=''
            this.Batch.pid = ''
            this.Batch.pname = ''
            this.Batch.amount = ''
            this.Batch.date=''
            this.Batch.status='0',
            this.Batch.row = ''
            this.Batch.type = 'add'
        },
        confirm(){
            if(this.product.type == 'add'){
                this.tableData.push({
                    pname: this.product.pname,
                    pid: this.product.pid,
                    amount: this.product.amount,
                    price: this.product.price,
                    total: parseInt(this.product.amount) * parseInt(this.product.price),
                    row: this.product.row
                })
            }
            else{
                this.$set(this.tableData,this.product.row,{
                    pname: this.product.pname,
                    pid: this.product.pid,
                    amount: this.product.amount,
                    price: this.product.price,
                    total: parseInt(this.product.amount) * parseInt(this.product.price),
                    row: this.product.row
                })
            }
            this.dialogFormVisible = false;
        },
        confirmBatch(){
            if(this.Batch.type == 'add'){
                this.BatchTable.push({
                    batch: this.Batch.batch,
                    pid: this.Batch.pid,
                    pname:this.Batch.pname,
                    amount: this.Batch.amount,
                    date:this.Batch.date,
                    row: this.Batch.row,
                    status:this.Batch.status,
                })
                console.log(this.Batch.date)
            }
            else{
                this.$set(this.BatchTable,this.Batch.row,{
                    batch: this.Batch.batch,
                    pid: this.Batch.pid,
                    pname:this.Batch.pname,
                    amount: this.Batch.amount,
                    date:this.Batch.date,
                    row: this.Batch.row,
                    status:this.Batch.status
                })
            }
            this.BatchVisible = false;
        },
        Submit(){
            //提交数据
        },
        querySearch(queryString, cb) {
        var productIndex = this.productIndex;
        var results = queryString ? productIndex.filter(this.createFilter(queryString)) : productIndex;
        // 调用 callback 返回建议列表的数据
        cb(results);
      },
      createFilter(queryString) {
        return (pIndex) => {
          return (pIndex.value.toLowerCase().indexOf(queryString.toLowerCase()) === 0);
        };
      },
      loadAll() {
        return [
          { value: "123456","address":"齿轮"},
          { value: "234567","address":"大齿轮"}
        ];
      },
      handleSelect(item) {
        this.product.pname=item.name;
      },
      handleSelectBatch(item) {
        this.Batch.pname=item.name;
      },
    },
    mounted() {
        const a =[
          { value: "123456","name":"齿轮"},
          { value: "234567","name":"大齿轮"}
        ]
      this.productIndex = a
    }
}
</script>

<style>
  .demo-table-expand {
    font-size: 0;
  }
  .demo-table-expand label {
    width: 90px;
    color: #99a9bf;
  }
  .demo-table-expand .el-form-item {
    margin-right: 0;
    margin-bottom: 0;
    width: 50%;
  }
</style>

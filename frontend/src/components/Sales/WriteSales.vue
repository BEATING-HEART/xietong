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
                  <el-autocomplete
                    class="inline-input"
                    v-model="submitform.CientName"
                    placeholder="请填写客户姓名"
                    :fetch-suggestions="querySearchClient"
                    :trigger-on-focus="false"
                    @select="handleSelectClient"
                ></el-autocomplete>
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
                    prop="productId"
                    label="产品号">
                </el-table-column>
                <el-table-column
                    prop="pname"
                    label="产品名">
                </el-table-column>
                <el-table-column
                    prop="num"
                    label="数量">
                </el-table-column>
                <el-table-column
                    prop="unitPrice"
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
                    prop="shipmentNum"
                    label="发货批次">
                </el-table-column>
                <el-table-column
                    prop="productId"
                    label="产品编号">
                </el-table-column>
                <el-table-column
                    prop="pname"
                    label="产品名">
                </el-table-column>
                <el-table-column
                    prop="num"
                    label="数量">
                </el-table-column>
                <el-table-column
                    prop="time"
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
                <br>
                <br>
            <el-divider></el-divider>
                        <el-form-item label="销售单备注:">
                            <el-input v-model="submitform.remarks"></el-input>
                        </el-form-item>
    </el-form>


    <el-dialog title="产品信息" :visible.sync="dialogFormVisible">
            <el-form ref="form" :model="form" label-width="80px">
                <el-form-item label="产品号">
                    <el-autocomplete
                    class="inline-input"
                    v-model="product.productId"
                    :fetch-suggestions="querySearchProduct"
                    :trigger-on-focus="false"
                    @select="handleSelectProduct"
                ></el-autocomplete>
                </el-form-item>
                <el-form-item label="产品名">
                    <el-input v-model="product.pname" readonly="true"></el-input>
                </el-form-item>
                <el-form-item label="数量">
                    <el-input v-model="product.num"></el-input>
                </el-form-item>
                <el-form-item label="单价">
                    <el-input v-model="product.unitPrice"></el-input>
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
                    <el-input v-model="Batch.shipmentNum" ></el-input>
                </el-form-item>
                <el-form-item label="产品号">
                    <el-autocomplete
                    class="inline-input"
                    v-model="Batch.productId"
                    :fetch-suggestions="querySearchProduct"
                    :trigger-on-focus="false"
                    @select="handleSelectBatch"
                ></el-autocomplete>
                </el-form-item>
                <el-form-item label="产品名">
                    <el-input v-model="Batch.pname" readonly="true"></el-input>
                </el-form-item>
                <el-form-item label="数量">
                    <el-input v-model="Batch.num"></el-input>
                </el-form-item>
                <el-form-item label="发货状态">
                    <el-input v-model="Batch.status"></el-input>
                </el-form-item>
                <el-date-picker type="time" placeholder="选择日期" v-model="Batch.time" style="width: 100%;"
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
                remarks:'',
                tableData: [{
                productId:'',
                pname: '',
                num: '',
                unitPrice:'',
                total:''
            }],
                BatchTable:[
                    {
                shipmentNum:'',
                productId:'',
                pname:'',
                num:'',
                time:'',
                status:''
            }
                ]
            },
            tableData: [],
            BatchTable:[],
            Clients:[],
            product:{
                productId:'',
                pname: '',
                num: '',
                unitPrice:'',
                total:'',
                row:0,
                type:''
            },
            Batch:{
                shipmentNum:'',
                // 此处的product应该是个数组
                productId:'',
                pname:'',
                num:'',
                time:'',
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
            this.product.productId = detail.productId
            this.product.pname = detail.pname
            this.product.num = detail.num
            this.product.unitPrice = detail.unitPrice
            this.product.total = detail.total
            this.product.row = row
            this.product.type = 'edit'
        },
        EditBatch(row, detail){
            this.BatchVisible = true
            this.Batch.shipmentNum=detail.shipmentNum
            this.Batch.productId = detail.productId
            this.Batch.pname = detail.pname
            this.Batch.num = detail.num
            this.Batch.time=detail.time
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
            this.product.productId = ''
            this.product.pname = ''
            this.product.num = ''
            this.product.unitPrice = ''
            this.product.total = ''
            this.product.row = ''
            this.product.type = 'add'
        },
        AddBatch(){
            this.BatchVisible = true
            this.Batch.shipmentNum=''
            this.Batch.productId = ''
            this.Batch.pname = ''
            this.Batch.num = ''
            this.Batch.time=''
            this.Batch.status='0',
            this.Batch.row = ''
            this.Batch.type = 'add'
        },
        confirm(){
            if(this.product.type == 'add'){
                this.tableData.push({
                    pname: this.product.pname,
                    productId: this.product.productId,
                    num: this.product.num,
                    unitPrice: this.product.unitPrice,
                    total: parseInt(this.product.num) * parseInt(this.product.unitPrice),
                    row: this.product.row
                })
            }
            else{
                this.$set(this.tableData,this.product.row,{
                    pname: this.product.pname,
                    productId: this.product.productId,
                    num: this.product.num,
                    unitPrice: this.product.unitPrice,
                    total: parseInt(this.product.num) * parseInt(this.product.unitPrice),
                    row: this.product.row
                })
            }
            this.dialogFormVisible = false;
        },
        confirmBatch(){
            if(this.Batch.type == 'add'){
                this.BatchTable.push({
                    shipmentNum: this.Batch.shipmentNum,
                    productId: this.Batch.productId,
                    pname:this.Batch.pname,
                    num: this.Batch.num,
                    time:this.Batch.time,
                    row: this.Batch.row,
                    status:this.Batch.status,
                })
                console.log(this.Batch.time)
            }
            else{
                this.$set(this.BatchTable,this.Batch.row,{
                    shipmentNum: this.Batch.shipmentNum,
                    productId: this.Batch.productId,
                    pname:this.Batch.pname,
                    num: this.Batch.num,
                    time:this.Batch.time,
                    row: this.Batch.row,
                    status:this.Batch.status
                })
            }
            this.BatchVisible = false;
        },
        Submit(){
            var a = this.tableData
            a.forEach(function(item){
                delete item.pname
                delete item.total
                delete item.row
            })
            var b = this.BatchTable
            b.forEach(function(item){
                delete item.pname
                delete item.status
                delete item.row
                delete item.type
            })
            var tmp = {
            "sellerId":this.submitform.StaffId,
            "customerId":this.submitform.CientName,
            "remarks":this.submitform.remarks,
            "salesProduct":a,
            "shipment":b
            }
            console.log(tmp)
            var url = 'http://39.103.202.215:8080/api/sale/insertSaleOrder';
                this.$axios.post(url,tmp)
                .then(res=>{
                    console.log(res)
                    this.$message.success('添加成功');
                    this.applicationProducts = []
                })
                .catch(error=>{
                    console.log(error)
                    this.$message.error('添加失败');
                })
        },
        querySearchProduct(queryString, cb) {
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
      querySearchClient(queryString, cb) {
        var Clients = this.Clients;
        var results = queryString ? Clients.filter(this.createFilter(queryString)) : Clients;
        // 调用 callback 返回建议列表的数据
        cb(results);
      },
      loadAll() {
        return [
          { value: "123456","address":"齿轮"},
          { value: "234567","address":"大齿轮"}
        ];
      },
      handleSelectProduct(item) {
        this.product.pname=item.name;
      },
      handleSelectBatch(item) {
        this.Batch.pname=item.name;
      },
      handleSelectClient(item) {
        this.submitform.CientName=item.clientid;
      },
    },
    mounted() {      
        const client =[
          { value: "张义阳","clientid":"10114032"},
          { value: "天慧龙","clientid":"10114033"}
        ]
        this.Clients=client
        var url = 'http://39.103.202.215:8080/api/product/list';
        this.$axios.post(url)
        .then(res=>{
            console.log(res.data.data)
            var a = res.data.data
                a.forEach(function (item) {
                    item.value = String(item.productId)
                    delete item.productId
                    item.name = String(item.productName)
                    delete item.productName
        })
            this.productIndex = a
        });
      console.log(a)
    //     const a =[
    //       { value: "123456","name":"齿轮"},
    //       { value: "234567","name":"大齿轮"}
    //     ]
    //   this.productIndex = a

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

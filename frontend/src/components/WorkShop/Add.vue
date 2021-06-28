<template>
    <div class="contianer">
        <h2>填写入库申请单</h2>
        <el-card>
            <el-form ref="form" :model="form" label-width="80px">
                <el-row :gutter="20">
                    <el-col :span="12">
                        <el-form-item label="工号:">
                            <el-input v-model="form.StaffId" :disabled="true"></el-input>
                        </el-form-item>
                    </el-col>
                    <el-col :span="12">
                        <el-form-item label="姓名:">
                            <el-input v-model="form.StaffName" :disabled="true"></el-input>
                        </el-form-item>
                    </el-col>
                </el-row>
                <el-table
                    :data="applicationProducts"
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
                <el-table-column label="操作">
                    <template slot-scope="scope">
                        <el-button
                            size="mini"
                            type="danger"
                            style="margin-right: 10px"
                            @click="Edit(scope.$index, scope.row)">编辑</el-button>
                        <el-button
                            size="mini"
                            type="danger"
                            @click="Delete(scope.$index, scope.row)">删除</el-button>
                    </template>
                </el-table-column>
                </el-table>
                <el-button type="primary" @click="Add" style="float:right;margin-bottom: 20px;margin-left: 20px">添加</el-button>
                <el-button type="success" @click="Submit" style="float:right;margin-bottom: 20px;margin-left: 20px">提交</el-button>
            </el-form>
        </el-card>
        <el-dialog title="产品信息" :visible.sync="dialogFormVisible">
            <el-form ref="form" :model="form" label-width="80px">
                <el-form-item label="产品号">
                    <el-autocomplete
                    class="inline-input"
                    v-model="tmp.productId"
                    :fetch-suggestions="querySearch"
                    :trigger-on-focus="false"
                    @select="handleSelect"
                    @blur.native.capture="losefocus"
                ></el-autocomplete>
                </el-form-item>
                <!-- 
                    <el-input v-model="tmp.productId"></el-input>
                </el-form-item> -->
                <el-form-item label="产品名">
                    <el-input v-model="tmp.productName" disabled></el-input>
                </el-form-item>
                <el-form-item label="车间号">
                    <el-input v-model="tmp.batchId"></el-input>
                </el-form-item>
                <el-form-item label="良品">
                    <el-input v-model="tmp.goodNum"></el-input>
                </el-form-item>
                <el-form-item label="次品">
                    <el-input v-model="tmp.badNum"></el-input>
                </el-form-item>
                <!-- <el-form-item label="总计">
                    <el-input v-model="tmp.totalNum" disabled></el-input>
                </el-form-item> -->
            </el-form>
            <div slot="footer" class="dialog-footer">
                <el-button @click="dialogFormVisible = false">取消</el-button>
                <el-button type="primary" @click="confirm">确定</el-button>
            </div>
        </el-dialog>
    </div>
</template>

<script>
export default{
    created(){
        console.log(this.loadAll)
        this.form.StaffId = window.sessionStorage.getItem('StaffId')
        this.form.StaffName = window.sessionStorage.getItem('StaffName')
        // var url = 'http://39.103.202.215:8080/api/product/list';
        // this.$axios.post(url, {headers:{'authorities':window.sessionStorage.getItem('token')}})
        // .then(res=>{
        //     console.log(res.data.data)
        //     this.loadAll = res.data.data
        //     console.log(this.loadAll)
        // });
    },
    data(){
        return{
            restaurants: [],
            form:{
                StaffId:'',
                StaffName:''
            },
            applicationProducts: [],
            tmp:{
                productName: '',
                productId: '',
                batchId: '',
                goodNum:'',
                badNum:'',
                totalNum:'',
                row:0,
                type:''
            },
            dialogFormVisible: false,
            flag:true
        }
    },
    methods:{
        Edit(row, detail){
            this.dialogFormVisible = true
            console.log(row)
            console.log(detail)
            this.tmp.productName = detail.productName
            this.tmp.productId = detail.productId
            this.tmp.batchId = detail.batchId
            this.tmp.goodNum = detail.goodNum
            this.tmp.badNum = detail.badNum
            this.tmp.totalNum = detail.totalNum
            this.tmp.row = row
            this.tmp.type = 'edit'
        },
         Delete(row,index)
        // {
        //     console.log(index)
        //     console.log(row)
        //     this.applicationProducts.splice(row,1)
        // }
        {
        this.$confirm('此操作将永久删除该记录, 是否继续?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
            this.applicationProducts.splice(row,1)
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
            this.tmp.productName = ''
            this.tmp.productId = ''
            this.tmp.batchId = ''
            this.tmp.goodNum = ''
            this.tmp.badNum = ''
            this.tmp.totalNum = ''
            this.tmp.row = ''
            this.tmp.type = 'add'
        },
        confirm(){
            console.log(this.tmp.row)
            if(this.tmp.type == 'add'){
                this.applicationProducts.push({
                    productName: this.tmp.productName,
                    productId: this.tmp.productId,
                    batchId: this.tmp.batchId,
                    goodNum: this.tmp.goodNum,
                    badNum: this.tmp.badNum,
                    totalNum: parseInt(this.tmp.goodNum) + parseInt(this.tmp.badNum),
                    row: this.tmp.row
                })
                console.log(this.tmp)
                console.log(this.applicationProducts)
                console.log('增加')
            }
            else{
                this.$set(this.applicationProducts,this.tmp.row,{
                    productName: this.tmp.productName,
                    productId: this.tmp.productId,
                    batchId: this.tmp.batchId,
                    goodNum: this.tmp.goodNum,
                    badNum: this.tmp.badNum,
                    totalNum: parseInt(this.tmp.goodNum) + parseInt(this.tmp.badNum),
                    row: this.tmp.row
                })
                console.log(this.applicationProducts)
                console.log(this.tmp)
                console.log('修改')
            }
            this.dialogFormVisible = false;
        },
        Submit(){
            var tmp = {
                "applicationProducts":this.applicationProducts,
                "warehousingApplicationId": this.form.StaffId
                }
            var url = 'http://39.103.202.215:8080/api/application/insert';
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
            // 向后端提交数据时除了表格里有的数据(车间号等),还要提交当前的系统时间yyyy-mm-dd
            //提交数据
        },
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
          { value: "123456","address":"齿轮"},
          { value: "234567","address":"大齿轮"}
        ];
      },
      handleSelect(item) {
        this.tmp.productName=item.address;
      },
      losefocus(){

      }
    },
    mounted() {
        var url = 'http://39.103.202.215:8080/api/product/list';
        this.$axios.post(url)
        .then(res=>{
            console.log(res.data.data)
            var a = res.data.data
                a.forEach(function (item) {
                    item.value = String(item.productId)
                    delete item.productId
                    item.address = String(item.productName)
                    delete item.productName
        })
            this.restaurants = a
        });
      console.log(a)
    }
}
</script>

<style scoped>
.container{
    height: 650px;
}
</style>

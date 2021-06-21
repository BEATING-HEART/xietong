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
                    :data="tableData"
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
                <el-button type="success" @click="Submit" style="float:right;margin-bottom: 20px;margin-left: 20px">完成</el-button>
            </el-form>
        </el-card>
        <el-dialog title="产品信息" :visible.sync="dialogFormVisible">
            <el-form ref="form" :model="form" label-width="80px">
                <el-form-item label="产品号">
                    <el-autocomplete
                    class="inline-input"
                    v-model="tmp.pnum"
                    :fetch-suggestions="querySearch"
                    :trigger-on-focus="false"
                    @select="handleSelect"
                    @blur.native.capture="losefocus"
                ></el-autocomplete>
                </el-form-item>
                <!-- 
                    <el-input v-model="tmp.pnum"></el-input>
                </el-form-item> -->
                <el-form-item label="产品名">
                    <el-input v-model="tmp.pname" disabled></el-input>
                </el-form-item>
                <el-form-item label="批次号">
                    <el-input v-model="tmp.num"></el-input>
                </el-form-item>
                <el-form-item label="良品">
                    <el-input v-model="tmp.good"></el-input>
                </el-form-item>
                <el-form-item label="次品">
                    <el-input v-model="tmp.bad"></el-input>
                </el-form-item>
                <!-- <el-form-item label="总计">
                    <el-input v-model="tmp.total" disabled></el-input>
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
            tableData: [{
                pname: '螺丝',
                pnum: '123',
                num: '567',
                good:'12',
                bad:'23',
                total:'123'
            },{
                pname: '大螺丝',
                pnum: '123',
                num: '567',
                good:'12',
                bad:'23',
                total:'123'
            }],
            tmp:{
                pname: '',
                pnum: '',
                num: '',
                good:'',
                bad:'',
                total:'',
                row:0,
                type:''
            },
            dialogFormVisible: false,
            flag:true
        }
    },
    watch:{
        // dialogFormVisible(val,oldVal){
        //     if(val == false){
        //         this.tmp.pname = ''
        //         this.tmp.pnum = ''
        //         this.tmp.num = ''
        //         this.tmp.good = ''
        //         this.tmp.bad = ''
        //         this.tmp.total = ''
        //         this.tmp.row = ''
        //     }
        //     console.log(val)
        //     console.log(oldVal)
        // }
    },
    methods:{
        Edit(row, detail){
            this.dialogFormVisible = true
            console.log(row)
            console.log(detail)
            this.tmp.pname = detail.pname
            this.tmp.pnum = detail.pnum
            this.tmp.num = detail.num
            this.tmp.good = detail.good
            this.tmp.bad = detail.bad
            this.tmp.total = detail.total
            this.tmp.row = row
            this.tmp.type = 'edit'
        },
         Delete(row,index)
        // {
        //     console.log(index)
        //     console.log(row)
        //     this.tableData.splice(row,1)
        // }
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
        Add(){
            this.dialogFormVisible = true
            this.tmp.pname = ''
            this.tmp.pnum = ''
            this.tmp.num = ''
            this.tmp.good = ''
            this.tmp.bad = ''
            this.tmp.total = ''
            this.tmp.row = ''
            this.tmp.type = 'add'
        },
        confirm(){
            console.log(this.tmp.row)
            if(this.tmp.type == 'add'){
                this.tableData.push({
                    pname: this.tmp.pname,
                    pnum: this.tmp.pnum,
                    num: this.tmp.num,
                    good: this.tmp.good,
                    bad: this.tmp.bad,
                    total: parseInt(this.tmp.good) + parseInt(this.tmp.bad),
                    row: this.tmp.row
                })
                console.log(this.tmp)
                console.log(this.tableData)
                console.log('增加')
            }
            else{
                this.$set(this.tableData,this.tmp.row,{
                    pname: this.tmp.pname,
                    pnum: this.tmp.pnum,
                    num: this.tmp.num,
                    good: this.tmp.good,
                    bad: this.tmp.bad,
                    total: parseInt(this.tmp.good) + parseInt(this.tmp.bad),
                    row: this.tmp.row
                })
                console.log(this.tableData)
                console.log(this.tmp)
                console.log('修改')
            }
            this.dialogFormVisible = false;
        },
        Submit(){
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
        this.tmp.pname=item.address;
      },
      losefocus(){

      }
    },
    mounted() {
        const a =[
          { value: "123456","address":"齿轮"},
          { value: "234567","address":"大齿轮"}
        ]
      this.restaurants = a
      console.log(a)
    }
}
</script>

<style scoped>
.container{
    height: 650px;
}
</style>

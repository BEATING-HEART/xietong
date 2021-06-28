<template>
    <el-container>
  <el-header style="height:200px">
      <h3 align="center">查看入库申请单</h3>
      <el-form :model="QueryForm" ref="form" label-width="80px">
      <el-row>
  <el-col :span="24">按单号查询</el-col>
      </el-row>
      <el-form-item style="margin-left:-80px">
  <el-col :span="24">
      <el-input v-model="QueryForm.SheetId" placeholder="请输入入库申请单单号"></el-input>
  </el-col>
      </el-form-item>
      <el-row>
  <el-col :span="24">按日期查询</el-col>
      </el-row>
          <el-row>
              <el-col :span="12">
          <el-form-item style="margin-left:-80px">   
                  <el-time-picker type="time" placeholder="选择日期" v-model="QueryForm.Date" style="width: 100%"
                  format="yyyy 年 MM 月 dd 日" value-format="yyyy-MM-dd"></el-time-picker>
          </el-form-item>
              </el-col>
              <el-col :span="10">
                  &nbsp;
              </el-col>
          <el-container>
              <el-button type="primary" @click="submitForm()">查询</el-button>
              <el-button type="danger" @click="cancel()">取消</el-button>
          </el-container>
          </el-row>
      </el-form>
  </el-header>
  <el-divider style="80em"></el-divider>
  <el-main>
      <el-table
    :data="tableData"
    border
    style="width: 100%">
    <el-table-column
      prop="warehousingApplicationId"
      label="单号"
      width="180">
    </el-table-column>
    <el-table-column
      prop="workshopId"
      label="车间号"
      width="180">
    </el-table-column>
    <el-table-column
      prop="staffName"
      label="车间人员姓名">
    </el-table-column>
    <el-table-column
      prop="time"
      label="日期">
    </el-table-column>
    <el-table-column
      label="查看详情">
      <template slot-scope="scope">
                        <el-button size="mini" type="primary" 
                        style="margin-right: 10px" 
                        @click="ShowDetail(scope.$index, scope.row)">查看详情</el-button>
      </template>
    </el-table-column>
  </el-table>
  <el-dialog title="入库申请单" :visible.sync="dialogFormVisible" align="center">
            <el-form ref="form" :model="form" label-width="150px">
                <el-form-item label="订单号">
                <el-input v-model="detail.warehousingApplicationId" readonly="true"></el-input>
                </el-form-item>
                <el-form-item label="车间人员姓名">
                    <el-input v-model="detail.staffName" readonly="true"></el-input>
                </el-form-item>
                <el-form-item label="车间号">
                    <el-input v-model="detail.workshopId" readonly="true"></el-input>
                </el-form-item>
                <el-form-item label="日期">
                    <el-input v-model="detail.time" readonly="true"></el-input>
                </el-form-item>
                <el-table :data="detail.applicationProducts" borderstyle="width:100%">
                    <el-table-column label="产品编号" prop="productId">
                    </el-table-column>
                    <el-table-column label="产品名字" prop="productName">
                    </el-table-column>
                    <el-table-column label="发货数量" prop="totalNum">
                    </el-table-column>
                  </el-table>
            </el-form>
            <div slot="footer" class="dialog-footer">
                <el-button type="info" @click="dialogFormVisible = false">返回</el-button>
                <el-button type="primary" @click="" v-if="flag">核实正确</el-button>
                <el-button type="danger" @click="" v-if="flag">核实错误</el-button>
                <el-button type="primary" @click="" v-if="!flag">审核通过</el-button>
                <el-button type="danger" @click="" v-if="!flag">不通过</el-button>
            </div>
        </el-dialog>
  </el-main>
</el-container>
</template>



<script>
export default {
  created(){
        if(!window.sessionStorage.getItem('activePath'))
        this.activePath = '/WareHouseHome'
        else
        this.activePath = window.sessionStorage.getItem('activePath')
        if(window.sessionStorage.getItem("StaffPosition")=="仓库人员")
        this.flag=true
        else
        this.flag=false
    },
  created(){
      var url = 'http://39.103.202.215:8080/api/application/list';
        this.$axios.get(url)
        .then(res=>{
            console.log(res.data.data)
            this.tableData = res.data.data
        });
      //console.log(a)
  },
  data() {
    return {
        QueryForm:{
            SheetId:'',
            Date:'',
        },
         tableData: [],
        detail:{
            warehousingApplicationId:'',
            time:'',
            staffName:'',
            workshopId:'',
            applicationProducts:[
              {
                productId:'',
                productName:'',
                totalNum:''
                }
              ]
        },
        dialogFormVisible: false,
        flag:'',
    }
  },
  methods:{
      ShowDetail(row, detail){
            this.dialogFormVisible = true
            this.detail.warehousingApplicationId = detail.warehousingApplicationId
            this.detail.staffName = detail.staffName
            this.detail.workshopId = detail.workshopId
            this.detail.time = detail.time
            this.detail.applicationProducts=detail.applicationProducts
        },
        async submitForm() {
            var url = 'http://39.103.202.215:8080/api/application/get/' + this.QueryForm.SheetId;
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
        this.$axios.get(url)
        .then(res=>{
            console.log(res.data.data)
            this.tableData = res.data.data
        });
      }
  }
}
</script>
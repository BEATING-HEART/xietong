<template>
    <el-container>
  <el-header style="height:200px">
      <h3 align="center">查看出库单</h3>
      <el-form :model="QueryForm" ref="form" label-width="80px">
      <el-row>
  <el-col :span="24">按销售单号查询</el-col>
      </el-row>
      <el-form-item style="margin-left:-80px">
  <el-col :span="24">
      <el-input v-model="QueryForm.Salesid" placeholder="请输入销售单单号"></el-input>
  </el-col>
      </el-form-item>
      <el-row>
  <el-col :span="24">按日期查询</el-col>
      </el-row>
          <el-row>
              <el-col :span="12">
          <el-form-item style="margin-left:-80px">   
                  <el-date-picker type="date" placeholder="选择日期" v-model="QueryForm.Date" style="width: 100%"
                  format="yyyy 年 MM 月 dd 日" value-format="yyyy-MM-dd"></el-date-picker>
          </el-form-item>
              </el-col>
              <el-col :span="10">
                  &nbsp;
              </el-col>
          <el-col :span="2">
              <el-button type="primary" @click="submitForm('QueryForm')">查询</el-button>
          </el-col>
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
      prop="deliverid"
      label="出库单单号"
      width="180">
    </el-table-column>
    <el-table-column
      prop="salesid"
      label="销售单单号"
      width="180">
    </el-table-column>
    <el-table-column
      prop="delivername"
      label="出库员姓名">
    </el-table-column>
    <el-table-column
      prop="clientname"
      label="客户名">
    </el-table-column>
    <el-table-column
      prop="date"
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
  <el-dialog title="出库单" :visible.sync="dialogFormVisible" align="center">
            <el-form ref="form" :model="form" label-width="150px">
                <el-form-item label="出库单单号">
                <el-input v-model="detail.deliverid" readonly="true"></el-input>
                </el-form-item>
                <el-form-item label="销售单单号">
                    <el-input v-model="detail.salesid" readonly="true"></el-input>
                </el-form-item>
                <el-form-item label="出库员工姓名">
                    <el-input v-model="detail.delivername" readonly="true"></el-input>
                </el-form-item>
                <el-form-item label="客户姓名">
                    <el-input v-model="detail.clientname" readonly="true"></el-input>
                </el-form-item>
                <el-form-item label="日期">
                    <el-input v-model="detail.date" readonly="true"></el-input>
                </el-form-item>
                <h3 align=center>产品列表</h3>
                <el-table :data="detail.products" borderstyle="width:100%">
                    <el-table-column label="产品编号" prop="pid">
                    </el-table-column>
                    <el-table-column label="产品名字" prop="pname">
                    </el-table-column>
                    <el-table-column label="出库数量" prop="amount">
                    </el-table-column>
                  </el-table>
            </el-form>
            <div slot="footer" class="dialog-footer">
                <el-button type="info" @click="dialogFormVisible = false">返回</el-button>
                <el-button type="danger" @click="" v-if="!flag">拒绝出库</el-button>
                <el-button type="primary" @click="" v-if="!flag">允许出库</el-button>
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
  data() {
    return {
        QueryForm:{
            Salesid:'',
            Date:'',
        },
         tableData: [
        {
          salesid:'13489',
          deliverid: '5323',
          delivername: '蔡俊',
          clientname:'庄逸尘',
          date:'2016-05-04',
          products:[{pid:'1',pname:'齿轮',amount:'1000'},
          {pid:'2',pname:'大齿轮',amount:'500'}]
        }, 
        {
          salesid:'13489',
          deliverid: '5324',
          delivername: '蔡俊',
          clientname:'叶博涛',
          date:'2016-05-05',
          products:[{pid:'1',pname:'齿轮',amount:'1000'},
          {pid:'3',pname:'晶体管',amount:'500'}]
        }
        ],
        detail:
        {
            deliverid:'',
            salesid:'',
            delivername:'',
            clientname:'',
            date:'',
            products:[
              {
              pid:'',
              pname:'',
              amount:''
            }]
        },
        dialogFormVisible: false,
        // flag表示符用来对某些按钮的显示
        flag:'',
    }
  },
  methods:{
      ShowDetail(row, detail){
            this.dialogFormVisible = true
            this.detail.salesid = detail.salesid
            this.detail.delivername = detail.delivername
            this.detail.clientname = detail.clientname
            this.detail.date = detail.date
            this.detail.deliverid=detail.deliverid
            this.detail.products=detail.products
        },
        submitForm(formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
            alert('注册成功');
          } else {
            console.log('注册失败!!');
            return false;
          }
        });
      }
  }
}
</script>
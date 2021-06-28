<template>
    <el-container>
  <el-header style="height:200px">
      <h3 align="center">查看入库单</h3>
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
      prop="sheetid"
      label="入库单单号"
      width="180">
    </el-table-column>
    <el-table-column
      prop="chejianname"
      label="车间人员姓名"
      width="180">
    </el-table-column>
    <el-table-column
      prop="verifyname"
      label="核实人员姓名">
    </el-table-column>
    <el-table-column
      prop="auditname"
      label="审核经理姓名">
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
  <el-dialog title="入库单" :visible.sync="dialogFormVisible" align="center">
            <el-form ref="form" :model="form" label-width="150px">
                <el-form-item label="入库单单号">
                <el-input v-model="detail.sheetid" readonly="true"></el-input>
                </el-form-item>
                <el-form-item label="入库申请单单号">
                    <el-input v-model="detail.applyid" readonly="true"></el-input>
                </el-form-item>
                <el-form-item label="车间入库员工姓名">
                    <el-input v-model="detail.chejianname" readonly="true"></el-input>
                </el-form-item>
                <el-form-item label="车间号">
                    <el-input v-model="detail.chejianhao" readonly="true"></el-input>
                </el-form-item>
                <el-form-item label="核实人员姓名">
                    <el-input v-model="detail.verifyname" readonly="true"></el-input>
                </el-form-item>
                <el-form-item label="审核经理姓名">
                    <el-input v-model="detail.auditname" readonly="true"></el-input>
                </el-form-item>
                <el-form-item label="日期">
                    <el-input v-model="detail.date" readonly="true"></el-input>
                </el-form-item>
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
            </div>
        </el-dialog>
  </el-main>
</el-container>
</template>



<script>
export default {
  created(){
        var url = 'http://39.103.202.215:8080/api/warehousing/list';
        this.$axios.get(url)
        .then(res=>{
            console.log(res.data.data)
            this.tableData = res.data.data
        });
  },
  data() {
    return {
        QueryForm:{
            SheetId:'',
            Date:'',
        },
         tableData: [{
          sheetid:'13489',
          applyid:'120',
          chejianname:'张三',
          chejianhao:'1',
          verifyname:'庄逸尘',
          auditname:"蔡俊",
          date: '2016-05-02',
          products:[{pid:'1',pname:'齿轮',amount:'1000'},
          {pid:'2',pname:'大齿轮',amount:'500'}]
        }, {
          sheetid:'13500',
          applyid:'125',
          chejianname:'张三',
          chejianhao:'1',
          verifyname:'庄逸尘',
          auditname:"蔡俊",
          date: '2016-05-03',
          products:[{pid:'1',pname:'齿轮',amount:'1000'},
          {pid:'3',pname:'晶体管',amount:'200'}]
        }],
        detail:{
            sheetid:'',
            applyid:'',
            chejianname:'',
            chejianhao:'',
            verifyname:'',
            auditname:'',
            date:'',
            products:[{pid:'',pname:'',amount:''}]
        },
        dialogFormVisible: false
    }
  },
  methods:{
      ShowDetail(row, detail){
            this.dialogFormVisible = true
            this.detail.sheetid = detail.sheetid
            this.detail.applyid = detail.applyid
            this.detail.chejianname = detail.chejianname
            this.detail.chejianhao = detail.chejianhao
            this.detail.verifyname=detail.verifyname
            this.detail.auditname=detail.auditname
            this.detail.date=detail.date
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
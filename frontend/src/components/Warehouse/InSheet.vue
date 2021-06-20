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
                  <el-date-picker type="date" placeholder="选择日期" v-model="QueryForm.Date" style="width: 100%"></el-date-picker>
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
      prop="name"
      label="产品名字"
      width="180">
    </el-table-column>
    <el-table-column
      prop="amount"
      label="产品数量">
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
                        @click="Edit(scope.$index, scope.row)">查看详情</el-button>
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
                <el-form-item label="入库员工姓名">
                    <el-input v-model="detail.rukuname" readonly="true"></el-input>
                </el-form-item>
                <el-form-item label="审核经理姓名">
                    <el-input v-model="detail.jingliname" readonly="true"></el-input>
                </el-form-item>
                <el-form-item label="产品编号">
                    <el-input v-model="detail.pid" readonly="true"></el-input>
                </el-form-item>
                <el-form-item label="产品名">
                    <el-input v-model="detail.pname" readonly="true"></el-input>
                </el-form-item>
                <el-form-item label="批次号">
                    <el-input v-model="detail.pici" readonly="true"></el-input>
                </el-form-item>
                <el-form-item label="产品申请入库数量">
                    <el-input v-model="detail.amount" readonly="true"></el-input>
                </el-form-item>
                <el-form-item label="产品状态">
                    <el-input v-model="detail.status" readonly="true"></el-input>
                </el-form-item>
                <el-form-item label="入库时间">
                    <el-input v-model="detail.date" readonly="true"></el-input>
                </el-form-item>
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
  data() {
    return {
        QueryForm:{
            SheetId:'',
            Date:'',
        },
         tableData: [{
         sheetid:'13489',
          date: '2016-05-02',
          name: '齿轮',
          amount: '1000'
        }, {
          sheetid:'13490',
          date: '2016-05-04',
          name: '大齿轮',
          amount:'2000'
        }, {
          sheetid:'13491',
          date: '2016-05-06',
          name: '大齿轮',
          amount:'2000'
        }, {
          sheetid:'13492',
          date: '2016-05-06',
          name: '大齿轮',
          amount:'2000'
        }],
        detail:{
            sheetid:'',
            applyid:'',
            rukuname:'',
            jingliname:'',
            pid:'',
            pname:'',
            pici:'',
            amount:'',
            status:'',
            date:'',
        },
        dialogFormVisible: false
    }
  },
  methods:{
      Edit(row, detail){
            this.dialogFormVisible = true
            this.detail.sheetid = detail.sheetid
            this.detail.pname = detail.name
            this.detail.amount = detail.amount
            this.detail.date = detail.date
            this.detail.applyid=
            this.detail.rukuname=
            this.detail.jingliname=
            this.detail.pid=
            this.detail.pici=
            this.detail.status
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
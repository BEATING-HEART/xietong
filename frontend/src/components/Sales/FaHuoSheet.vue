<template>
    <el-container>
  <el-header style="height:200px">
      <h3 align="center">发货单查看</h3>
      <el-form :model="QueryForm" ref="form" label-width="80px">
      <el-row>
  <el-col :span="24">按单号查询</el-col>
      </el-row>
      <el-form-item style="margin-left:-80px">
  <el-col :span="24">
      <el-input v-model="QueryForm.sheetid" placeholder="请输入发货单单号"></el-input>
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
      prop="salesid"
      label="销售单单号"
      width="180">
    </el-table-column>
    <el-table-column
      prop="deliverid"
      label="发货单单号"
      width="180">
    </el-table-column>
    <el-table-column
      prop="clientname"
      label="客户姓名">
    </el-table-column>
    <el-table-column
      prop="batch"
      label="发货批次">
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
  <el-dialog title="发货单" :visible.sync="dialogFormVisible" align="center">
            <el-form ref="form" :model="form" label-width="150px">
                <el-form-item label="发货单单号">
                <el-input v-model="detail.deliverid" readonly="true"></el-input>
                </el-form-item>
                <el-form-item label="销售单单号">
                    <el-input v-model="detail.salesid" readonly="true"></el-input>
                </el-form-item>
                <el-form-item label="发货产品名">
                    <el-input v-model="detail.pname" readonly="true"></el-input>
                </el-form-item>
                <el-form-item label="发货数量">
                    <el-input v-model="detail.amount" readonly="true"></el-input>
                </el-form-item>
                <el-form-item label="客户姓名">
                    <el-input v-model="detail.clientname" readonly="true"></el-input>
                </el-form-item>
                <el-form-item label="发货批次">
                    <el-input v-model="detail.batch" readonly="true"></el-input>
                </el-form-item>
                <el-form-item label="发货时间">
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
            sheetid:'',
            Date:'',
        },
         tableData: [
        {
          salesid:'13489',
          deliverid: '5323',
          clientname: '庄松林',
          batch:'1',
          date:'2016-05-04',
          pname:'螺丝',
          amount:'110'
        }, 
        {
          salesid:'13490',
          deliverid: '5324',
          clientname: '苹果公司',
          batch:'2',
          date:'2016-05-04'
        }
        ],
        detail:
        {
            sheetid:'',
            salesid:'',
            pname:'',
            clientname:'',
            batch:'',
            amount:'',
            date:'',
        },
        dialogFormVisible: false,
        // flag表示符用来对某些按钮的显示
        flag:true,
    }
  },
  methods:{
      Edit(row, detail){
            this.dialogFormVisible = true
            this.detail.salesid = detail.salesid
            this.detail.pname 
            this.detail.batch = detail.batch
            this.detail.date = detail.date
            this.detail.deliverid=detail.deliverid
            this.detail.clientname=detail.clientname
            this.detail.salesname
            this.detail.amount
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
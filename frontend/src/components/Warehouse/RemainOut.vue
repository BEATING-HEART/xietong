<template>
    <el-container>
  <el-header style="height:50px">
      <h3 align="center">待发货</h3>
  </el-header>
  <el-divider style="80em"></el-divider>
  <el-main>
      <el-table
    :data="tableData"
    border
    style="width: 100%">
    <el-table-column
      prop="sheetid"
      label="订单号"
      width="180">
    </el-table-column>
    <el-table-column
      prop="name"
      label="产品名字"
      width="180">
    </el-table-column>
    <el-table-column
      prop="salesname"
      label="销售员姓名">
    </el-table-column>
    <el-table-column
      prop="clientname"
      label="客户姓名">
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
  <el-dialog title="待发货的销售单" :visible.sync="dialogFormVisible" align="center">
            <el-form ref="form" :model="form" label-width="150px">
                <el-form-item label="销售单号">
                <el-input v-model="detail.sheetid" readonly="true"></el-input>
                </el-form-item>
                <el-form-item label="销售员姓名">
                    <el-input v-model="detail.salesname" readonly="true"></el-input>
                </el-form-item>
                <el-form-item label="产品号">
                    <el-input v-model="detail.pid" readonly="true"></el-input>
                </el-form-item>
                <el-form-item label="产品名字">
                    <el-input v-model="detail.pname" readonly="true"></el-input>
                </el-form-item>
                <el-form-item label="产品数量">
                    <el-input v-model="detail.amount" readonly="true"></el-input>
                </el-form-item>
                <el-form-item label="审核人姓名">
                    <el-input v-model="detail.auditname" readonly="true"></el-input>
                </el-form-item>
                <el-form-item label="客户姓名">
                    <el-input v-model="detail.clientname" readonly="true"></el-input>
                </el-form-item>
                <el-form-item label="产品状态">
                    <el-input v-model="detail.status" readonly="true"></el-input>
                </el-form-item>
                <el-form-item label="时间">
                    <el-input v-model="detail.date" readonly="true"></el-input>
                </el-form-item>
            </el-form>
            <div slot="footer" class="dialog-footer">
                <el-button type="info" @click="dialogFormVisible = false">返回</el-button>
                <el-button type="danger" @click="" >拒绝发货</el-button>
                <el-button type="primary" @click="" >确认发货</el-button>
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
    },
  data() {
    return {
         tableData: [{
         sheetid:'3214',
          name: '齿轮',
          salesname: '陈宇',
          clientname: '台积电'
        }, 
        {
          sheetid:'3215',
          name: '大齿轮',
          salesname: '陈宇',
          clientname: '三星'
        }],
        detail:{
            sheetid:'',
            salesname:'',
            auditname:'',
            clientname:'',
            pid:'',
            pname:'',
            amount:'',
            status:'',
            date:'',
        },
        dialogFormVisible: false,
    }
  },
  methods:{
      Edit(row, detail){
            this.dialogFormVisible = true
            this.detail.sheetid = detail.sheetid
            this.detail.pname = detail.name
            this.detail.amount 
            this.detail.date 
            this.detail.salesname=detail.salesname
            this.detail.clientname=detail.clientname
            this.detail.auditname
            this.detail.pid
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
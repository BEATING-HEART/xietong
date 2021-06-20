<template>
    <el-container>
  <el-header style="height:50px">
      <h3 align="center">待审核的销售单</h3>
  </el-header>
  <el-divider style="80em"></el-divider>
  <el-main>
      <el-table
    :data="tableData"
    border
    style="width: 100%">
    <el-table-column
      prop="sheetid"
      label="销售单单号"
      width="180">
    </el-table-column>
        <el-table-column
      prop="salesmanname"
      label="销售员姓名">
    </el-table-column>
        <el-table-column
      prop="clientname"
      label="客户姓名">
    </el-table-column>
    <el-table-column
      prop="description"
      label="备注">
    </el-table-column>
    <el-table-column
      prop="date"
      label="日期" align="center">
    </el-table-column>
    <el-table-column
      label="查看详情" width="250px" align="center">
      <template slot-scope="scope">
                        <el-button size="mini" type="primary" 
                        @click="More(scope.$index, scope.row)">查看详情</el-button>
                        <!-- 撤回待审核的销售单按钮只有销售员看得到 -->
                        <el-button type="danger" icon="el-icon-delete" v-if="true" @click="" size="mini">撤回</el-button>
      </template>
    </el-table-column>
  </el-table>
  <el-dialog title="销售单" :visible.sync="dialogFormVisible" align="center" width="1250px">
            <el-form ref="form" :model="form" label-width="150px">
                <el-row>
                    <el-col :span="12">
                <el-form-item label="销售单单号">
                <el-input v-model="detail.sheetid" readonly="true"></el-input>
                </el-form-item>
                    </el-col>
                    <el-col :span="12">
                <el-form-item label="销售员工编号">
                    <el-input v-model="detail.salesmanid" readonly="true"></el-input>
                </el-form-item>
                    </el-col>
                </el-row>
                <el-row>
                    <el-col :span="12">
                <el-form-item label="客户姓名">
                    <el-input v-model="detail.clientname" readonly="true"></el-input>
                </el-form-item>
                    </el-col>
                    <el-col :span="12">
                <el-form-item label="销售员姓名">
                    <el-input v-model="detail.salesmanname" readonly="true"></el-input>
                </el-form-item>
                    </el-col>
                </el-row>
                <el-divider></el-divider>
                <el-table>
                    <el-table-column label="产品编号">
                    </el-table-column>
                    <el-table-column label="产品名字">
                    </el-table-column>
                    <el-table-column label="单价">
                    </el-table-column>
                    <el-table-column label="数量">
                    </el-table-column>
                    <el-table-column label="小计">
                    </el-table-column>
                </el-table>
                <el-divider></el-divider>
                <el-table>
                    <el-table-column label="预约发货批次">
                    </el-table-column>
                    <el-table-column label="预计发货时间">
                    </el-table-column>
                    <el-table-column label="实际发货时间">
                    </el-table-column>
                    <el-table-column label="发货状态">
                    </el-table-column>
                    <el-divider></el-divider>
              <el-form-item label="备注">
                  <el-input v-model="detail.description" readonly="true"></el-input>
              </el-form-item>
                </el-table>
            </el-form>
            <div slot="footer" class="dialog-footer">
                <el-button type="info" @click="dialogFormVisible = false">返回</el-button>
                <!-- 下面这两个按钮只有销售经理能看到 -->
                <el-button type="danger" @click="" v-if="buttonflag">不通过</el-button>
                <el-button type="success" @click="" v-if="buttonflag">通过</el-button>
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
          description: '销售员下跪得来的机会',
          salesmanname:'陈宇',
          clientname:"台积电",
          status:''
        }, 
        {
          sheetid:'13490',
          date: '2016-05-04',
          description: '销售员下跪得来的机会',
          salesmanname:"陈宇",
          clientname:"庄松林",
          status:''
        }, 
        {
          sheetid:'13491',
          date: '2016-05-06',
          description: '销售员下跪得来的机会',
          salesmanname:"陈宇",
          clientname:"三星",
          status:''
        }
        ],
        detail:{
            sheetid:'',
            salesmanid:'',
            salesmanname:'',
            clientname:'',
            products:[],
            batch:[],
            description:'',
        },
        dialogFormVisible: false,
        buttonflag:true,
    }
  },
  methods:{
      More(row, detail){
            this.dialogFormVisible = true
            this.detail.sheetid = detail.sheetid
            this.detail.salesmanname = detail.salesmanname
            this.detail.clientname=detail.clientname
            this.detail.salesmanid=''
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
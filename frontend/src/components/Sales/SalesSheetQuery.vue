<template>
    <el-container>
  <el-header style="height:200px">
      <h3 align="center">销售单管理</h3>
      <el-form :model="QueryForm" ref="form" label-width="80px">
      <el-row>
  <el-col :span="24">按销售单号查询</el-col>
      </el-row>
      <el-form-item style="margin-left:-80px">
  <el-col :span="24">
      <el-input v-model="QueryForm.SheetId" placeholder="请输入销售单单号"></el-input>
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
      <h1>销售单列表</h1>
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
      prop="pname"
      label="产品名字">
    </el-table-column>
    <el-table-column
      prop="date"
      label="日期" align="center">
    </el-table-column>
    <el-table-column
      label="查看详情" width="250px" align="center">
      <template slot-scope="scope">
                        <el-button size="mini" type="primary" 
                        icon="el-icon-edit"
                        @click="More(scope.$index, scope.row)">查看详情</el-button>
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
          pname: '齿轮',
          salesmanname:'陈宇',
          clientname:"台积电",
          status:''
        }, 
        {
          sheetid:'13490',
          date: '2016-05-04',
          pname: '空间曲率发动机',
          salesmanname:"陈宇",
          clientname:"庄松林",
          status:''
        }, 
        {
          sheetid:'13491',
          date: '2016-05-06',
          pname: '大齿轮',
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
        dialogFormVisible: false
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
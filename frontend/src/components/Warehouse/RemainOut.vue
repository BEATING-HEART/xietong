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
      prop="salesname"
      label="销售员姓名">
    </el-table-column>
    <el-table-column
      prop="clientname"
      label="客户姓名">
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
  <el-dialog title="待发货的销售单" :visible.sync="dialogFormVisible" align="center" width="1000px">
            <el-form ref="form" :model="form" label-width="150px">
                <el-form-item label="销售单号">
                <el-input v-model="detail.sheetid" readonly="true"></el-input>
                </el-form-item>
                <el-form-item label="销售员姓名">
                    <el-input v-model="detail.salesname" readonly="true"></el-input>
                </el-form-item>
                <el-form-item label="客户姓名">
                    <el-input v-model="detail.clientname" readonly="true"></el-input>
                </el-form-item>
                 <el-form-item label="时间">
                    <el-input v-model="detail.date" readonly="true"></el-input>
                </el-form-item>
                <el-form-item v-for="(item,index) in this.detail.TobeDeliver">
                  <el-form-item label="批次:">
                    <el-input v-model="item.batch" readonly="true" ></el-input>
                  </el-form-item>
                  <el-form-item label="日期:">
                    <el-input v-model="item.date" readonly="true" ></el-input>
                  </el-form-item>
                  <el-table :data="item.products" borderstyle="width:100%">
                    <el-table-column label="产品编号" prop="pid">
                    </el-table-column>
                    <el-table-column label="产品名字" prop="pname">
                    </el-table-column>
                    <el-table-column label="发货数量" prop="amount">
                    </el-table-column>
                  </el-table>
                  <el-row>
                    <el-col :span="16">
                      &nbsp;
                    </el-col>
                    <el-col :span="4">
                      <el-button type="danger" size="mini" @click="">拒绝发货</el-button>
                    </el-col>
                    <el-col :span="4">
                      <el-button type="primary" size="mini" @click="">发货</el-button>
                    </el-col>
                  </el-row>

                </el-form-item>
            </el-form>
            <div slot="footer" class="dialog-footer">
                <el-button type="info" @click="dialogFormVisible = false">返回</el-button>
                <el-button type="danger" @click="" >全部拒绝</el-button>
                <el-button type="primary" @click="" >全部发货</el-button>
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
          salesname: '陈宇',
          clientname: '台积电',
          date:'2021-6-15',
          TobeDeliver:[
          {
            batch:"1",
            date:'2021-6-18',
            products:[
              {
                pid:"1",
            pname:'齿轮',
            amount:'1000'
              },
              {
                pid:'2',
                pname:'大齿轮',
                amount:'500'
              }
              ]
            
          },
          {
            batch:"2",
            date:'2021-6-20',
            products:[
              {
                pid:'1',
                pname:'齿轮',
                amount:'200'
              },
              {
                pid:'3',
                pname:'晶体管',
                amount:'2000'
              }
            ]
          }
            ]
        },
        ],
        detail:{
            sheetid:'',
            salesname:'',
            clientname:'',
            date:'',
            TobeDeliver:[
              {
                batch:'',
                date:'',
                products:[
                  {
                    pid:'',
                    pname:'',
                    amount:''
                  }
                ]
              }
              ],
        },
        dialogFormVisible: false,
    }
  },
  methods:{
      ShowDetail(row, detail){
            this.dialogFormVisible = true
            this.detail.sheetid = detail.sheetid
            this.detail.date =detail.date
            this.detail.salesname=detail.salesname
            this.detail.clientname=detail.clientname
            this.detail.TobeDeliver=detail.TobeDeliver
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
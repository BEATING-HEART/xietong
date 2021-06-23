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
      prop="salesname"
      label="销售员姓名">
    </el-table-column>
        <el-table-column
      prop="clientname"
      label="客户姓名">
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
  <el-dialog title="销售单详情" :visible.sync="dialogFormVisible" align="center" width="1000px">
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
                <h3 align=center>产品列表</h3>
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
                </el-form-item>
                <el-form-item label="备注">
                  <el-input v-model="detail.description" readonly="true"></el-input>
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
  async mounted(){
      var url = 'http://39.103.202.215:8080/api/sale/listSaleOrder';
      await this.$axios.post(url)
      .then(({data: res})=>{
        console.log(res.data)
        const a = res.data
        a.forEach(function (item) {
              item.sheetid = String(item.saleId)
              delete item.saleId
              item.salesname = String(item.sellerName)
              delete item.sellerName
              item.clientname = String(item.customerName)
              delete item.customerName
              item.date = String(item.time)
              delete item.time
              item.description = String(item.remarks)
              delete item.remarks
        })
        this.tableData = a
      })      
    },
  data() {
    return {
        QueryForm:{
            SheetId:'',
            Date:'',
        },
         tableData: [{
         sheetid:'13489',
          date: '2016-05-02',
          salesname:'陈宇',
          clientname:"台积电",
          description:'销售员下跪得来的机会',
          TobeDeliver:[
            {
              batch:'1',
              date:'2016-05-03',
              products:[
                {
                  pid:'1',
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
              batch:'2',
              date:'2016-05-04',
              products:[
                {
                  pid:'1',
                  pname:'齿轮',
                  amount:'500'
                },
                {
                  pid:'3',
                  pname:'晶体管',
                  amount:'500'
                }
              ]
            }
          ]
        }
        ],
        detail:{
            sheetid:'',
            salesname:'',
            clientname:'',
            date:'',
            description:'',
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
        dialogFormVisible: false
    }
  },
  methods:{
      More(row, detail){
            this.dialogFormVisible = true
            this.detail.sheetid = detail.sheetid
            this.detail.salesname = detail.salesname
            this.detail.clientname=detail.clientname
            this.detail.date=detail.date
            this.detail.description=detail.description
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
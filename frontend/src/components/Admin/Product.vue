<template>
    <el-container>
  <el-header style="height:120px">
      <h3 align="center">产品管理</h3>
      <el-form :model="QueryForm" ref="form" label-width="80px">
      <el-row>
  <el-col :span="24">产品查询</el-col>
      </el-row>
      <el-row>
          <el-col :span="19">
      <el-form-item style="margin-left:-80px">
      <el-input v-model="QueryForm.PId" placeholder="请输入产品编号"></el-input>
           </el-form-item>
  </el-col>
  <el-col :span="1">
      &nbsp;
  </el-col>
          <el-col :span="2" >
              <el-button type="primary" @click="submitForm()" v-if="buttonflag">查询</el-button>
              <el-button type="primary" @click="showAllProducts()" v-if="!buttonflag">返回全部</el-button>
          </el-col>
          <el-col :span="2">
              <el-button type="warning" @click="Add()">新建产品</el-button>
          </el-col>
          </el-row>
      </el-form>
  </el-header>
  <el-divider style="80em"></el-divider>
  <el-main>
      <h1 align="center">产品列表</h1>
      <el-table
    :data="tableData"
    border
    style="width: 100%;margin-left:50px">
    <el-table-column
      prop="pid"
      label="产品编号"
      width="180">
    </el-table-column>
    <el-table-column
      prop="pname"
      label="产品名字"
      width="180">
    </el-table-column>
    <el-table-column
      prop="unit"
      label="产品数量单位"
      align="center"
      width="120"
      >
    </el-table-column>
    <el-table-column
      prop="description"
      label="详细描述"
      align="center"
      width="400">
    </el-table-column>
    <el-table-column
      label="具体操作"
      align="center">
      <template slot-scope="scope">
                        <el-button type="primary" size="mini"
                        icon="el-icon-edit"
                        @click="Edit(scope.$index, scope.row)">修改</el-button>
                        <el-button type="danger" size="mini"
                        icon="el-icon-delete"
                        @click="Delete(scope.$index, scope.row)">删除</el-button>
      </template>
    </el-table-column>
  </el-table>
  <el-dialog title="产品信息修改" :visible.sync="dialogFormVisibleEdit" align="center">
            <el-form ref="form" :model="formEdit" label-width="150px">
                <el-form-item label="产品编号">
                <el-input v-model="product.pid" readonly="true"></el-input>
                </el-form-item>
                <el-form-item label="产品名字">
                    <el-input v-model="product.pname" ></el-input>
                </el-form-item>
                <el-form-item label="数量单位">
                    <el-input v-model="product.unit" ></el-input>
                </el-form-item>
                <el-form-item label="详细描述">
                    <el-input v-model="product.description"></el-input>
                </el-form-item>
            </el-form>
            <div slot="footer" class="dialog-footer">
                <el-button type="info" @click="dialogFormVisibleEdit = false">返回</el-button>
                <el-button type="success" @click="confirm">提交修改</el-button>
            </div>
        </el-dialog>
        <el-dialog title="新产品" :visible.sync="dialogFormVisibleAdd" align="center">
            <el-form ref="form" :model="formAdd" label-width="150px">
                <el-form-item label="产品编号">
                <el-input v-model="product.pid"></el-input>
                </el-form-item>
                <el-form-item label="产品名字">
                    <el-input v-model="product.pname" ></el-input>
                </el-form-item>
                <el-form-item label="数量单位">
                    <el-input v-model="product.unit" ></el-input>
                </el-form-item>
                <el-form-item label="详细描述">
                    <el-input v-model="product.description"></el-input>
                </el-form-item>
            </el-form>
            <div slot="footer" class="dialog-footer">
                <el-button type="info" @click="dialogFormVisibleAdd = false">返回</el-button>
                <el-button type="success" @click="confirm">确定添加</el-button>
            </div>
        </el-dialog>
  </el-main>
</el-container>
</template>



<script>
export default {
  async created(){
    var url = 'http://39.103.202.215:8080/api/product/list';
      await this.$axios.post(url)
      .then(({data: res})=>{
        console.log(res.data)
        const a = res.data
        a.forEach(function (item) {
              item.pid = String(item.productId)
              delete item.productId
              item.pname = String(item.productName)
              delete item.productName
        })
        this.tableData = a
      })      
  },
  data() {
    return {
        QueryForm:{
            PId:'',
        },
         tableData: [
             {
          pid:'123458',
          pname: '空间曲率发动机',
          unit:'台',
          description:'用于军事战争作为秘密武器'
        },
        {
          pid:'77777',
          pname: '试作型缩退炮',
          unit:'架',
          description:'缩退是黑洞产生时的现象，缩退炮的原理就是制造出黑洞，让目标发生自行坍塌'
        }
        ],
        product:{
            pid:'',
            pname:'',
            unit:'',
            description:'',
            row:0,
            type:'',
        },
        dialogFormVisibleEdit: false,
        dialogFormVisibleAdd: false,
        buttonflag:true,
    }
  },
  methods:{
      Edit(row, detail){
            this.dialogFormVisibleEdit = true
            this.product.pid = detail.pid
            this.product.pname = detail.pname
            this.product.unit = detail.unit
            this.product.description = detail.description
            this.product.row = row
            this.product.type = 'edit'
        },
        async Delete(row,index)
        {
        this.$confirm('此操作将永久删除该产品, 是否继续?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(async () => {
            var url = 'http://39.103.202.215:8080/api/product/delete/' + index.pid;
            console.log(url)
             await this.$axios.post(url,{headers:{"Content-Type":"application/json"}})
             .then(async ({data: res}) => {
               console.log(res)
               this.$message.success('删除成功')
                   var url1 = 'http://39.103.202.215:8080/api/product/list';
                    await this.$axios.post(url1)
                    .then(({data: res})=>{
                      console.log(res.data)
                      const a = res.data
                      a.forEach(function (item) {
                            item.pid = String(item.productId)
                            delete item.productId
                            item.pname = String(item.productName)
                            delete item.productName
                      })
                      this.tableData = a
                    }) 
             })
             .catch((error) => {
               this.$message.error('删除失败')
                console.log(error);
              });
          this.$message({
            type: 'success',
            message: '删除成功!'
          });
        }).catch(() => {
          this.$message({
            type: 'info',
            message: '已取消删除'
          });          
        });
      },
      Add(){
            this.dialogFormVisibleAdd = true
            this.product.pid=''
            this.product.pname=''
            this.product.unit=''
            this.product.description=''
            this.product.row = ''
            this.product.type = 'add'
        },
        async confirm(){
            if(this.product.type == 'add'){
              var temp = {
                  "description": this.product.description,
                  "productId": this.product.pid,
                  "productName": this.product.pname,
                  "unit": this.product.unit,
                }
              var url = 'http://39.103.202.215:8080/api/product/insert';
             await this.$axios.post(url,temp,{headers:{"Content-Type":"application/json"}})
             .then(async ({data: res}) => {
               console.log(res)
               this.$message.success('添加成功')
                   var url1 = 'http://39.103.202.215:8080/api/product/list';
                    await this.$axios.post(url1)
                    .then(({data: res})=>{
                      console.log(res.data)
                      const a = res.data
                      a.forEach(function (item) {
                            item.pid = String(item.productId)
                            delete item.productId
                            item.pname = String(item.productName)
                            delete item.productName
                      })
                      this.tableData = a
                    }) 
             })
             .catch((error) => {
               this.$message.error('添加失败，请确认信息')
                  //console.log(error);
              });

                // this.tableData.push({
                //     pname: this.product.pname,
                //     pid:this.product.pid,
                //     unit:this.product.unit,
                //     description:this.product.description,
                //     row: this.product.row,
                // })
                this.dialogFormVisibleAdd = false;
                // Insert指令
            }
            else{
              var temp = {
                  "description": this.product.description,
                  "productId": this.product.pid,
                  "productName": this.product.pname,
                  "unit": this.product.unit,
                }
                console.log(temp)
              var url = 'http://39.103.202.215:8080/api/product/update';
             await this.$axios.post(url,temp,{headers:{"Content-Type":"application/json"}})
             .then(async ({data: res}) => {
               console.log(res)
               this.$message.success('修改成功')
                   var url1 = 'http://39.103.202.215:8080/api/product/list';
                    await this.$axios.post(url1)
                    .then(({data: res})=>{
                      console.log(res.data)
                      const a = res.data
                      a.forEach(function (item) {
                            item.pid = String(item.productId)
                            delete item.productId
                            item.pname = String(item.productName)
                            delete item.productName
                      })
                      this.tableData = a
                    }) 
             })
             .catch((error) => {
               this.$message.error('添加失败，请确认信息')
                  //console.log(error);
              });
                // this.$set(this.tableData,this.product.row,{
                //     pname: this.product.pname,
                //     pid:this.product.pid,
                //     unit:this.product.unit,
                //     description:this.product.description,
                //     row: this.product.row,
                //     Renew:true
                // })
                this.dialogFormVisibleEdit = false;
                // update指令
            }
        },
        async submitForm(formName) {
          var url = 'http://39.103.202.215:8080/api/product/get/' + this.QueryForm.PId;
            console.log(url)
             await this.$axios.post(url,{headers:{"Content-Type":"application/json"}})
             .then(async ({data: res}) => {
               console.log(res.data)
               var a = res.data
               a.forEach(function (item) {
                            item.pid = String(item.productId)
                            delete item.productId
                            item.pname = String(item.productName)
                            delete item.productName
                      })
                      this.tableData = a
                      if(a.length!=0){
                      this.$message({
                            type: 'success',
                            message: '查询成功!'
                                    })}
                      else{this.$message.error('查询失败')}
                      this.buttonflag=false

             })
          
      },
      async showAllProducts(){
        var url1 = 'http://39.103.202.215:8080/api/product/list';
                    await this.$axios.post(url1)
                    .then(({data: res})=>{
                      console.log(res.data)
                      const a = res.data
                      a.forEach(function (item) {
                            item.pid = String(item.productId)
                            delete item.productId
                            item.pname = String(item.productName)
                            delete item.productName
                      })
                      this.tableData = a
                    }) 
                    this.buttonflag=true
                    this.QueryForm.PId=''
      }
  }
}
</script>
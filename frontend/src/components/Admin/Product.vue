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
              <el-button type="primary" @click="submitForm('QueryForm')">查询</el-button>
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
        Delete(row,index)
        {
        this.$confirm('此操作将永久删除该产品, 是否继续?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
            this.tableData.splice(row,1)
            // 删除指令
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
        confirm(){
            if(this.product.type == 'add'){
                this.tableData.push({
                    pname: this.product.pname,
                    pid:this.product.pid,
                    unit:this.product.unit,
                    description:this.product.description,
                    row: this.product.row,
                })
                this.dialogFormVisibleAdd = false;
                // Insert指令
            }
            else{
                this.$set(this.tableData,this.product.row,{
                    pname: this.product.pname,
                    pid:this.product.pid,
                    unit:this.product.unit,
                    description:this.product.description,
                    row: this.product.row,
                    Renew:true
                })
                this.dialogFormVisibleEdit = false;
                // update指令
            }
        },
        submitForm(formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
            alert('查询成功');
          } else {
            console.log('查询失败!!');
            return false;
          }
        });
      }
  }
}
</script>
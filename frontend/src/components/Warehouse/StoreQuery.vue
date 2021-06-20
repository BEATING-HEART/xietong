<template>
    <el-container>
  <el-header style="height:100px">
      <h3 align="center">库存查询</h3>
      <el-form :model="QueryForm" ref="form" label-width="80px">
          <el-row>
              <el-col :span="20">
      <el-form-item style="margin-left:-80px">
      <el-input v-model="QueryForm.pid" placeholder="请输入产品编号"></el-input>
           </el-form-item>
  </el-col>
  <el-col :span="2">
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
      <el-row>
          <el-col :span="2">
              货品号
          </el-col>
          <el-col :span="20">
              <el-input v-model="this.tableData.pid" readonly="true"></el-input>
          </el-col>
      </el-row>
      <br>
      <el-row>
          <el-col :span="2">
              货品名
          </el-col>
          <el-col :span="20">
              <el-input v-model="this.tableData.pname" readonly="true"></el-input>
          </el-col>
      </el-row>
      <br>
      <el-row>
          <el-col :span="2">
              数量
          </el-col>
          <el-col :span="20">
              <el-input v-model="this.tableData.amount" readonly="true"></el-input>
          </el-col>
      </el-row>
          <br>
          <el-row>
          <el-col :span="2">
              单位
          </el-col>
          <el-col :span="20">
              <el-input v-model="this.tableData.unit" readonly="true"></el-input>
          </el-col>
      </el-row>
          
  </el-main>
</el-container>
</template>



<script>
export default {
  data() {
    return {
        QueryForm:{
            pid:''
        },
        tableData:{
          pid:'',
          pname: '',
          unit: '',
          amount: ''
        }    
    }
  },
  methods:{
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
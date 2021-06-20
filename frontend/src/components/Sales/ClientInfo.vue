<template>
    <el-container>
  <el-header style="height:200px">
      <h3 align="center">客户信息查询</h3>
      <el-form :model="QueryForm" ref="form" label-width="80px">
      <el-row>
  <el-col :span="24">按姓名查询</el-col>
      </el-row>
      <el-form-item style="margin-left:-80px">
  <el-col :span="24">
      <el-input v-model="QueryForm.ClientName" placeholder="请输入客户姓名"></el-input>
  </el-col>
      </el-form-item>
      <el-row>
  <el-col :span="24">按订单号查询</el-col>
      </el-row>
          <el-row>
              <el-col :span="12">
          <el-form-item style="margin-left:-80px">   
     <el-input v-model="QueryForm.SheetId" placeholder="请输入订单号"></el-input>
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
      <h1>客户信息</h1>
      <el-table
    :data="tableData"
    border
    style="width: 100%">
    <el-table-column
      prop="clientid"
      label="客户编号"
      width="180">
    </el-table-column>
        <el-table-column
      prop="clientname"
      label="客户姓名">
    </el-table-column>
        <el-table-column
      prop="telephone"
      label="联系方式">
    </el-table-column>
    <el-table-column
      prop="businessscope"
      label="经营范围">
    </el-table-column>
    <el-table-column
      prop="address"
      label="地址" align="center">
    </el-table-column>
    <el-table-column
      prop="sheetid"
      label="销售单单号" align="center">
    </el-table-column>
      </el-table>
  
  </el-main>
</el-container>
</template>



<script>
export default {
  data() {
    return {
        QueryForm:{
            SheetId:'',
            ClientName:'',
        },
        Result:{
            clientid:'',
            clientname:'',
            telephone:'',
            businessscope:'',
            address:'',
            sheetid:[],
        },
        tableData: [
            {
          sheetid:'13489',
          clientid:'1',
          clientname: '庄逸尘',
          telephone:'110',
          businessscope:"制造领域",
          address:'月球'
        }, ]
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
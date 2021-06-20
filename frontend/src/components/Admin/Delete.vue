<template>
    <div class="container">
        <h2 style="margin-left:500px">用户删除</h2>
        <el-form :model="ruleForm"  ref="ruleForm" label-width="100px" class="demo-ruleForm">
  <el-form-item label="账号" prop="account" style="margin-left:170px">
                  <el-autocomplete
                    class="inline-input"
                    v-model="ruleForm.account"
                    :fetch-suggestions="querySearch"
                    :trigger-on-focus="false"
                    @select="handleSelect"
                ></el-autocomplete>
  </el-form-item>
  <el-form-item label="姓名" prop="name" style="margin-left:170px">
    <el-input v-model="ruleForm.name" style="width:580px" readonly="true"></el-input>
  </el-form-item>
  <el-form-item label="密码" prop="password" style="margin-left:170px">
    <el-input v-model="ruleForm.password" style="width:580px" readonly="true"></el-input>
  </el-form-item>
  <el-form-item label="职位" prop="positions" style="margin-left:170px">
    <el-input v-model="ruleForm.positions" style="width:580px" readonly="true"></el-input>
  </el-form-item>
  <!-- 按钮 -->
    <el-button type="danger" @click="submitForm('ruleForm')" style="margin-left:700px">删除</el-button>
    <el-button type="info" @click="resetForm('ruleForm')">重置</el-button>
  </el-form-item>
</el-form>
    </div>
</template>

<script>
  export default {
      created(){
        console.log(this.loadAll)
        this.form.StaffId = window.sessionStorage.getItem('StaffId')
        this.form.StaffName = window.sessionStorage.getItem('StaffName')
    },
    data() {
      return {
        ruleForm: {
          account: '',
          positions: '',
          name: '',
          password: '',
        },
        Accounts:[]
      };
    },
    methods: {
      submitForm(formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
            alert('删除成功');
          } else {
            console.log('删除失败!!');
            return false;
          }
        });
      },
      resetForm(formName) {
        this.$refs[formName].resetFields();
      },
      querySearch(queryString, cb) {
        var Accounts = this.Accounts;
        var results = queryString ? Accounts.filter(this.createFilter(queryString)) : Accounts;
        // 调用 callback 返回建议列表的数据
        cb(results);
      },
      createFilter(queryString) {
        return (accounts) => {
          return (accounts.value.toLowerCase().indexOf(queryString.toLowerCase()) === 0);
        };
      },
       handleSelect(item) {
        this.ruleForm.name=item.name;
        this.ruleForm.password=item.password;
        this.ruleForm.positions=item.position;
      },
      loadAll() {
        return [
          { value: "1812480136","name":"庄逸尘","password":"zyc123456","position":"仓库经理"},
          { value: "1812480407","name":"蔡俊","password":"cj123456","position":"仓库管理员"},
          {value:"1811410626","name":"叶博涛","password":"ybt123456","position":"销售员"}
        ];
      }
    },
    mounted(){
        const a =[
          { value: "1812480136","name":"庄逸尘","password":"zyc123456","position":"仓库经理"},
          { value: "1812480407","name":"蔡俊","password":"cj123456","position":"仓库管理员"},
          {value:  "1811410626","name":"叶博涛","password":"ybt123456","position":"销售员"}
        ]
      this.Accounts = a
    }
  }
</script>

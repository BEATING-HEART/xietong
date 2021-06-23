<template>
    <div class="container">
        <h2 style="margin-left:500px">人员注册</h2>
        <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
  <el-form-item label="账号" prop="account" style="margin-left:170px">
    <el-input v-model="ruleForm.account" style="width:580px"></el-input>
  </el-form-item>
  <el-form-item label="姓名" prop="name" style="margin-left:170px">
    <el-input v-model="ruleForm.name" style="width:580px"></el-input>
  </el-form-item>
  <el-form-item label="密码" prop="password" style="margin-left:170px">
    <el-input v-model="ruleForm.password" style="width:580px"></el-input>
  </el-form-item>
  <el-form-item label="职位" prop="positions" style="margin-left:170px">
    <el-select v-model="ruleForm.positions" placeholder="请选择职位" style="width:580px">
      <el-option label="车间人员" value="车间人员"></el-option>
      <el-option label="销售员" value="销售员"></el-option>
      <el-option label="销售经理" value="销售经理"></el-option>
      <el-option label="仓库管理员" value="仓库管理员"></el-option>
      <el-option label="仓库经理" value="仓库经理"></el-option>
      <el-option label="财务员" value="财务员"></el-option>
    </el-select>
  </el-form-item>
  <!-- 按钮 -->
    <el-button type="primary" @click="submitForm('ruleForm')" style="margin-left:700px">注册</el-button>
    <el-button type="info" @click="resetForm('ruleForm')">重置</el-button>
</el-form>
    </div>
</template>

<script>
import qs from 'qs'
  export default {
    data() {
      return {
        ruleForm: {
          account: '',
          positions: '',
          name: '',
          password: '',
        },
        rules: {
          name: [
            { required: true, message: '请输入姓名', trigger: 'blur' },
            { min: 1, max: 20, message: '长度在 1 到 20 个字符', trigger: 'blur' }
          ],
          account: [
            { required: true, message: '请输入账号', trigger: 'blur' },
            { min: 1, max: 10, message: '长度在 1 到 10 个字符', trigger: 'blur' }
          ],
          password: [
            { required: true, message: '请输入密码', trigger: 'blur' },
            { min: 1, max: 20, message: '长度在 1 到 20 个字符', trigger: 'blur' }
          ],
          positions: [
            { required: true, message: '请输入职位', trigger: 'change' },
          ]
        }
      };
    },
    methods: {
      submitForm(formName) {
        this.$refs[formName].validate(async (valid) => {
          if (valid) {
            var url = 'http://39.103.202.215:8080/api/staff/insert';
            var temp = {
              staffId: this.ruleForm.account,
              staffName: this.ruleForm.name,
              staffPosition: this.ruleForm.positions,
              staffPwd: this.ruleForm.password,
            }
            console.log(temp)
             await this.$axios.post(url,temp,{headers:{"Content-Type":"application/json"}})
             .then(({data: res}) => {
               console.log(res)
               this.$message.success('注册成功')
             })
             .catch((error) => {
               this.$message.error('注册失败，该用户已存在')
              });
          } else {
            this.$message.error('请输入具体信息')
            return false;
          }
        });
      },
      resetForm(formName) {
        this.$refs[formName].resetFields();
      }
    }
  }
</script>
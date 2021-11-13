<!--登录页面-->
<template>
  <div>
    <el-row style="margin-top: 128px">
      <el-col :offset="9" :span="6" style="margin-top: 16px">
        <el-card>
          <logo style="margin-top: 8px;margin-bottom: 24px"/>
          <el-form ref="form" :model="form" :rules="rules" label-position="right" label-width="0px">
            <el-form-item label="" prop="email">
              <el-input v-model="form.email" placeholder="邮箱" suffix-icon="el-icon-user"></el-input>
            </el-form-item>
            <el-form-item label="" prop="password">
              <el-input v-model="form.password" placeholder="密码" show-password></el-input>
            </el-form-item>
            <el-form-item>
              <el-button :loading="login.submit" :type="login.type" @click="clickLogin('form')">登录</el-button>
            </el-form-item>
          </el-form>

        </el-card>

      </el-col>
    </el-row>

  </div>
</template>

<script>
import logo from '@/components/Logo'

export default {
  name: "LoginPage",
  components: {
    logo
  },
  data() {
    return {
      login: {
        submit: false,
        type: 'primary'
      },
      form: {
        email: '',
        password: ''
      },
      rules: {
        email: [
          {required: true, message: '请输入邮箱地址', trigger: 'blur'},
          {type: 'email', message: '请输入正确的邮箱地址', trigger: ['blur', 'change']}
        ],
        password: [
          {required: true, message: '请输入密码', trigger: 'blur'},
          {min: 8, message: '长度至少 8 个字符', trigger: 'blur'}
        ],
      }
    }
  },
  methods: {
    clickLogin(formName) {
      this.$refs[formName].validate((valid) => {
        this.login.submit = true

        if (valid) {
          // 登录请求
          this.axios.post('/user/login', {
            email: this.form.email,
            password: this.form.password
          }).then((res) => {
            if (res.data.success === true) {
              this.$message({
                message: `欢迎 ${res.data.data.nickName}`,
                type: 'success'
              });
              // 存放用户信息
              window.sessionStorage.setItem("userInfo", JSON.stringify(res.data.data))

              // 跳转
              this.$router.push('/main')
            } else {
              this.$message.error('登录失败')
              this.login.submit = false
            }

          }).catch(() => {
            this.$message.error('网络拥堵，请稍后重试')
            this.login.submit = false
          })

        } else {
          // console.log('error submit!!');
          this.login.submit = false
          return false;
        }
      });
    }
  }
}
</script>

<style scoped>

</style>
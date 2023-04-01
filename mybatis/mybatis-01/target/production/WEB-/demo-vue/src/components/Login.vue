<template>
    <body id=poster>
    <el-form class="login-container" label-position="left"
           label-width="0px">
    <h3 class="login_title">系统登录</h3>
    <el-form-item>
      <el-input type="text" v-model="loginForm.username"
                auto-complete="off" placeholder="昵称"></el-input>
    </el-form-item>
    <el-form-item>
      <el-input type="password" v-model="loginForm.password"
                auto-complete="off" placeholder="密码"></el-input>
    </el-form-item>
    <el-form-item style="width: 100%">
      <el-button type="primary" style="width: 100%;background: #505458;border: none" v-on:click="login">登录</el-button>
    </el-form-item>
  </el-form>
    </body>
</template>

<script>
export default {
    //methods 中定义了登录按钮的点击方法，即向后端 /login
    // 接口发送数据，获得成功的响应后，页面跳转到 /index
    name:'Login',
    data(){
        return{
            loginForm:{
                username:'goddess',
                password:'123'
            },
            responseResult: []
        }
    },
    /*methods定义登录按钮点击方法
    *向后端 /login 接口发送数据，获得成功的响应后，页面跳转到 /index
    **/
    methods:{
        login () {
            var _this = this
            console.log(this.$store.state)
            this.$axios
                .post('/login', {
                username: this.loginForm.username,
                password: this.loginForm.password
                })
                .then(successResponse => {
                if (successResponse.data.code === 200) {
                    // var data = this.loginForm
                    _this.$store.commit('login', _this.loginForm)
                    var path = this.$route.query.redirect
                    this.$router.replace({path: path === '/' || path === undefined ? '/index' : path})
                }
                })
                .catch(failResponse => {
                })
            }

    }
}
</script>

<style>
  .login-container {
    border-radius: 15px;
    background-clip: padding-box;
    margin: 90px auto;
    width: 350px;
    margin-top: 15%;
    padding: 35px 35px 15px 35px;
    background: #fff;
    border: 1px solid #eaeaea;
    box-shadow: 0 0 25px #cac6c6;
  }
  
  .login_title {
    margin: 0px auto 40px auto;
    text-align: center;
    color: #505458;
  }

  #poster {
    background:url("../assets/background/2007786.jpg") no-repeat;
    background-position: center;
    height: 100%;
    width: 100%;
    background-size: cover;
    position: fixed;
  }
  body{
    margin: 0px;
  }

</style>

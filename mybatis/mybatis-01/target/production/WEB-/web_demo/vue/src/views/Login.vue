<template>
    <div class="wrapper">
        <div style="margin: 200px auto; background-color: #fff; width: 350px; height: 300px; padding: 20px; border-radius: 10px ">
        <div style="margin: 20px 0; text-align: center; font-size: 24px"><b>登    录</b></div>
        <el-input size="medium" style="margin: 10px 0" prefix-icon="el-icon-user" v-model="user.username"></el-input>
        <el-input size="medium" style="margin: 10px 0" prefix-icon="el-icon-lock" show-password v-model="user.password"></el-input>
        <div style="margin: 10px 0; text-align: right">
            <el-button type="primary" size="small" aria-autocomplete="off" @click="login">登录</el-button>
            <el-button type="warning" size="small" aria-autocomplete="off" @click="$router.push('/register')">注册</el-button>
        </div>
        </div>
    </div>
</template>

<script>
// import { defineComponent } from '@vue/composition-api'
import axios from 'axios'
// import e from 'express'

export default {
    name: "Login",
    data() {
        return {
            user: {}
        }
    },
    methods: {
        login() {
            // http://192.168.0.109:9090/user/login
            axios.post("/user/login", this.user).then(res =>{
                if(res.data.code === '200'){
                    // 先定位到接收到对象的属性部分（.data），在指定要code属性（.code）
                // if(res.data){
                    localStorage.setItem("user",JSON.stringify(res.data))
                    // 将后端返回的对象保存起来
                    this.$router.push("/home")
                    this.$message.success("登陆成功")
                }else{
                    this.$message.error(res.data.msg);
                    // console.log(res)
                }
            })
        }
    }
}
</script>

<style>
    .wrapper{
        height: 100vh;
        background-image: linear-gradient(to bottom right, #FC466B , #3F5EFB);
        overflow: hidden;
    }
</style>

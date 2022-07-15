<template>
    <div class="wrapper">
        <div style="margin: 200px auto; background-color: #fff; width: 350px; height: 350px; padding: 20px; border-radius: 10px ">
        <div style="margin: 20px 0; text-align: center; font-size: 24px"><b>注     册</b></div>
        <el-input size="medium" style="margin: 10px 0" prefix-icon="el-icon-user" v-model="user.username"></el-input>
        <el-input size="medium" style="margin: 10px 0" prefix-icon="el-icon-lock" show-password v-model="user.password"></el-input>
        <el-input placeholder="请确认密码" size="medium" style="margin: 10px 0" prefix-icon="el-icon-lock" show-password v-model="user.confirmPassword"></el-input>
        <div style="margin: 10px 0; text-align: right">
            <el-button type="primary" size="small" aria-autocomplete="off" @click="login">注册</el-button>
            <el-button type="warning" size="small" aria-autocomplete="off" @click="$router.push('/login')">返回</el-button>
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
            if(this.user.password !== this.user.confirmPassword){
                this.$message.error("密码输入错误")
                return false
            }
            // http://192.168.0.109:9090/user/login
            axios.post("/user/register", this.user).then(res =>{
                if(res.data.code === '200'){
                    this.$message.success("注册成功")
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

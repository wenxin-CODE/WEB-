<template>
    <div>
        <el-form label-width="100px">
              <el-form-item label="用户名">
                <el-input v-model="form.data.username" autocomplete="off"></el-input>
              </el-form-item>
              <el-form-item label="昵称">
                <el-input v-model="form.data.nickname" autocomplete="off"></el-input>
              </el-form-item>
              <el-form-item label="邮箱">
                <el-input v-model="form.data.email" autocomplete="off"></el-input>
              </el-form-item>
              <el-form-item label="电话">
                <el-input v-model="form.data.phone" autocomplete="off"></el-input>
              </el-form-item>
              <el-form-item label="地址">
                <el-input v-model="form.data.address" autocomplete="off"></el-input>
              </el-form-item>
              <el-form-item>
                <el-button type="primary" @click="save">确 定</el-button>
              </el-form-item>
            </el-form>
    </div>
</template>

<script>
import axios from 'axios'
export default {
    name: "Person",
    data() {
        return {
            form: {},
            user: localStorage.getItem("user") ? JSON.parse(localStorage.getItem("user")) : {}
        }
    },
    created() {
        axios.get("/user/username/" + this.user.data.username).then(res =>{
            if(res.data.code === '200'){
                this.form = res.data
            }
        })
    },
    methods: {
        save(){
        // http://192.168.0.109:9090/user
        axios.post("/user",this.form.data).then(res =>{
          if(res){
            this.$message.success("保存成功")
          }else{
            this.$message.error("保存失败")
          }
        })
      },
    }
}
</script>

<style scoped>

</style>
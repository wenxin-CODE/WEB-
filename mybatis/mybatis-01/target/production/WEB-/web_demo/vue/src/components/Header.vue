<template>
    <div style="line-height: 60px; display: flex">
        <div style="flex: 1;">
              <span :class="collapseBtnClass" style="cursor: pointer; font-size: 18px" @click="collapse"></span>
              <!-- 点击触发collapse函数 -->

              <el-breadcrumb separator="/" style="display: inline-block; margin-left: 10px">
                <el-breadcrumb-item :to="'/'">首页</el-breadcrumb-item>
                <el-breadcrumb-item>{{ currentPathName }}</el-breadcrumb-item>
              </el-breadcrumb>
          </div>
          <!-- 上面这个div设置菜单栏可折叠 -->
          <!-- border-bottom设置顶部下边框，#ccc灰色，line-height文字居中 -->
          <el-dropdown style="width: 100px; cursor: pointer">
            <div style="display: inline-block">
              <span>{{ user.data.nickname }}</span><i class="el-icon-arrow-down" style="margin-left: 5px;"></i>
            </div>
          <!-- class="el-icon-arrow-down" 下面<i>里面加这个表示向下箭头 -->
            <el-dropdown-menu slot="dropdown" style="width: 100px; text-align: center;">
              <el-dropdown-item style="font-size: 14px; padding: 5px 0">
                <router-link to="/person">个人信息</router-link>
              </el-dropdown-item>
              <el-dropdown-item style="font-size: 14px; padding: 5px 0">
                <!-- <router-link to="/login" style="text-decoration: none">退出登录</router-link> -->
                <span style="text-decoration: none" @click="logout">退出登录</span>
              </el-dropdown-item>
            </el-dropdown-menu>
          </el-dropdown>

    </div>
</template>

<script>
// import { defineComponent } from '@vue/composition-api'

export default{
    name: "Header",
    props: {
      collapseBtnClass: String,
      collapse: Boolean,
    },
    watch: { //监听路由变化
      '$route': function() {
        this.currentPathName = localStorage.getItem("currentPathName")
      }
    },
    data() {
      return {
        currentPathName: '',
        user: localStorage.getItem("user") ? JSON.parse(localStorage.getItem("user")) : {}
      }
    },
    methods: {
      collapse() {
        this.$emit("asideCollapse")
        // this.collapse = false
      },
      logout() {
        this.$router.push("/login")
        localStorage.removeItem("user")
        this.$message.success("退出成功")
      }
    }
}
</script>

<style scoped>

</style>

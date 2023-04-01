<template>
<!-- 下面的el-menu一定要引入router才能实现路由跳转 -->
    <el-menu :default-openeds="['1', '3']" style="height: 100%; overflow-x: hidden"
                  background-color="rgb(48,65,86)"
                  text-color="#fff"
                  active-text-color="#ffd04b"
                  :collapse-transition="false"
                  :collapse="isCollapse"
                  router
                  @select="handleSelect"
        >
        <!-- 设置侧边框效�? overflow-x: hidden消除测边框参差不�? ; active-text-color设置菜单中被选中项效�?-->
          <div style="height: 60px; line-height: 60px; text-align: center; color: #fff" >
            <img src="../assets/logo.png" style="width: 20px; position: relative;  top: 6px; margin-right: 6px">
            <b v-show="logoTextShow">后台管理系统</b>
          </div>
          <el-menu-item index="/home">
              <template slot="title">
                <i class="el-icon-house"></i>
                <span slot="title">系统主页</span>
              </template>
          </el-menu-item>
          <el-submenu index="2">
            <template slot="title">
              <i class="el-icon-menu"></i>
              <span slot="title">系统管理</span>
            </template>
            <el-menu-item index="/user">
              <i class="el-icon-s-custom"></i>
              <span slot="title">用户管理</span>
            </el-menu-item>
          </el-submenu>
          <el-menu-item index="/about">
              <template slot="title">
                <i class="el-icon-house"></i>
                <span slot="title">系统简介</span>
              </template>
          </el-menu-item>
        </el-menu>
</template>

<script>
import { defineComponent } from '@vue/composition-api'

export default{
    name: "Aside",
    props: {
      isCollapse: Boolean,
      logoTextShow: Boolean
    },
    methods: {
      handleSelect(index) {
        console.log(index);
        console.log(this.$router.options.routes);
      }
    }
}
</script>

<style scoped>

</style>

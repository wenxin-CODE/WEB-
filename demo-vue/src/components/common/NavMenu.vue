<template>
    <!--使用vue-router模式，导航时以index作为path进行路由跳转-->
    <el-menu
      :default-active="'/index'"
      router
      mode="horizontal"
      background-color="white"
      text-color="#222"
      active-text-color="red"
      style="min-width: 1300px">
      <!--通过 v-for 指令，把 navList 数组渲染为一组 <el-menu-item> 元素-->
      <el-menu-item v-for="(item,i) in navList" :key="i" :index="item.name">
        {{ item.navItem }}
      </el-menu-item>
      <a href="#nowhere" style="color: #222;float: right;padding: 20px;">更多功能</a>
      <i class="el-icon-menu" style="float:right;font-size: 45px;color: #222;padding-top: 8px"></i>
      <span style="position: absolute;padding-top: 20px;right: 43%;font-size: 20px;font-weight: bold">美了！！！美了</span>
    </el-menu>
</template>

<script>
  export default {
    name: 'NavMenu',
    data () {
      return {
        navList: [
          {name: '/index', navItem: '首页'},
          {name: '/food', navItem: '美食'},
          {name: '/scenery', navItem: '美景'},
          {name: '/view', navItem: '点评'},
          {name: '/admin', navItem: '个人中心'}
        ]
      }
    }
  }
</script>

<style scoped>
  a{
    text-decoration: none;
  }

  span {
    pointer-events: none;
  }
</style>


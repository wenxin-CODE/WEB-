<template>
  <div id="app">
    <router-view/>
    <!-- 使用router-view组件进行路由管理 -->
  </div>
</template>

<script>
// import { defineComponent } from '@vue/composition-api'

export default {
  name: 'App',
  // created() {
  //   this.$router.push('/login')
  // }
}
</script>


<style>

#nav {
  padding: 30px;
}

#nav a {
  font-weight: bold;
  color: #2c3e50;
}

#nav a.router-link-exact-active {
  color: #42b983;
}
</style>

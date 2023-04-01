<template>
    <div>
        <nav-menu></nav-menu>
        <router-view/>
        <!--写入了一个 <router-view/>，也就是子页面（组件）显示的地方-->
        <!--导航栏，是父组件，App.vue 是所有组件的父组件，
        但把导航栏放进去不合适，因为我们的登录页面中不应该显示导航栏。
        所以新设一个-->
    </div>
</template>

<script>
import NavMenu from './common/NavMenu.vue'
export default {
  components: { NavMenu },
    name: 'Home'
}
</script>

<style scoped>

</style>

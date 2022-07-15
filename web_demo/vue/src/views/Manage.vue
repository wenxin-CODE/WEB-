<template>
    <el-container style="min-height: 100vh;">
      <el-aside width="sidewidth+'px'" style="background-color: rgb(238, 241, 246); min-height: 100vh">
        <!-- sidewidth+'px'动态控制表宽度（收起菜单自动填充） -->
        <Aside :isCollapse="isCollapse" :logoTextShow="logoTextShow"/>
      </el-aside>
      
      <el-container>
        <el-header style="border-bottom: 1px solid #ccc; ">
          <Header :collapseBtnClass="collapseBtnClass" :collapse="isCollapse"/>
        </el-header>
        
        <el-main>
          <!-- 这里就是展示当前页面的子路由 -->
          <router-view/>
        </el-main>
      </el-container>
    </el-container>
</template>

<script>
// @ is an alias to /src
import Aside from '@/components/Aside.vue';
import Header from '@/components/Header.vue'

export default {
  name: 'Home',
  data() {
      // const item = {
      //   date: '2016-05-02',
      //   name: '王小虎',
      //   address: '上海市普陀区金沙江1518弄堂'
      // };
      return {
        msg: "龙哥",
        collapseBtnClass: 'el-icon-s-fold',
        isCollapse: false, //设置菜单默认展开
        sidewidth: 300, //默认菜单宽度
        logoTextShow: true,
        // 要加引号
      }
    },

// vue.js中created方法是一个生命周期钩子函数，一个vue实例被生成后会调用这个函数，
// 一般可以在created函数中调用ajax获取页面初始化所需的数据
    // components是一个object
    components: {
      Aside,
      Header
    },

    methods: {
      collapse() {//菜单收缩函数
        this.isCollapse = !this.isCollapse
        if(this.isCollapse){
          this.sidewidth = 64
          this.collapseBtnClass = 'el-icon-s-unfold'
          this.logoTextShow = false
          // 收缩后菜单宽�?
        }else{
          this.sidewidth = 200
          this.collapseBtnClass = 'el-icon-s-fold'
          this.logoTextShow = true
        }
      },
      // 封装请求数据方法
      
    }
}
</script>

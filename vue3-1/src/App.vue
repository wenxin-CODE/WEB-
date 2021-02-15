<template>
<div>
<!-- 显示时间 -->
  <img alt="Vue logo" src="./assets/logo.png">
  <div>{{nowTime}}</div>
  <div><button @click="getNowTime">显示时间</button></div>
<!-- 选择对象 -->
  <h2>欢迎来到晨曦大厅</h2>
  <div>选择一位美女为您服务</div>
  <div>
    <button 
      v-for="(item,index) in data.girls" 
      v-bind:key="index"
      @click="data.selectGirlFun(index)"
    >
      {{ index }}:{{ item }}
    </button>
  </div>
  <div>你选择了【{{data.selectGirl}}】为你服务</div>
  <div><button @click="overAction">选择完毕</button></div>
  <div>{{overText}}</div>

<!-- 随机选择 -->
  <div v-if="loading">Loading.....</div>
    <img v-if="loaded" :src="result.message" />
  <div></div>
</div>
</template>

<script lang="ts">

import {data,overText,overAction} from './hooks/chenxi'
import {nowTime,getNowTime} from './hooks/useNowTime'
// import { ref } from "vue";
import useUrlAxios from './hooks/useURLAxios';
export default {
  name: 'App',
  setup(){
  
    const { result, loading, loaded } = useUrlAxios(
      "https://dog.ceo/api/breeds/image/random"
    );

    return{
      // girls,
      // selectGirl,
      // selectGirlFun
      data,
      overText,
      overAction,
      nowTime,
      getNowTime,
      result,
      loading,
      loaded
    };
  },
};
// export default app;
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>

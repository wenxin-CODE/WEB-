<template>
  <img alt="Vue logo" src="./assets/logo.png">
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
  <div>{{ overText }}</div>
</template>

<script lang="ts">
import { ref,reactive,onMounted,
  onBeforeMount,
  onBeforeUpdate,
  onUpdated,
  onRenderTracked,
  onRenderTriggered,
  watch} from 'vue';

export default {
  name: 'App',
  setup(){
    console.log("1-开始创建组件")
    const data = reactive({
      girls:["阿莹","阿迪","阿萌"],
      selectGirl:"",
      selectGirlFun:(index: number)=>{
        data.selectGirl = data.girls[index];
      },
    });

    const overText = ref("晨曦大厅");
    const overAction = ()=>{
      overText.value = overText.value+" | 选择完成";
      //document.title = overText.value;
    };

    //深度监听模式
    watch(overText,(newValue,oldValue) => {
      console.log('new-->${newValue}');
      console.log('old-->${oldValue}');
      document.title = newValue;
    });

    // onBeforeMount(()=>{
    //   console.log("2-组件挂载到页面之前");
    // });

    // onMounted(()=>{
    //   console.log("3-组件挂载到页面之后");
    // });

    // onBeforeUpdate(()=>{
    //   console.log("4-组件更新之前");
    // });

    // onUpdated(()=>{
    //   console.log("5-组件更新之后");
    // });

    // onRenderTracked((event)=>{
    //   console.log("状态跟踪组件-------->全跟踪");
    //   console.log(event);
    // });

    // onRenderTriggered((event)=>{
    //   console.log("状态跟踪组件-------->定点跟踪");
    //   console.log(event);
    // });

    // const girls = ref(["阿莹","阿迪","阿萌"]);
    // const selectGirl = ref("");
    // const selectGirlFun = (index: number)=>{
    //   selectGirl.value = girls.value[index];
    // };
    return{
      // girls,
      // selectGirl,
      // selectGirlFun
      data,
      overText,
      overAction
    };
  },
};
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

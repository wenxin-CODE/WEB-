import { ref,reactive,
    // onMounted,
    // onBeforeMount,
    // onBeforeUpdate,
    // onUpdated,
    // onRenderTracked,
    // onRenderTriggered,
    watch} from 'vue';

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
    watch(overText, (newValue, oldValue) => {
        console.log(`new--->${newValue}`);
        console.log(`old--->${oldValue}`);
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

export{data,overText,overAction}
<template>
  <el-card class="box-card">
    <div slot="header" class="clearfix">
      <span style="font-weight: bold;font-size: 20px">最近更新</span>
      <!--<el-button style="float: right; padding: 3px 0" type="text">修改</el-button>-->
    </div>
    <div class="block">
      <el-timeline>
        <el-timeline-item timestamp="2019/4/13" placement="top">
          <el-card>
            <h4>打通springboot和VUE的任督二脉</h4>
            <p>2020.11.11--点个赞</p>
          </el-card>
        </el-timeline-item>
        <el-timeline-item timestamp="2020/11/11" placement="top">
          <el-card>
            <h4>设计萌宠界面</h4>
            <p>2020.11.12--卖个萌</p>
          </el-card>
        </el-timeline-item>
        <el-timeline-item timestamp="2020/11/12" placement="top">
          <el-card>
            <h4>MySQL来搞事情了</h4>
            <p>2020.11.13--牛掰</p>
          </el-card>
        </el-timeline-item>
        <el-timeline-item timestamp="2020/11/13" placement="top">
          <el-card>
            <h4>功能实现</h4>
            <p>2020.11.14--嗯，自个儿看去</p>
          </el-card>
        </el-timeline-item>
        <el-timeline-item timestamp="2020/11/14" placement="top">
          <el-card>
            <h4>往哪里在</h4>
            <p>2020.11.15--代码强，代码皇，我就是码王</p>
          </el-card>
        </el-timeline-item>
      </el-timeline>
    </div>
  </el-card>
</template>

<script>
export default {
  name: 'UpdateCard'
}
</script>

<style scoped>
  .box-card {
    margin-top: 5px;
    width: 988px;
    height: 1050px;
    text-align: left;
  }
</style>

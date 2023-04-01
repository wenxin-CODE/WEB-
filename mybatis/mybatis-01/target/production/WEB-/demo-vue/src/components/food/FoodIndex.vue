<template>
  <el-container>
    <el-aside style="width: 200px;margin-top: 20px">
      <switch></switch>
      <SideMenu @indexSelect="listByKind" ref="sideMenu"></SideMenu>
    </el-aside>
    <el-main>
      <foods class="foods-area" ref="foodsArea"></foods>
    </el-main>
  </el-container>
</template>

<script>
  import Foods from './Foods'
  import SideMenu from './SideMenu'
  export default {
    name: 'AppFood',
    components: {SideMenu,Foods},
    methods: {
      listByKind () {
        var _this = this
        var cid = this.$refs.sideMenu.cid
        var url = 'kinds/' + cid + '/foods'
        this.$axios.get(url).then(resp => {
          if (resp && resp.status === 200) {
            _this.$refs.foodsArea.foods = resp.data
          }
        })
      }
    }
  }
</script>

<style scoped>
  .foods-area {
    width: 990px;
    margin-left: auto;
    margin-right: auto;
  }
</style>


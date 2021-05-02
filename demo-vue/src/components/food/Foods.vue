<template>
  <div>
    <el-row style="height: 840px;">
      <search-bar @onSearch="searchResult" ref="searchBar"></search-bar>
      <el-tooltip effect="dark" placement="right"
                  v-for="item in s.slice((currentPage-1)*pagesize,currentPage*pagesize)"
                  :key="item.id">
        <p slot="content" style="font-size: 14px;margin-bottom: 6px;">{{item.name}}</p>
        <p slot="content" style="font-size: 13px;margin-bottom: 6px">
          <!--<span>{{item.picture}}</span> /-->
          <!--<span>{{item.cook}}</span> -->
          <!--<span>{{item.press}}</span>-->
        </p>
        <p slot="content" style="width: 300px" class="abstract">{{item.abs}}</p>
        <p slot="content" style="width: 300px" class="abstract">{{item.cook}}</p>
        <el-card style="width: 135px;margin-bottom: 20px;height: 233px;float: left;margin-right: 15px" class=""
                 bodyStyle="padding:10px" shadow="hover">
          <div class="picture" @click="edit(item)">
            <img :src="item.picture" alt="图片">
          </div>
          <div class="info">
            <div class="name">
              <a href="">{{item.name}}</a>
            </div>
            <i class="el-icon-delete" @click="delete(item.id)"></i>
          </div>
          <div class="kind">{{item.kind}}</div>
        </el-card>
      </el-tooltip>
      <edit-form @onSubmit="loads()" ref="edit"></edit-form>
    </el-row>
    <el-row>
      <el-pagination
        @current-change="handleCurrentChange"
        :current-page="currentPage"
        :page-size="pagesize"
        :total="s.length">
      </el-pagination>
    </el-row>
  </div>
</template>

<script>
  import EditForm from './EditForm'
  import SearchBar from './SearchBar'
  export default {
    name: 's',
    components: {EditForm, SearchBar},
    data () {
      return {
        s: [],
        currentPage: 1,
        pagesize: 17
      }
    },
    mounted: function () {
      this.loads()
    },
    methods: {
      loads () {
        var _this = this
        this.$axios.get('/s').then(resp => {
          if (resp && resp.status === 200) {
            _this.s = resp.data
          }
        })
      },
      handleCurrentChange: function (currentPage) {
        this.currentPage = currentPage
        console.log(this.currentPage)
      },
      searchResult () {
        var _this = this
        this.$axios
          .get('/search?keywords=' + this.$refs.searchBar.keywords, {
          }).then(resp => {
          if (resp && resp.status === 200) {
            _this.s = resp.data
          }
        })
      },
      delete (id) {
        this.$confirm('此操作将永久删除, 是否继续?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
            this.$axios
              .post('/delete', {id: id}).then(resp => {
              if (resp && resp.status === 200) {
                this.loads()
              }
            })
          }
        ).catch(() => {
          this.$message({
            type: 'info',
            message: '已取消删除'
          })
        })
        // alert(id)
      },
      edit (item) {
        this.$refs.edit.dialogFormVisible = true
        this.$refs.edit.form = {
          id: item.id,
          picture: item.picture,
          name: item.name,
          cook: item.cook,
          abs: item.abs,
          kind: {
            id: item.kind.id.toString(),
            name: item.kind.name
          }
        }
      }
    }
  }
</script>

<style scoped>
  .picture {
    width: 150px;
    height: 172px;
    margin-bottom: 7px;
    overflow: hidden;
    cursor: pointer;
  }

  img {
    width: 150px;
    height: 172px;
    /*margin: 0 auto;*/
  }

  .name {
    font-size: 14px;
    text-align: left;
  }

  .kind {
    color: #333;
    width: 102px;
    font-size: 13px;
    margin-bottom: 6px;
    text-align: left;
  }

  .abstract {
    display: block;
    line-height: 17px;
  }

  .el-icon-delete {
    cursor: pointer;
    float: right;
  }

  .switch {
    display: flex;
    position: absolute;
    left: 780px;
    top: 25px;
  }

  a {
    text-decoration: none;
  }

  a:link, a:visited, a:focus {
    color: #3377aa;
  }
</style>


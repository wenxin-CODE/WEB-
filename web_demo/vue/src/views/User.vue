<template>
    <div >

          <div class="pd-10">
            <el-input style="width: 300px" placeholder="请输入名称" suffix-icon="el-icon-search" v-model="username"></el-input>
            <el-input style="width: 300px" class="ml-5" placeholder="请输入邮箱" suffix-icon="el-icon-search" v-model="email"></el-input>
            <el-button class="ml-5" type="primary" @click="load">搜索</el-button>
            <el-button type="warning" @click="reset">重置</el-button>
            <el-button class="ml-5" type="primary" @click="handleAdd">新增<i class="el-icon-circle-plus-outline"></i></el-button>
            <el-button class="ml-5" type="danger" @click="delBatch">批量删除<i class="el-icon-remove-outline"></i></el-button>
            <!-- :on-success 加了冒号是变量或表达式，不加是赋值，@是事件监听 -->
            <el-upload action="http://localhost:9090/user/import" :on-success="handleExcelImportSuccess" style="display: inline-block">
              <el-button class="ml-5" type="primary" >导入<i class="el-icon-bottom"></i></el-button>
            </el-upload>
            <el-button class="ml-5" type="primary" @click="exp">导出<i class="el-icon-top"></i></el-button>

            <!-- suffix-icon搜索图标 ； class="pd-10"是gloable中的样式 ；可以设置多个搜索 -->
          </div>

          <!-- border stripe给表格加边框 -->
          <el-table :data="tableData" border stripe :header-cell-style="{background:'#cccc',color:'#606266'}" @selection-change="handleSelectionChange">
            <!-- 添加选择框 -->
            <el-table-column type="selection" width="55">
            </el-table-column>
            <el-table-column prop="id" label="编号" width="50">
            </el-table-column>
            <el-table-column prop="username" label="姓名" width="140">
            </el-table-column>
            <el-table-column prop="nickname" label="昵称" width="120">
            </el-table-column>
            <el-table-column prop="email" label="邮箱" width="200">
            </el-table-column>
            <el-table-column prop="phone" label="电话" width="200">
            </el-table-column>
            <el-table-column prop="address" label="地址" width="250">
            </el-table-column>
            <el-table-column label="操作">
              <!-- eslint-disable-next-line -->
              <template slot-scope="scope">
                <el-button type="success" @click="handleEdit(scope.row)">编辑<i class="el-icon-edit"></i></el-button>
                <!-- 二次确认删除 ,slot="reference"按钮显现-->
                <el-popconfirm
                  class="ml-5"
                  confirm-button-text='确定'
                  cancel-button-text='再想想'
                  icon="el-icon-info"
                  icon-color="red"
                  title="确定删除吗？"
                  @confirm="handleDel(scope.row.id)"
                >
                  <el-button type="danger" slot="reference">删除<i class="el-icon-remove-outline"></i></el-button>
                </el-popconfirm>
              </template>
            </el-table-column>
          </el-table>
          <div style="padding: 10px 0">
            <el-pagination
              @size-change="handleSizeChange"
              @current-change="handleCurrentChange"
              :current-page="pageNum"
              :page-sizes="[2,5,10,20]"
              :page-size="pageSize"
              layout="total, sizes, prev, pager, next, jumper"
              :total="total">
            </el-pagination>
            <!-- current-page当前页码，page-size当前页面大小 -->
          </div>

          <el-dialog title="用户信息" :visible.sync="dialogFormVisible" width="50%">
            <el-form label-width="100px">
              <el-form-item label="用户名">
                <el-input v-model="form.username" autocomplete="off"></el-input>
              </el-form-item>
              <el-form-item label="昵称">
                <el-input v-model="form.nickname" autocomplete="off"></el-input>
              </el-form-item>
              <el-form-item label="邮箱">
                <el-input v-model="form.email" autocomplete="off"></el-input>
              </el-form-item>
              <el-form-item label="电话">
                <el-input v-model="form.phone" autocomplete="off"></el-input>
              </el-form-item>
              <el-form-item label="地址">
                <el-input v-model="form.address" autocomplete="off"></el-input>
              </el-form-item>
              <!-- <el-form-item label="活动区域">
                <el-select v-model="form.region" placeholder="请选择活动区域">
                  <el-option label="区域一" value="shanghai"></el-option>
                  <el-option label="区域二" value="beijing"></el-option>
                </el-select>
              </el-form-item> -->
            </el-form>
            <div slot="footer" class="dialog-footer">
              <el-button @click="dialogFormVisible = false">取 消</el-button>
              <el-button type="primary" @click="save">确 定</el-button>
            </div>
          </el-dialog>
    </div>
</template>

<script>
import { defineComponent } from '@vue/composition-api'
import axios from 'axios';

export default{
    name: "User",
    data() {
      return {
        tableData: [],
        total: 0,
        pageNum: 1,
        pageSize: 10,
        username: "",
        email: "",
        dialogFormVisible: false,
        form: {},
        multipleSelection: [],
      }
    },
    created() {
      // 调用封装的方法
      this.load()
    },
    // 注意拼写
    methods: {
      load() {
        // 请求分页查询数据
        // res => res.json()将后端传来的数据转换为json ； res => {console.log(res)}输出转换后的数据
        // 未输入username查询全部，输入了username模糊查询
        //  一旦属性加入到查询条件里面，这个属性的值就不能为空，不然无法加载
        // 钩子函数中的 this 指向调用它的 Vue 实例
        // 前段连接后台的工具——fetch

// request没有get方法，用axios来get数据
// http://192.168.0.109:9090/user/page
        axios.get("/user/page", {
          params: {
            pageNum: this.pageNum,
            pageSize: this.pageSize,
            username: this.username,
            email: this.email
          }
        }).then(res =>{
          console.log(res)
          // 要一层层的打开数据
          this.tableData = res.data.records
          this.total = res.data.total
        })

        // fetch("http://localhost:9090/user/page?pageNum="+this.pageNum+"&pageSize="+this.pageSize+"&username="+this.username+"&email="+this.email).then(
        //   res => res.json()).then(res => {
        //     console.log(res)
        //     this.tableData = res.data,
        //     this.total = res.total
        // })
      },
      save(){
        // http://192.168.0.109:9090/user
        axios.post("/user",this.form).then(res =>{
          if(res.data){
            this.$message.success("保存成功"),
            this.dialogFormVisible = false
            this.load()
          }else{
            this.$message.error("保存失败")
          }
        })
      },
      handleAdd(){
        this.dialogFormVisible = true,
        this.form = {}
      },
      handleEdit(row){
        this.form = row,
        this.dialogFormVisible =true
      },
      handleDel(id){
        // http://192.168.0.109:9090/user/
        axios.delete("/user/"+id).then(res =>{
          if(res.data){
            this.$message.success("删除成功"),
            this.load()
          }else{
            this.$message.error("删除失败")
          }
        })
      },
      handleSelectionChange(val){
        console.log(val),
        // 选中那些
        this.multipleSelection = val
      },
      delBatch(){
        let ids = this.multipleSelection.map(v => v.id) 
        // 把对象数组转化为其id数组
        // http://localhost:9090/user/del/batch
        axios.post("/user/del/batch", ids).then(res =>{
          if(res.data){
            this.$message.success("批量删除成功"),
            this.load()
          }else{
            this.$message.error("批量删除失败")
          }
        })
      },
      reset(){
        this.username = null,
        this.email = null,
        this.load()
      },
      handleSizeChange(pageSize){
        console.log(pageSize)
        this.pageSize = pageSize
        // 重新请求数据
        this.load()
      },
      handleCurrentChange(pageNum){
        console.log(pageNum)
        this.pageNum = pageNum
        this.load()
      },
      exp(){
        // http://localhost:9090/user/export
        window.open("/user/export")
      },
      handleExcelImportSuccess(){
        this.$message.success("导入成功")
        this.load()
      }
    }
}
</script>

<style scoped>

</style>

<style scoped>
.headerBg{
  background: #eee!important;
}
</style>

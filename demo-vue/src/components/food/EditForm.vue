<template>
  <div>
    <i class="el-icon-circle-plus-outline"  @click="dialogFormVisible = true"></i>
    <el-dialog
      title="添加/修改美食"
      :visible.sync="dialogFormVisible"
      @close="clear">
      <el-form v-model="form" style="text-align: left" ref="dataForm">
        <el-form-item label="名称" :label-width="formLabelWidth" prop="name">
          <el-input v-model="form.name" autocomplete="off" placeholder="不加《》"></el-input>
        </el-form-item>
        <el-form-item label="做法" :label-width="formLabelWidth" prop="cook">
          <el-input v-model="form.cook" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="图片" :label-width="formLabelWidth" prop="picture">
          <el-input v-model="form.picture" autocomplete="off" placeholder="图片 URL"></el-input>
        </el-form-item>
        <el-form-item label="简介" :label-width="formLabelWidth" prop="abs">
          <el-input type="textarea" v-model="form.abs" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="分类" :label-width="formLabelWidth" prop="cid">
          <el-select v-model="form.kind.id" placeholder="请选择分类">
            <el-option label="鲁菜" value="1"></el-option>
            <el-option label="川菜" value="2"></el-option>
            <el-option label="苏菜" value="3"></el-option>
            <el-option label="浙菜" value="4"></el-option>
            <el-option label="外菜" value="5"></el-option>
            <el-option label="新菜" value="6"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item prop="id" style="height: 0">
          <el-input type="hidden" v-model="form.id" autocomplete="off"></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogFormVisible = false">取 消</el-button>
        <el-button type="primary" @click="onSubmit">确 定</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
  export default {
    name: 'EditForm',
    data () {
      return {
        dialogFormVisible: false,
        form: {
          id: '',
          name: '',
          cook: '',
          picture: '',
          abs: '',
          kind: {
            id: '',
            name: ''
          }
        },
        formLabelWidth: '120px'
      }
    },
    methods: {
      clear () {
        this.form = {
          id: '',
          name: '',
          cook: '',
          picture: '',
          abs: '',
          kind: ''
        }
      },
      onSubmit () {
        this.$axios
          .post('/foods', {
            id: this.form.id,
            picture: this.form.picture,
            name: this.form.name,
            cook: this.form.cook,
            abs: this.form.abs,
            kind: this.form.kind
          }).then(resp => {
          if (resp && resp.status === 200) {
            this.dialogFormVisible = false
            this.$emit('onSubmit')
          }
        })
      }
    }
  }
</script>

<style scoped>
  .el-icon-circle-plus-outline {
    margin: 50px 0 0 20px;
    font-size: 100px;
    float: left;
    cursor: pointer;
  }
</style>



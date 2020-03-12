<template>
  <div id="addBlog">
    <el-form :model="form" label-position="left" label-width="50px">
      <el-form-item label="标题">
        <el-input v-model="form.title" />
      </el-form-item>
      <el-form-item label="类别">
        <el-select v-model="form.classify" placeholder="请选择">
          <el-option v-for="item in options" :key="item" :label="item" :value="item"></el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="主题">
        <el-input type="textarea" v-model="form.subject"/>
      </el-form-item>
      <el-form-item label="正文">
        <editor  :value.sync="form.content"></editor>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="onsubmit()">提交</el-button>
        <el-button @click="cancel()">取消</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
import Editor from "../components/Editor.vue"
export default {
  name: 'AddBlog',
  data() {
      return {
          form: {
              title: '',
              subject: '',
              classify: '',
              content: '',
              date: '',
              account: ''
          },
          options: [
              '艺术',
              '文学',
              '计算机',
          ]
      }
  },
  components: {
    Editor
  },
  methods: {
    onsubmit() {
      const date = new Date();
      this.form.date  = `${date.getFullYear()}-${date.getMonth()}-${date.getDate()}`;
      this.form.account = '123456@qq.com';
      this.$axios
      .post('/blog/add', 
         this.form
      )
      .then(response => {
        if (response.data.flag === "1") {
          alert("发布成功");
        }
      })
    }
  }
  // watch: {
  //   'form.content'(val) {
  //       console.log(val);
  //   }
  // }
};
</script>

<style scoped>
#addBlog {
    text-align: left;
    margin-left: 10px
}
</style>
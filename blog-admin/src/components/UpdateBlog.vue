<template>
  <div id="updateBlog">
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
        <el-input type="textarea" v-model="form.subject" />
      </el-form-item>
      <el-form-item label="正文">
        <editor :value.sync="form.content" :initValue="initValue"></editor>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="onsubmit()">确定</el-button>
        <el-button @click="cancel()">取消</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
import Editor from "../components/Editor.vue";
export default {
  name: "UpdateBlog",
  data() {
    return {
          initValue: '',
          form: {
              id: '',
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
  created() {
    const id = this.$route.params.blogId;
    this.form.id = id;
    this.$axios
    .post('/blog/query', {
        'id': this.form.id
    }).then(response => {
      const data = response.data;
      this.form.title = data.title;
      this.form.subject = data.subject;
      this.form.classify = data.classify;
      this.form.content = data.content;
      this.form.date = data.date;
      this.form.account = data.account;
      this.initValue = data.content;
    });
  },
  methods: {
    onsubmit() {
      const date = new Date();
      this.form.date  = `${date.getFullYear()}-${date.getMonth()}-${date.getDate()}`;
      this.$axios
      .post('/blog/update', 
         this.form
      )
      .then(response => {
        if (response.data.flag === "1") {
          alert("修改成功");
        }
      })
    }
  }
};
</script>
<style scoped>
#updateBlog {
  text-align: left;
  margin-left: 10px;
}
</style>
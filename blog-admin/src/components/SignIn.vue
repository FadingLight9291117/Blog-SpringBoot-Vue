<template>
  <div id="signin">
    <el-form :model="form" label-position="top" label-width="60px">
        <h1>登录</h1>
      <el-form-item label="用户名">
        <el-input placeholder="请输入用户名" v-model="form.username"></el-input>
      </el-form-item>
      <el-form-item label="密码">
        <el-input type="password" placeholder="请输入密码" v-model="form.password"></el-input>
      </el-form-item>
      <br>
      <el-form-item>
        <el-button type="primary" @click="onSubmit">登录</el-button>
        <el-button @click="cancel">取消</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
export default {
  name: "SignIn",
  data: () => {
    return {
      form: {
        username: "",
        password: ""
      }
    };
  },
  methods: {
    onSubmit() {
      this.$router.push('/admin')
    },
    cancel() {
      this.form.username = "";
      this.form.password = "";
    }
  }
};
</script>

<style scoped>
#signin {
  width: 400px;
  height: 400px;
  /* border: 1px solid gray; */
  padding: 10px 20px;
  border-radius: 4px;
  background: white;
  text-align: left;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.12), 0 0 6px rgba(0, 0, 0, 0.04);
}
</style>
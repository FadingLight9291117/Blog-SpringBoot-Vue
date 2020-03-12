<template>
  <div id="modifyPwd">
    <el-form label-position="top" :model="form" status-icon label-width="100px">
      <el-form-item label="旧密码">
        <el-input v-model="form.old"></el-input>
      </el-form-item>
      <el-form-item label="新密码">
        <el-input type="password" v-model="form.new"></el-input>
      </el-form-item>
      <el-form-item label="确认密码">
        <el-input type="password" v-model="form.again"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="onsubmit()">提交</el-button>
        <el-button @click="cancel()">取消</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
export default {
  name: "ModifyPwd",
  data() {
    return {
      form: {
        old: "",
        new: "",
        again: ""
      }
    };
  },
  methods: {
    onsubmit() {},
    cancel() {
      this.form.old = "";
      this.form.new = "";
      this.form.again = "";
    }
  }
};
</script>

<style scoped>
#modifyPwd {
  width: 500px;
  text-align: left;
  margin-left: 20%;
}
</style>
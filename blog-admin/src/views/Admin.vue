<template>
  <div id="admin">
    <el-container>
      <el-header>
        <label id="title">个人博客管理端</label>
      </el-header>
      <el-container>
        <el-aside style="width: 20%">
          <the-sider style="height: 100%"/>
        </el-aside>
        <el-container>
          <el-main>
            <router-view/>
          </el-main>
        </el-container>
      </el-container>
    </el-container>
  </div>
</template>

<script>
import TheSider from '../components/TheSider.vue'
export default {
  name: "Admin",
  components: {
    TheSider
  }
};
</script>

<style scoped>
#admin {
  /* padding: 5px; */
  height: 100%;
}
.el-container {
  padding: 5px;
  height: 100%;
}
.el-header {
  background-color: #545c64;
  border-radius: 4px 4px 0 0;
  text-align: left;
}
#title {
  line-height: 60px;
  font-size: 20px;
  color: white;
  margin-left: 20px;
  font-family: "Helvetica Neue", Helvetica, "PingFang SC", "Hiragino Sans GB",
    "Microsoft YaHei", "微软雅黑", Arial, sans-serif;
}
#theSider {
  height: 100%;
  text-align: left;
}
</style>
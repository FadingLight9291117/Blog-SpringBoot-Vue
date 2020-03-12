<template>
  <div id="theSider">
    <el-aside style="height: 100%" width="100%">
      <el-col id="navi" :span="12">
        <el-menu id="menu" router>
          <el-submenu index="1">
            <template slot="title">
              <i class="el-icon-location"></i>
              <span>个人信息</span>
            </template>
            <el-menu-item index="/admin/information">查看个人信息</el-menu-item>
            <el-menu-item index="modifyPwd">修改密码</el-menu-item>
          </el-submenu>
          <el-menu-item index="/admin/addBlog">
            <i class="el-icon-menu"></i>
            <span slot="title">新建博客</span>
          </el-menu-item>
          <el-menu-item index="/admin/blogList">
            <i class="el-icon-document"></i>
            <span slot="title">浏览博客</span>
          </el-menu-item>
          <el-menu-item index="4" disabled>
            <i class="el-icon-setting"></i>
            <span slot="title">设置</span>
          </el-menu-item>
        </el-menu>
      </el-col>
    </el-aside>
  </div>
</template>

<script>
export default {
  name: "TheSider"
};
</script>

<style scoped>
#navi {
  width: 100%;
}
#navi,
#menu {
  height: 100%;
}
</style>
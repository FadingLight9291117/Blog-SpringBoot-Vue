<template>

  <div id="navigation">
    <nav class="navbar navbar-inverse" role="navigation">
      <div class="container-fluid">
        <div>
          <ul class="nav navbar-nav">
            <li :class="active.index">
              <router-link to="/">个人博客</router-link>
            </li>
            <li :class="active.home">
              <router-link to="/home">主页</router-link>
            </li>
            <li :class="active.list">
              <router-link to="/list">博文</router-link>
            </li>
            <li :class="active.about">
            <router-link to="about">关于我</router-link>
            </li>
          </ul>
        </div>
        <ul class="nav navbar-nav navbar-right">
          <li>
            <a href="/admin/index.html">
              <span class="glyphicon glyphicon-user"></span> 管理员
            </a>
          </li>
          <li>
            <a href="/#/">
              <span class="glyphicon glyphicon-off"></span> 退出
            </a>
          </li>
        </ul>
      </div>
    </nav>
  </div>
</template>

<script>
export default {
  name: "Navigation",
  props: ['option'],
  data() {
      return {
          active: {
          index: '',
          home: '',
          list: '',
          about: '',
          }
      }
  },
  mounted() {
      this.active[this.option] = 'active'
  }

};
</script>

<style scoped>
</style>
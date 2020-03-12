<template>
  <div id="list">
    <navigation option="list" />
    <article>
      <h2 class="htitle">
        <span class="con_nav">
          您现在的位置是：
          <a href="home.html">首页</a>&nbsp;>&nbsp;
          <a href="article_edit.html">个人博客</a>&nbsp;>&nbsp;
          <a href="home.html">文章列表</a>&nbsp;&nbsp;
        </span>文章列表
      </h2>

      <div class="arti_list">
        <ul>
          <li v-for="(item, index) in blogs" :key="index" @click="clickItem(item.id)">
            <a class="arti_title">{{ item.title }}</a>
            <span>
              {{ item.date }}&nbsp;&nbsp;
              <span class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                  其他操作
                  <b class="caret"></b>
                </a>
                <ul class="dropdown-menu">
                  <li>
                    <a href="#">编辑</a>
                  </li>
                  <li>
                    <a href="#">删除</a>
                  </li>
                </ul>
              </span>
            </span>
          </li>
        </ul>
      </div>
    </article>
    <div class="rbox">
      <div class="paihang">
        <h2>文章类别</h2>
        <ul id="paihang">
          <li>
            <i></i>
            <span @click="click('文学')">文学</span>
          </li>
          <li>
            <i></i>
            <span @click="click('艺术')">艺术</span>
          </li>
          <li>
            <i></i>
            <span @click="click('计算机')">计算机</span>
          </li>
        </ul>
      </div>
    </div>
  </div>
</template>

<script>
import Navigation from "../components/Navigation.vue";
import Blog from "../entity"

export default {
  name: "List",
  components: {
    Navigation
  },
  data() {
    return {
      tempBlogs: [],
      blogs: [
      ]
    }
  },
  methods: {
    clickItem(id) {
      let routeData = this.$router.resolve({
        path: "/article/" + id
      });
      window.open(routeData.href, "_blank");
    },
    click(classify) {
      this.blogs = this.tempBlogs.filter(e => e.classify === classify);
    }
  },
  created() {
    // ajax操作
    this.$axios
    .get("/blog/blogs")
    .then(response => {
      const data = response.data;
      this.blogs = new Array();
      data.forEach(e => {
        this.blogs.push(new Blog(e));
      });
      this.tempBlogs = this.blogs;
    })
  }
};
</script>

<style scoped>
#list {
  background-color: #ffffff;
  text-align: left;
}
article {
  margin-left: 80px;
  width: 800px;
  height: 400px;
}
.rbox {
  width: 200px;
  height: 400px;
  background-color: #ffffff;
  position: absolute;
  left: 920px;
  top: 75px;
}
.rbox h2 {
  margin-left: 20px;
}
.form-control {
  width: 750px;
}
/*htitle*/
.htitle {
  font-size: 16px;
  line-height: 40px;
  border-bottom: 1px solid #eee;
  color: #484848;
  font-weight: normal;
  position: relative;
  margin-bottom: 10px;
}
.htitle:after {
  content: "";
  position: absolute;
  width: 60px;
  height: 2px;
  content: "";
  background: #000;
  left: 0;
  bottom: 0;
  -moz-transition: all 0.5s ease;
  -webkit-transition: all 0.5s ease;
  transition: all 0.5s ease;
}
.htitle:hover:after {
  width: 80px;
}

.con_nav {
  float: right;
  font-size: 14px;
  color: #666;
}
.con_nav a {
  color: #666;
}
.con_nav a:hover {
  color: #000;
}

.rec_box {
  width: 800px;
  height: 300px;
  background-color: #ffffff;
}
.hnav {
  float: right;
}
.hnav a {
  display: block;
  margin-right: 10px;
  padding-right: 10px;
  float: left;
  position: relative;
}
.hnav a:after {
  position: relative;
  content: "/";
  right: -10px;
  bottom: 0;
  color: #ccc;
}
.hnav a:last-child::after {
  content: "";
}

.newslist {
  float: right;
  width: 66%;
}
.newslist li {
  overflow: hidden;
  line-height: 32px;
  padding: 0 20px 10px 20px;
}
.newslist li a {
  height: 32px;
}
.newslist li img {
  width: 100%;
}
.newslist li {
  height: 22px;
}
.newslist li:hover {
  height: 100%;
  background: #f7f7f7;
}
.newslist li:hover a {
  color: #000;
  font-weight: bold;
}
.newslist li:hover i {
  background: #222;
}
.newslist li:nth-child(1) {
  height: 100%;
  background: #f7f7f7;
}
.newslist li:nth-child(1) a {
  color: #000;
  font-weight: bold;
}
.newslist li:nth-child(1) i {
  background: #9a9a9a;
}
.newslist:hover li:nth-child(1) {
  height: 22px;
  background: none;
}
.newslist:hover li:nth-child(1) a {
  color: #333;
  font-weight: normal;
}
.newslist:hover li:nth-child(1) i {
  background: #9a9a9a;
}
.newslist:hover li:nth-child(1):hover {
  height: 100%;
  background: #f7f7f7;
}
.newslist:hover li:nth-child(1):hover a {
  color: #000;
  font-weight: bold;
}
.newslist:hover li:nth-child(1):hover i {
  background: #222;
}
.newslist p {
  line-height: 24px;
  font-size: 14px;
  overflow: hidden;
  text-overflow: ellipsis;
  -webkit-box-orient: vertical;
  display: -webkit-box;
  -webkit-line-clamp: 2;
  height: 48px;
}
.newspic {
  float: left;
  width: 32%;
  height: 218px;
  overflow: hidden;
  position: relative;
}
.newspic ul {
  overflow: hidden;
}
.newspic li {
  height: 100px;
  position: relative;
  background: rgba(0, 0, 0, 1);
  overflow: hidden;
  margin-bottom: 10px;
  border-radius: 3px;
}
.newspic li a {
  display: block;
  overflow: hidden;
}
.newspic img {
  height: 100%;
  width: 100%;
  opacity: 0.7;
  -moz-transition: all 0.5s ease;
  -webkit-transition: all 0.5s ease;
  -ms-transition: all 0.5s ease;
  -o-transition: all 0.5s ease;
  transition: all 0.5s ease;
  transition: all 0.5s;
}
.newspic span {
  bottom: 0;
  position: absolute;
  bottom: 30%;
  left: 0;
  right: 0;
  color: #fff;
  text-align: center;
  font-size: 15px;
  padding: 0 40px;
  overflow: hidden;
  text-overflow: ellipsis;
  -webkit-box-orient: vertical;
  display: -webkit-box;
  -webkit-line-clamp: 2;
  line-height: 22px;
}
.newspic li:hover img {
  opacity: 0.9;
  transform: scale(1.1);
}
.newsitem ul li i {
  display: block;
  width: 20px;
  height: 20px;
  background: #9a9a9a;
  float: left;
  margin-top: 6px;
  margin-right: 20px;
  position: relative;
  font-style: normal;
}
.newsitem ul li i::before {
  position: absolute;
  left: 0;
  top: 0;
  font-size: 9px;
  color: #fff;
  line-height: 20px;
  width: 20px;
  text-align: center;
}
.newsitem ul li:first-child i {
  background: #222;
}
.newsitem ul li:first-child i::before {
  content: "1";
}
.newsitem ul li:nth-child(2) i::before {
  content: "2";
}
.newsitem ul li:nth-child(3) i::before {
  content: "3";
}
.newsitem ul li:nth-child(4) i::before {
  content: "4";
}
.newsitem ul li:nth-child(5) i::before {
  content: "5";
}

.arti_list ul {
  list-style: none;
}
.arti_list span {
  float: right;
  color: #838383;
}
.arti_list .arti_title {
  font-size: 20px;
  color: #000000;
}

#myCarousel {
  width: 800px;
  height: 400px;
}

.paihang ul {
  list-style: none;
}
.paihang a {
  font-size: 15px;
  color: #000000;
}
.paihang ul li i {
  width: 16px;
  height: 16px;
  background: #ffaa00;
  float: left;
  margin-right: 10px;
  margin-top: 3px;
  font-size: 15px;
}
.paihang ul li i::before {
  color: #ffffff;
  margin-left: 3px;
}
.paihang ul li:first-child i::before {
  content: "1";
}
.paihang ul li:nth-child(2) i::before {
  content: "2";
}
.paihang ul li:nth-child(3) i::before {
  content: "3";
}
.paihang ul li:nth-child(4) i::before {
  content: "4";
}
.paihang ul li:nth-child(5) i::before {
  content: "5";
}
</style>
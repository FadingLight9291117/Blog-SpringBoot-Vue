<template>
  <div id="home">
    <navigation option="home" />
    <article>
      <h2 class="htitle">
        <span class="con_nav">
          您现在的位置是：
          <a href="home.html">首页</a>&nbsp;>&nbsp;
          <a href="article_edit.html">个人博客</a>&nbsp;&nbsp;&nbsp;
        </span>个人博客
      </h2>

      <div id="myCarousel" class="carousel slide">
        <!-- 轮播（Carousel）指标 -->
        <ol class="carousel-indicators">
          <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
          <li data-target="#myCarousel" data-slide-to="1"></li>
          <li data-target="#myCarousel" data-slide-to="2"></li>
        </ol>
        <!-- 轮播（Carousel）项目 -->
        <div class="carousel-inner">
          <div class="item active">
            <img src="../assets/1.jpg" alt="First slide" />
            <div class="carousel-caption">标题 1</div>
          </div>
          <div class="item">
            <img src="../assets/2.jpg" alt="Second slide" />
            <div class="carousel-caption">标题 2</div>
          </div>
          <div class="item">
            <img src="../assets/3.jpg" alt="Third slide" />
            <div class="carousel-caption">标题 3</div>
          </div>
        </div>
        <!-- 轮播（Carousel）导航 -->
        <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
          <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
          <span class="sr-only">Previous</span>
        </a>
        <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
          <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
          <span class="sr-only">Next</span>
        </a>
      </div>

      <div class="rec_box">
        <h2 class="htitle">
          <span class="hnav">
            <a>前端框架</a>&nbsp;
            <a >后台算法</a>&nbsp;
            <a >心情日记</a>&nbsp;
          </span>最新文章
        </h2>
        <div class="newsitem">
          <div class="newspic">
            <ul>
              <li v-for="(item, index) in blogs.slice(0, 2)" :key="index" @click="clickItem(item.id)">
                <a>
                  <img src />
                  <span>{{ item.subject }}</span>
                </a>
              </li>
            </ul>
          </div>
          <ul class="newslist">
            <li v-for="(item, index) in blogs.slice(0, 5)" :key="index" @click="clickItem(item.id)">
              <i></i>
              <a href="#"></a>{{item.title}}
              <p>{{ item.subject }}</p>
            </li>
          </ul>
        </div>
      </div>
    </article>
    <div class="rbox">
      <div class="paihang">
        <h2>文章推荐</h2>
        <ul id="paihang">
          <li v-for="(item, index) in blogs" :key="index" @click="clickItem(item.id)">
            <i></i>
            <a>{{ item.title }}</a>
          </li>
        </ul>
      </div>
    </div>
  </div>
</template>

<script>
import Navigation from "../components/Navigation.vue";

import Blog from '../entity'

export default {
  name: "Home",
  components: {
    Navigation
  },
  data() {
    return {
      // 10 个
      blogs: [
        {
          id: '9',
          title: '即便是坑，我也想要拉你入伙！',
          subject: '对于刚毕业的学生来说，想学习建网站，掌握一技之长，最简单的入门无非就是学会html和css，先前发表过一篇文章《如果要学习web前端开发，需要学习什么？》，如果你还不知道如何着手，请仔细阅读....7天的时间，入门是没有问题的，当然，如果你用心的话！',
        },
        {
          id: '2',
          title: '我是怎么评价自己的？',
          subject: '为了挨打轻一些，问我哪里来的，我瞎说了一个说那个谁家的，结果，打得更凶。最后事情还原了真相，我妈说，你要说说奶奶家的，都不会打你了。从此以后，我知道撒谎是会付出更惨痛的代价的，我不再撒谎，也不喜欢爱撒谎的人。'
        },
        {
          id: '2',
          title: '我是怎么评价自己的？',
          subject: '为了挨打轻一些，问我哪里来的，我瞎说了一个说那个谁家的，结果，打得更凶。最后事情还原了真相，我妈说，你要说说奶奶家的，都不会打你了。从此以后，我知道撒谎是会付出更惨痛的代价的，我不再撒谎，也不喜欢爱撒谎的人。'
        },
        {
          id: '2',
          title: '我是怎么评价自己的？',
          subject: '为了挨打轻一些，问我哪里来的，我瞎说了一个说那个谁家的，结果，打得更凶。最后事情还原了真相，我妈说，你要说说奶奶家的，都不会打你了。从此以后，我知道撒谎是会付出更惨痛的代价的，我不再撒谎，也不喜欢爱撒谎的人。'
        },
        {
          id: '2',
          title: '我是怎么评价自己的？',
          subject: '为了挨打轻一些，问我哪里来的，我瞎说了一个说那个谁家的，结果，打得更凶。最后事情还原了真相，我妈说，你要说说奶奶家的，都不会打你了。从此以后，我知道撒谎是会付出更惨痛的代价的，我不再撒谎，也不喜欢爱撒谎的人。'
        },
      ],
    }
  },
  methods: {
     clickItem(id) {
      let routeData = this.$router.resolve({
        path: "/article/" + id
      });
      window.open(routeData.href, "_blank");
    }
  },
  mounted() {
    this.$axios
    .get("/blog/recommend")
    .then(response => {
      let data = response.data;
      this.blogs = new Array();
      data.forEach(e => {
        this.blogs.push(new Blog(e))
      })
    });
  }
};
</script>

<style scoped>
#home{
	background-color: #ffffff;
  text-align: left;
}
article{
	margin-left: 80px;
	width:800px;
	height: 400px;
}
.rbox{
	width: 200px;
	height: 400px;
	background-color: #ffffff;
	position: absolute;
	left: 920px;
	top: 75px;
}
.rbox h2{margin-left: 20px;}
.form-control{
	width:750px;
}
/*htitle*/
.htitle { font-size: 16px; line-height: 40px; border-bottom: 1px solid #eee; color: #484848; font-weight: normal; position: relative; margin-bottom: 10px; }
.htitle:after { content: ""; position: absolute; width: 60px; height: 2px; content: ""; background: #000; left: 0; bottom: 0; -moz-transition: all .5s ease; -webkit-transition: all .5s ease; transition: all .5s ease; }
.htitle:hover:after { width: 80px; }

.con_nav { float: right; font-size: 14px; color: #666 }
.con_nav a { color: #666 }
.con_nav a:hover { color: #000 }

.rec_box{width: 800px;height: 300px;background-color: #ffffff;}
.hnav { float: right }
.hnav a { display: block; margin-right: 10px; padding-right: 10px; float: left; position: relative }
.hnav a:after { position: relative; content: "/"; right: -10px; bottom: 0; color: #ccc }
.hnav a:last-child::after { content: "" }

.newslist { float: right; width: 66% }
.newslist li { overflow: hidden; line-height: 32px; padding: 0 20px 10px 20px; }
.newslist li a { height: 32px;}
.newslist li img { width: 100% }
.newslist li { height: 22px; }
.newslist li:hover { height: 100%; background: #f7f7f7 }
.newslist li:hover a { color: #000; font-weight: bold }
.newslist li:hover i { background: #222; }
.newslist li:nth-child(1) { height: 100%; background: #f7f7f7 }
.newslist li:nth-child(1) a { color: #000; font-weight: bold }
.newslist li:nth-child(1) i { background: #9a9a9a; }
.newslist:hover li:nth-child(1) { height: 22px; background: none; }
.newslist:hover li:nth-child(1) a { color: #333; font-weight: normal }
.newslist:hover li:nth-child(1) i { background: #9a9a9a; }
.newslist:hover li:nth-child(1):hover { height: 100%; background: #f7f7f7; }
.newslist:hover li:nth-child(1):hover a { color: #000; font-weight: bold }
.newslist:hover li:nth-child(1):hover i { background: #222; }
.newslist p { line-height: 24px; font-size: 14px; overflow: hidden; text-overflow: ellipsis; -webkit-box-orient: vertical; display: -webkit-box; -webkit-line-clamp: 2; height: 48px; }
.newspic { float: left; width: 32%; height: 218px; overflow: hidden; position: relative; }
.newspic ul { overflow: hidden; }
.newspic li { height: 100px; position: relative; background: rgba(0,0,0,1); overflow: hidden; margin-bottom: 10px; border-radius: 3px }
.newspic li a { display: block; overflow: hidden }
.newspic img { height: 100%; width: 100%; opacity: .7; -moz-transition: all .5s ease; -webkit-transition: all .5s ease; -ms-transition: all .5s ease; -o-transition: all .5s ease; transition: all .5s ease; transition: all 0.5s; }
.newspic span { bottom: 0; position: absolute; bottom: 30%; left: 0; right: 0; color: #FFF; text-align: center; font-size: 15px; padding: 0 40px; overflow: hidden; text-overflow: ellipsis; -webkit-box-orient: vertical; display: -webkit-box; -webkit-line-clamp: 2; line-height: 22px; }
.newspic li:hover img { opacity: .9; transform: scale(1.1); }
.newsitem ul li i { display: block; width: 20px; height: 20px; background: #9a9a9a; float: left; margin-top: 6px; margin-right: 20px; position: relative; font-style: normal }
.newsitem ul li i::before { position: absolute; left: 0; top: 0; font-size: 9px; color: #fff; line-height: 20px; width: 20px; text-align: center }
.newsitem ul li:first-child i { background: #222; }
.newsitem ul li:first-child i::before { content: "1"; }
.newsitem ul li:nth-child(2) i::before { content: "2"; }
.newsitem ul li:nth-child(3) i::before { content: "3"; }
.newsitem ul li:nth-child(4) i::before { content: "4"; }
.newsitem ul li:nth-child(5) i::before { content: "5"; }

.arti_list ul{list-style: none;}
.arti_list span{float: right;color: #838383;}
.arti_list .arti_title{font-size: 20px;color: #000000;}

#myCarousel{
	width:800px;
	height: 400px;
}

.paihang ul{list-style: none;}
.paihang a{font-size: 15px;color: #000000;}
.paihang ul li i{width: 16px; height: 16px; background: #ffaa00;float: left; margin-right: 10px;margin-top: 3px;font-size: 15px;}
.paihang ul li i::before{color: #FFFFFF;margin-left: 3px;}
.paihang ul li:first-child i::before{ content: "1"; }
.paihang ul li:nth-child(2) i::before{ content: "2"; }
.paihang ul li:nth-child(3) i::before{ content: "3"; }
.paihang ul li:nth-child(4) i::before{ content: "4"; }
.paihang ul li:nth-child(5) i::before{ content: "5"; }

</style>
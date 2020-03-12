<template>
  <div id="article">
    <navigation />
    <div class="container">
      <div class="page-header">
        <h1>{{ blog.title }}</h1>
      </div>
      <div>
        <span>分类:</span>
        <span>{{ blog.classify }}</span>
        <span>发表时间:</span>
        <span>{{ blog.date }}</span>
        <span>博主昵称:</span>
        <span>{{ blog.author }}</span>
      </div>
      <div style="text-align: left" v-html="blog.content"></div>
      <div class="line"></div>
      <div class="footer" align="center">
        <ul class="nav nav-pills">
          <li>
            <span class="footer-text">
              阅读量
              <span class="badge">42</span>
            </span>
          </li>
          <li>
            <span>
              <a href="#" class="footer-text">
                消息
                <span class="badge">4</span>
              </a>
            </span>
          </li>
        </ul>
      </div>
      <article style="text-align: left">
        <div class="comm_box">
          <h2 class="htitle">文章评论({{ comments.length }})</h2>
          <div class="comm_list">
            <ul>
              <li v-for="(item, index) in comments" :key="index">
                <span class="comm_name">{{ item.name }}</span>
                <span class="comm_cont">{{ item.content }}</span>
                <span class="comm_time">{{ item.date }}</span>
              </li>
            </ul>
          </div>

          <br />
          <div class="comm_title">来说两句吧...</div>
          <div class="form-group">
            <input
              type="text"
              class="form-control"
              id="vis_name"
              style="width: 200px;height: 30px;"
              placeholder="用户名"
              v-model="comment.name"
            />
          </div>
          <div class="form-group">
            <textarea
              class="form-control"
              id="vis_cont"
              rows="4"
              name="vis_cont"
              style="width: 500px;"
              placeholder="说出你的看法"
              v-model="comment.content"
            ></textarea>
          </div>
          <input type="submit" @click="onsubmit()" value="提交" />
        </div>
      </article>
    </div>
  </div>
</template>

<script>
import Navigation from "../components/Navigation.vue";
import Blog from "../entity";
import { Comment } from "../entity";

export default {
  name: "Artile",
  components: {
    Navigation
  },
  data() {
    return {
      blogId: "",
      blog: {
      },
      comments: [
      ],
      comment: {
      }
    };
  },
  methods: {
    onsubmit() {
      if (this.comment.name === "" || this.comment.content === "") {
        alert("请填写完整!");
      } else {
        const date = new Date();
        const dateString =
          date.getFullYear() + "-" + date.getMonth() + "-" + date.getDate();
        this.comment.date = dateString;
        this.comments.push(new Comment(this.comment));

        // ajax 操作
        this.$axios
          .get("/comment/add", {
            params: {
              id: this.blogId,
              nickname: this.comment.name,
              content: this.comment.content,
              date: this.comment.date
            }
          })
          .then(response => {
            if (response.data.flag === "1") {
              this.comment.name = "";
              this.comment.content = "";
              this.comment.date = "";
            }
          });
      }
    }
  },
  created() {
    this.blogId = this.$route.params.blogId;
    // ajax 操作获取博文
    this.$axios
      .post("/blog/query", {
         'id': this.blogId
      })
      .then(resopnse => {
        const data = resopnse.data;
        this.blog = new Blog(data);
      });

    // ajax获取评论
    this.$axios
      .get("/comment/list", {
        params: {
          id: this.blogId
        }
      })
      .then(response => {
      
        if (response.data) {
          const data = response.data;
          let comments = new Array();
          data.forEach(e => {
            comments.push({
              name: e.comm_nickname,
              content: e.comm_content,
              date: e.comm_time
            });
            this.comments = comments;
          });
        } else {
          this.comments = [];
        }
      });
  }
};
</script>

<style scoped>
.container {
  width: 960px;
}

.line {
  border: 1px dashed #969696;
}

span {
  font-size: 15px;
  color: #969696;
  margin-left: 10px;
  margin-right: 10px;
}

.footer {
  margin-top: 10px;
}

.footer-text {
  color: #2bceff;
  margin-top: 20px;
}
/* 文章评论 */
.comm_box {
  width: 800px;
  height: 300px;
  background-color: #ffffff;
}

.comm_list ul {
  list-style: none;
}
.comm_list ul li {
  line-height: 30px;
  border-bottom: 1px solid #eee;
}
.comm_list .comm_name {
  float: left;
  font-size: 20px;
  font-weight: bold;
}
.comm_list .comm_time {
  float: right;
  color: #838383;
}
.comm_list .comm_cont {
  margin-left: 15px;
  font-size: 15px;
}
.comm_box .comm_title {
  font-size: 15px;
  color: #838383;
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
</style>
<template>
  <div id="about">
    <navigation option="about" />
    <div class="container">
      <div class="jumbotron">
        <div>
          <p>个人博客</p>
        </div>
        <div class="information">
          <h6>个人档案</h6>
          <div class="line"></div>
          <div class="text">基本信息:</div>昵称:
          <div>{{ name }}</div>性别:
          <div>{{ sex }}</div>年龄:
          <div>{{ age }}</div>电话:
          <div>{{ phone }}</div>QQ:
          <div>{{ qq }}</div>座右铭:
          <div>{{ text }}</div>
          <div class="line"></div>
          <div class="text">认证类型:</div>
          <img src="../assets/about1.png" alt="blog" />
          <h6>给我留言</h6>
          <div class="line"></div>
          <div align="center">此用户已经设置留言板为隐私，你无法留言并查看留言。</div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import Navigation from "../components/Navigation.vue";
import {Admin} from "../entity"
export default {
  name: "About",
  components: {
    Navigation
  },
  data() {
    return {
      name: "",
      age: "",
      sex: "",
      phone: "",
      qq: "",
      text: ""
    };
  },
  methods: {
    getData() {
      this.$axios
        .get("/admin/getInfo", {
          params: {
            account: "123456@qq.com"
          }
        })
        .then(response => {
          const data = response.data;
          const admin = new Admin(data);
          this.name = admin.name;
          this.age = admin.age;
          this.sex = admin.sex;
          this.phone = admin.phone;
          this.qq=  admin.qq;
          this.text= admin.text;
        })
        // .catch(error => {
          // console.error(error);
        // });
    }
  },
  created() {
    this.getData();
  }
};
</script>

<style scoped>
#about {
  text-align: left;
}
.jumbotron {
  margin-top: 10px;
  margin-right: 20px;
  margin-bottom: 20px;
  margin-left: 20px;
  padding-top: 20px;
  padding-right: 20px;
  padding-bottom: 20px;
  padding-left: 20px;
}
.line {
  border: 1px dashed #969696;
}

.information {
  color: #969696;
  margin-top: 10px;
}

.information div {
  margin-top: 10px;
}

.text {
  font-size: 15px;
  color: black;
}
</style>
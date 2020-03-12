<template>
  <div id="index">
    <navigation option="index" />
    <div class="container">
      <div class="media">
        <div class="media-center">
          <img
            src="https://static.runoob.com/images/mix/img_avatar.png"
            style="width:45px"
          />
          <span>{{ name }}</span>
          <span>的个人博客</span>
        </div>
        <div class="container2">
          <div class="left">
            <span></span>
            <span>sdfsdfsdfs</span>
          </div>
          <div class="box">
            <div class="top box-page"></div>
            <div class="bottom box-page"></div>
            <div class="left box-page"></div>
            <div class="right box-page"></div>
            <div class="before box-page"></div>
            <div class="after box-page"></div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import Navigation from "../components/Navigation.vue";
export default {
  name: "Index",
  components: {
    Navigation
  },
  data() {
    return {
      name: '',
    }
  },
  mounted() {
    //ajax 操作
    this.$axios
    .get("/admin/getInfo", {
      params: {
        account: "123456@qq.com"
      }
    })
    .then(response => {
      // 后端传来博主姓名
      this.name = response.data.nickname;
    })
  }
};

var arr = document.querySelectorAll(".box>div");
for (var n = 0; n < arr.length; n++) {
  for (var i = 0; i < 3; i++) {
    for (var j = 0; j < 3; j++) {
      var divs = document.createElement("div");
      divs.style.cssText =
        "width:100px;height:100px;border: 1px solid #fff;position:absolute;box-sizing:border-box;background-image:url(../assets/a" +
        n +
        ".jpg);background-size: 300px 300px;";
      arr[n].appendChild(divs);

      // 改变每一个div的位置
      divs.style.left = 100 * j + "px";
      divs.style.top = 100 * i + "px";

      // 改变背景图相应的位置
      divs.style.backgroundPositionX = -j * 100 + "px";
      divs.style.backgroundPositionY = -i * 100 + "px";
    }
  }
}
</script>

<style scoped>
.media-center {
    text-align: center;

}

#index {
  width: 100%;
  height: 100%;
  background-image: url(../assets/Index1.jpg);
  background-size: auto 960px;
}

.container {
  color: #f3f3f3;
  font-size: 20px;
}

.container1 {
  float: left;
  width: 300px;
  height: 300px;
  margin: 100px 0px 200px 100px;
  padding: 100px;
  perspective: 20000px;
}

.container2 {
  width: 300px;
  height: 300px;
  margin: 100px 0px 200px 700px;
  perspective: 20000px;
}

.box {
  width: 300px;
  height: 300px;
  border: 1px solid transparent;
  box-sizing: border-box;
  position: relative;
  transform-style: preserve-3d;
  animation: rotate 10s linear infinite;
}

@keyframes rotate {
  100% {
    transform: rotatex(360deg) rotatey(360deg) rotatez(360deg);
  }
}

.box-page {
  width: 300px;
  height: 300px;
  position: absolute;
  box-sizing: border-box;
  transform-style: preserve-3d;
}

.top {
  transform: translateZ(150px);
}

.bottom {
  transform: translateZ(-150px) rotateX(180deg);
}

.right {
  transform: translateX(150px) rotateY(90deg);
}

.left {
  transform: translateX(-150px) rotateY(-90deg);
}

.after {
  transform: translateY(-150px) rotateX(90deg);
}

.before {
  transform: translateY(150px) rotateX(-90deg);
}

.box-page div:first-child,
.box-page div:nth-child(3),
.box-page div:nth-child(5),
.box-page div:nth-child(7),
.box-page div:nth-child(9) {
  transform: rotateY(0deg);
  animation: rotatey 6s linear infinite;
}

@keyframes rotatey {
  20% {
    transform: rotateY(0deg);
    background-size: 300px 300px;
  }

  40% {
    transform: rotateY(540deg);
    background-size: 100px 100px;
  }

  60% {
    transform: rotateY(540deg);
    background-size: 100px 100px;
  }

  80% {
    transform: rotateY(0deg);
    background-size: 300px 300px;
  }
}

.box-page div:nth-child(2),
.box-page div:nth-child(4),
.box-page div:nth-child(6),
.box-page div:nth-child(8) {
  transform: rotateX(0deg);
  animation: rotatex 6s linear infinite;
}

@keyframes rotatex {
  20% {
    transform: rotateX(0deg);
    background-size: 300px 300px;
  }

  40% {
    transform: rotateX(540deg);
    background-size: 100px 100px;
  }

  60% {
    transform: rotateX(540deg);
    background-size: 100px 100px;
  }

  80% {
    transform: rotateX(0deg);
    background-size: 300px 300px;
  }
}
</style>
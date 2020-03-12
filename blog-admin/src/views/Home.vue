<template>
  <div class="home">
    <el-button type="primary" @click.native="click()">点击</el-button>
      <p v-for="user in users" :key="user.id" @click="get(user.id)">
        <label>id: {{ user.id }}</label><br>
        <label>name: {{ user.name }}</label><br>
        <label>age: {{ user.age }}</label>
      </p>
  </div>
</template>

<script>
// @ is an alias to /src

export default {
  name: 'Home',
  data: () => {
    return {
      users: [],
    }
  },
  methods: {
    // click() {
    //   this.$axios
    //     .get("/users")
    //     .then( response => {
    //         this.users = response.data;
    //          })
    //     .catch(error => {
    //       console.log(error);
    //     })
    // },
    // get(id) {
    //   console.log(id);
    // }
  }
}
</script>

<template>
  <div id="blogList">
    <el-select v-model="select" placeholder="请选择分类">
      <el-option v-for="(item, index) in options" :key="index" :label="item" :value="item" />
    </el-select>
    <el-table :data="tableData" style="width: 100%">
      <el-table-column label="日期" width="300">
        <template slot-scope="scope">
          <i class="el-icon-time"></i>
          <span style="margin-left: 10px">{{ scope.row.date }}</span>
        </template>
      </el-table-column>
      <el-table-column label="标题" width="300">
        <template slot-scope="scope">
          <el-popover trigger="hover" placement="top">
            <p>主题: {{ scope.row.subject }}</p>
            <div slot="reference" class="name-wrapper">
              <el-tag size="medium">{{ scope.row.title }}</el-tag>
            </div>
          </el-popover>
        </template>
      </el-table-column>
      <el-table-column label="操作">
        <template slot-scope="scope">
          <el-button size="mini" @click="handleEdit(scope.row)">编辑</el-button>
          <el-button size="mini" type="danger" @click="handleDelete(scope.$index,scope.row)">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
  </div>
</template>

<script>
export default {
  name: "BlogList",
  data() {
    return {
      options: ["全部", "文学", "艺术", "计算机"],
      value: "",
      tempData: [],
      tableData: []
    };
  },
  computed: {
    select: {
      get() {
        return this.value;
      },
      set(value) {
        this.value = value;
        if (this.value === "全部") {
          this.tableData = this.tempData;
        } else {
          this.tableData = this.tempData.filter(e => e.classify === this.value);
        }
      }
    }
  },
  methods: {
    handleEdit(row) {
      let blogId = row.id;
      // console.log("edit: " + blogId);
      // 跳转到编辑页面
      this.$router.push("/admin/updateBlog/" + blogId);
    },
    handleDelete(index, row) {
      let blogId = row.id;
      // ajax操作
      this.$axios
      .get("/blog/delete",{
        params: {
        
          id: blogId
      }
      })
      .then(response => {
        const data = response.data;
        if (data.flag === "1") {
          alert("删除成功");
          // 更新数组
          this.tableData.splice(index, 1);
        }
      })
    }
  },
  created() {
    this.$axios.post("/blog/blogs").then(response => {
      const data = response.data;
      this.tableData = data;
      this.tempData = data;
    });
  }
};
</script>

<style scoped>
#blogList {
  text-align: left;
}
</style>
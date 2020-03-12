<template>
  <div id="editor">
  </div>
</template>

<script>
import E from "wangeditor";
export default {
  name: "Editor",
  data() {
    return {
      editor: null,
      content: ""
    };
  },
  props: ["value","initValue"],
  mounted() {
    this.editor = new E('#editor');
    // 编辑器事件，每次改变都会获取其html内容
    this.editor.customConfig.onchange = html => {
      this.content = html;
      this.$emit('update:value', this.content); // 通过content传递给父组件
    };
    this.editor.customConfig.menus = [
      // 菜单配置
      "head", // 标题
      "bold", // 粗体
      "fontSize", // 字号
      "fontName", // 字体
      "italic", // 斜体
      "underline", // 下划线
      "strikeThrough", // 删除线
      "foreColor", // 文字颜色
      "backColor", // 背景颜色
      "link", // 插入链接
      "list", // 列表
      "justify", // 对齐方式
      "quote", // 引用
      "emoticon", // 表情
      "image", // 插入图片
      "table", // 表格
      "code", // 插入代码
      "undo", // 撤销
      "redo" // 重复
    ];
    this.editor.create(); // 创建富文本实例
  },
  watch: {
    initValue(val) {
      this.editor.txt.html(val);
    }
  }
};
</script>

<style scoped>
</style>
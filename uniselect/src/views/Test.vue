<template>
  <div>
    这一页仅仅用来测试
    <p>{{ name }}</p>
  </div>
</template>

<script>
import axios from "axios";

export default {
  name: "Test",
  data() {
    return {
      name: "",
    };
  },
  async created() {
    await this.fetchData("http://localhost:9090/uniselect/fid", "id", "2");
  },
  methods: {
    async fetchData(url, attribute, value) {
      let new_url = url + "?" + attribute + "=" + value;

      //new_url=url;
      try {
        const response = await axios.get(new_url);
        console.log(response); // 打印完整的响应体
        const data = response.data;
        this.name = data.name; // 将 name 属性值赋给组件的数据属性
      } catch (error) {
        console.error(error);
      }
    },
  },
};
</script>

<style scoped></style>

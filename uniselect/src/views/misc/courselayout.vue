<template>
  <form id="userForm" @submit.prevent="submitForm">
    <h1>课程信息录入</h1>
    <label for="name">课程名称：</label>
    <input id="name" v-model="formData.name" name="name" type="text" />

    <label for="teacher">教师：</label>
    <input id="teacher" v-model="formData.teacher" name="teacher" type="text" />

    <label for="description">描述：</label>
    <input
      id="description"
      v-model="formData.description"
      name="description"
      type="text"
    />

    <label for="num">课程数量：</label>
    <input id="num" v-model="formData.num" name="num" type="text" />

    <button type="submit">提交</button>
  </form>
  <el-button type="primary" @click="backToDirname">返回上级菜单</el-button>
</template>

<script>
import axios from "axios";

export default {
  name: "CourseLayout",
  data() {
    return {
      formData: {
        name: "",
        teacher: "",
        description: "",
        num: "",
      },
    };
  },
  methods: {
    backToDirname() {
      window.location.href = "/selectcourse";
    },
    async submitForm() {
      const { name, teacher, description, num } = this.formData;
      try {
        await axios.post("http://localhost:9090/uniselect/addcourse", {
          name,
          teacher,
          description,
          num,
        });
      } catch (error) {
        console.error(error);
        this.$message.error("添加课程失败！");
        return;
      }
      this.$message.success("添加课程成功");
    },
  },
};
</script>
<style>
body {
  background-image: url("@/images/background.png");
  background-repeat: no-repeat;
  background-size: cover;
  font-family: Arial, sans-serif;
  background-color: #f5f5f5;
  margin: 0;
  padding: 20px;
}

form {
  max-width: 400px;
  margin: 0 auto;
  background-color: #fff;
  padding: 20px;
  border-radius: 5px;
  box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
}

h1 {
  text-align: center;
  margin-bottom: 20px;
}

label {
  display: block;
  margin-bottom: 10px;
  font-weight: bold;
}

input[type="text"],
input[type="password"] {
  width: 100%;
  padding: 10px;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
  margin-bottom: 15px;
  font-size: 14px;
}

button[type="submit"] {
  background-color: #4caf50;
  color: #fff;
  padding: 10px 20px;
  border: none;
  border-radius: 4px;
  cursor: pointer;
  font-size: 14px;
}

button[type="submit"]:hover {
  background-color: #45a049;
}

button[type="button"] {
  background-color: #4caf50;
  color: #fff;
  padding: 10px 20px;
  border: none;
  border-radius: 4px;
  cursor: pointer;
  font-size: 14px;
}

button[type="button"]:hover {
  background-color: #45a049;
}
</style>

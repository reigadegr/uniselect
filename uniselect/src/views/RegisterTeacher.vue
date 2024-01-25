<template>
  <form id="userForm" @submit.prevent="submitForm">
    <h1>教师信息录入</h1>
    <label for="teacher_id">工号：</label>
    <input
      id="teacher_id"
      v-model="formData.teacher_id"
      name="teacher_id"
      type="text"
    />

    <label for="name">姓名：</label>
    <input id="name" v-model="formData.name" name="name" type="text" />

    <label for="password">密码：</label>
    <input
      id="password"
      v-model="formData.password"
      name="password"
      type="password"
    />

    <label for="description">描述：</label>
    <input
      id="description"
      v-model="formData.description"
      name="description"
      type="text"
    />

    <button type="submit">提交</button>
    <button type="button" @click="login2">返回</button>
  </form>
</template>

<script>
import axios from "axios";

export default {
  data() {
    return {
      formData: {
        teacher_id: "",
        name: "",
        password: "",
        description: "",
      },
    };
  },
  methods: {
    async submitForm() {
      const { teacher_id, name, password, description } = this.formData;
      try {
        const response = await axios.post(
          "http://localhost:9090/uniselect/addteacher",
          {
            teacher_id,
            name,
            password,
            description,
          }
        );
        console.log("返回相应数据是： ", response.status);
        if (response.status === 200) {
          this.$message.success("保存成功！");
        } else {
          this.$message.error("保存失败，错误代码: " + response.status);
        }
      } catch (error) {
        console.error(error);
        this.$message.error("保存失败,vue js异常！！");
      }
    },
    login2() {
      // 跳转?.html
      window.location.href = "/welcomeadmin";
    },
  },
};
</script>
<style>
body {
  background-image: url("@/images/admin_background.jpg");
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

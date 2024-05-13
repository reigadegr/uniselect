<template>
  <form id="userForm" @submit.prevent="submitForm">
    <h1>学生信息录入</h1>
    <label for="student_id">学号：</label>
    <input
      id="student_id"
      v-model="formData.student_id"
      name="student_id"
      type="text"
    />

    <label for="password">密码：</label>
    <input
      id="password"
      v-model="formData.password"
      name="password"
      type="password"
    />

    <label for="name">姓名：</label>
    <input id="name" v-model="formData.name" name="name" type="text" />

    <label for="major">专业：</label>
    <input id="major" v-model="formData.major" name="major" type="text" />

    <label for="ban">班级：</label>
    <input id="ban" v-model="formData.ban" name="ban" type="text" />

    <label for="type">类型：</label>
    <input id="type" v-model="formData.type" name="type" type="text" />

    <button type="submit">提交</button>
    <button type="button" @click="login2">Login</button>
  </form>
</template>

<script>
import axios from "axios";

export default {
  data() {
    return {
      formData: {
        student_id: "",
        name: "",
        password: "",
        major: "",
        ban: "",
        type: "",
      },
    };
  },
  methods: {
    async submitForm() {
      const { student_id, name, password, major, ban, type } = this.formData;
      try {
        const response = await axios.post(
          "http://localhost:9090/uniselect/saveUser",
          {
            student_id,
            name,
            password,
            major,
            ban,
            type,
          }
        );
        console.log(response);
        if (response.status === 200) {
          this.$message.success("操作成功！");
          // window.location.href = "login";
        }
      } catch (error) {
        console.error(error);
        this.$message.error("操作失败，服务器有问题！");
      }
    },
    login2() {
      // 跳转?.html
      this.$router.push('/login');
    },
  },
};
</script>
<style>
body {
  background-image: url("@/images/teacher.jpg");
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

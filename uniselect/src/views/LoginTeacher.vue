<template>
  <div>
    <h1>Let's Login!</h1>
    <h1>教师登录</h1>
    <form @submit.prevent="login">
      <label htmlFor="teacher_id">账号:</label>
      <input id="teacher_id" v-model="teacher_id" type="text" /><br /><br />
      <label htmlFor="password">密码:</label>
      <input id="password" v-model="password" type="password" /><br /><br />
      <el-button type="success" @click="login">Login</el-button>
      <br /><br />
    </form>
  </div>
</template>

<script>
import axios from "axios";

export default {
  name: "LoginTeacher",
  data() {
    return {
      teacher_id: "",
      password: "",
    };
  },
  methods: {
    async login() {
      this.$message.info("teacher_id: " + this.teacher_id);
      this.$message.info("Password: " + this.password);
      console.log(this.teacher_id);
      console.log(this.password);
      // 发送请求
      const data = {
        teacher_id: this.teacher_id,
        password: this.password,
      };
      await axios
        .post("http://localhost:9090/uniselect/loginteacher", data)
        .then((response) => {
          console.log(response);
          const success = response.data;
          if (success) {
            // 验证成功的操作
            this.$message.success("登录成功！");
            // 登录成功后存储到LocalStorage
            // 声明并初始化全局变量
            localStorage.setItem("globalstdid", this.teacher_id);
            window.location.href = "/welcometeacher";
          } else {
            // 验证失败的操作
            this.$message.error("登录失败，请检查学号密码是否填写且正确！");
          }
        })
        .catch((error) => {
          console.error(error);
        });
    },
    goToRegister() {
      window.location.href = "/register";
    },
    goToWelcome() {
      window.location.href = "/welcometeacher";
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
}

h1 {
  color: #333;
  text-align: center;
}

form {
  width: 300px;
  margin: 0 auto;
  padding: 20px;
  background-color: #fff;
  border-radius: 5px;
  box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
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
  margin-bottom: 20px;
}
</style>

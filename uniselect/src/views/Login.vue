<template>
  <div>
    <h1>Let's Login!</h1>
    <h1>学生登录</h1>
    <form @submit.prevent="login">
      <label for="studentId">学号:</label>
      <input id="studentId" v-model="studentId" type="text" /><br /><br />
      <label for="password">密码:</label>
      <input id="password" v-model="password" type="password" /><br /><br />
      <el-button type="success" @click="login">Login</el-button>
      <br /><br />
      <!--      <el-button type="info" @click="goToRegister">Register</el-button>-->
    </form>
  </div>
</template>

<script>
import axios from "axios";

export default {
  name: "Login",
  data() {
    return {
      studentId: "",
      password: "",
    };
  },
  methods: {
    async login() {
      this.$message.info("studentId: " + this.studentId);
      this.$message.info("Password: " + this.password);

      // 发送请求
      const data = {
        // 要与表的字段一致
        student_id: this.studentId,
        password: this.password,
      };
      await axios
        .post("http://localhost:9090/uniselect/login", data)
        .then((response) => {
          console.log(response);
          const success = response.data;
          if (success) {
            // 验证成功的操作
            this.$message.success("登录成功！");
            // 登录成功后存储到LocalStorage
            // 声明并初始化全局变量
            localStorage.setItem("globalstdid", this.studentId);
            // localStorage.setItem("globalstdname", this.name);
            // localStorage.setItem("globalstdtype", this.type);
            window.location.href = "welcome";
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
      window.location.href = "welcome";
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

/*a,button {*/
/*  display: block;*/
/*  width: 100%;*/
/*  padding: 10px;*/
/*  background-color: #4CAF50;*/
/*  color: white;*/
/*  border: none;*/
/*  border-radius: 4px;*/
/*  cursor: pointer;*/
/*  font-size: 16px;*/
/*  text-align: center;*/
/*  text-decoration: none; !* 添加此行以消除下划线 *!*/
/*}*/

/*a:hover {*/
/*  background-color: #45a049;*/
/*}*/
</style>

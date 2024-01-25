<template>
  <div>
    <h1 class="title">米哈游大学选课系统</h1>
    <p class="description">
      欢迎来到本选课系统！这是一个方便学生进行课程选择和管理的在线平台。
    </p>
    <p class="description">
      通过本系统，您可以浏览并选择您感兴趣的课程，管理您的选课计划，并轻松完成选课过程。
    </p>
    <p class="description">请根据您的身份选择不同的登录接口</p>
    <el-button class="btn" type="primary" @click="GoTologin"
      >我是学生</el-button
    >
    <el-button class="btn" type="primary" @click="GoTologinTeacher"
      >我是教师</el-button
    >
    <el-button class="btn" type="primary" @click="GoTologinAdmin"
      >我是管理员</el-button
    >
  </div>
</template>

<script>
export default {
  name: "FirstOnce",
  methods: {
    GoTologin() {
      // 执行首页跳转的逻辑
      window.location.href = "/login";
    },
    GoTologinTeacher() {
      window.location.href = "/loginteacher";
    },
    GoTologinAdmin() {
      window.location.href = "/loginadmin";
    },
  },
};
</script>

<style scoped>
body {
  background-image: url("@/images/background.png");
  background-repeat: no-repeat;
  background-size: cover;
}

.title {
  font-size: 48px;
  color: #333;
  font-weight: bold;
  margin-bottom: 20px;
}

.description {
  font-size: 24px;
  color: #555;
  margin-bottom: 30px;
}

.btn {
  font-size: 18px;
  padding: 10px 20px;
  background-color: #337ab7;
  color: #fff;
  border-radius: 5px;
  border: none;
  cursor: pointer;
}
</style>

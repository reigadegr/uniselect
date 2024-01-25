<template>
  <div class="navdiv">
    <el-button type="primary" @click="goToWelcome">回到首页</el-button>
    <el-button type="primary" @click="goToSelectCourse">课程管理</el-button>
    <el-button type="primary" @click="goToAlreadySelect"
      >查看学生已选</el-button
    >
    <el-button type="primary" @click="goToCourseLayout">增加课程</el-button>
    <el-button type="primary" @click="goToNowUserInfo">个人信息</el-button>
  </div>
  <h1>学生已选课程</h1>
  <p class="welcome">
    您的账号：<span>{{ globalstdid }}</span>
  </p>
  <el-button type="warning" @click="getAlreadyCourses">刷新列表数据</el-button>
  <!--  <el-button type="warning" @click="getAlreadyCoursesId(globalstdid)">ID获取数据</el-button>-->
  <table v-if="courses.length > 0">
    <thead>
      <tr>
        <th>课程ID</th>
        <th>学生学号</th>
        <th>课程名称</th>
      </tr>
    </thead>
    <tbody>
      <tr v-for="(course, index) in courses" :key="index">
        <!--      要与表字段一样-->
        <td>{{ course.course_id }}</td>
        <td>{{ course.student_id }}</td>
        <td>{{ course.course_name }}</td>
        <!--      <td>-->
        <!--        <el-button type="danger" @click="deleteAlreadeSelect(globalstdid,course.course_id)">退课</el-button>-->
        <!--      </td>-->
      </tr>
    </tbody>
  </table>
</template>

<script>
import axios from "axios";

export default {
  name: "alreadyselect",
  data() {
    return {
      courses: [],
      message: "",
      //这里定义全局变量
      globalstdid: "",
    };
  },
  mounted() {
    this.globalstdid = localStorage.getItem("globalstdid");
  },
  methods: {
    //获取已选课程信息
    async getAlreadyCourses() {
      await axios
        .get("http://localhost:9090/uniselect/Course_selection_already_select")
        .then((response) => {
          this.courses = response.data;
          this.$message.success("已选课列表已更新");
        })
        .catch((error) => {
          console.error(error);
          this.$message.error("获取信息失败");
        });
    },

    goToWelcome() {
      // 执行首页跳转的逻辑
      window.location.href = "/welcometeacher";
    },
    goToSelectCourse() {
      // 执行已选页面跳转的逻辑
      window.location.href = "/selectcourseteacher";
    },
    goToAlreadySelect() {
      // 执行已选页面跳转的逻辑
      window.location.href = "/alreadyselectteacher";
    },
    goToCourseLayout() {
      // 执行课程表页面跳转的逻辑
      window.location.href = "/courselayoutteacher";
    },
    goToNowUserInfo() {
      // 执行个人信息页面跳转的逻辑
      window.location.href = "/nowuserinfteacher";
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
  background-color: #f2f2f2;
}

h1 {
  text-align: center;
  color: #333;
  margin-top: 50px;
}

table {
  margin: 50px auto;
  border-collapse: collapse;
  width: 80%;
  background-color: #fff;
  box-shadow: 0 2px 6px rgba(0, 0, 0, 0.3);
}

th,
td {
  padding: 12px 15px;
  text-align: left;
  border-bottom: 1px solid #ececec;
}

th {
  background-color: #f5f5f5;
  font-weight: bold;
}

button {
  display: block;
  margin: 50px auto;
  padding: 12px 30px;
  font-size: 16px;
  font-weight: bold;
  color: #fff;
  background-color: #333;
  border: none;
  border-radius: 30px;
  cursor: pointer;
  transition: background-color 0.2s ease-in-out;
}

button:hover {
  background-color: #555;
}

.navdiv {
  margin-top: 50px;
  display: flex;
  justify-content: center;
  align-items: center;
}

.navdiv a {
  text-decoration: none;
  background-color: #1a7ec5;
  color: #ffffff;
  padding: 10px 20px;
  font-size: 16px;
  border-radius: 4px;
  border: none;
  margin-left: 10px;
  cursor: pointer;
  transition: all 0.3s ease-in-out;
}

.navdiv a:hover {
  background-color: #4957f3;
}
</style>

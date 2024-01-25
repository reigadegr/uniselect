<template>
  <div class="navdiv">
    <el-button type="primary" @click="goToWelcome">回到首页</el-button>
    <el-button type="primary" @click="goToSelectCourse">选课</el-button>
    <el-button type="primary" @click="goToAlreadySelect">已选</el-button>
    <!--    <el-button type="primary" @click="goToCourseLayout">增加课程</el-button>-->
    <el-button type="primary" @click="goToNowUserInfo">个人信息</el-button>
  </div>
  <h1>已选课程</h1>
  <p class="welcome">
    您的学号：<span>{{ globalstdid }}</span>
  </p>
  <!--  <el-button type="warning" @click="getAlreadyCourses">刷新列表数据</el-button>-->
  <el-button type="warning" @click="getAlreadyCoursesId(globalstdid)"
    >刷新查看我已选的课</el-button
  >
  <table v-if="courses.length > 0">
    <thead>
      <tr>
        <th>课程ID</th>
        <th>学生学号</th>
        <th>课程名称</th>
        <th>可选操作</th>
      </tr>
    </thead>
    <tbody>
      <tr v-for="(course, index) in courses" :key="index">
        <!--      要与表字段一样-->
        <td>{{ course.course_id }}</td>
        <td>{{ course.student_id }}</td>
        <td>{{ course.course_name }}</td>
        <td>
          <el-button
            type="danger"
            @click="deleteAlreadeSelect(globalstdid, course.course_id)"
            >退课</el-button
          >
        </td>
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
    async deleteAlreadeSelect(student_id, course_id) {
      // 处理获取课程id的逻辑
      console.log("全局学生id: ", student_id);
      console.log("课程id: ", course_id);
      // 发送POST请求
      try {
        const response = await axios.post(
          "http://localhost:9090/uniselect/Course_selection_already_select_delete",
          {
            //变量名要匹配到表名，二次警告
            student_id,
            course_id,
          }
        );
        this.courses = response.data;
        this.$message.success("已选课列表已更新");
      } catch (error) {
        console.error(error);
        this.$message.error("获取信息失败");
      }

      try {
        const response = await axios.post(
          "http://localhost:9090/uniselect/Course_selection_already_select_withid",
          {
            //变量名要匹配到表名，二次警告
            student_id: student_id,
          }
        );
        this.courses = response.data;
        this.$message.success("已选课列表已更新");
      } catch (error) {
        console.error(error);
        this.$message.error("获取信息失败");
      }
      this.$message.success("退课成功");
    },

    //根据学生id展示课程信息
    async getAlreadyCoursesId(studentId) {
      console.log("全局学生id: ", studentId);
      try {
        const response = await axios.post(
          "http://localhost:9090/uniselect/Course_selection_already_select_withid",
          {
            //变量名要匹配到表名，二次警告
            student_id: studentId,
          }
        );
        this.courses = response.data;
        this.$message.success("已选课列表已更新");
      } catch (error) {
        console.error(error);
        this.$message.error("获取信息失败");
      }
      this.$message.success("展示完毕");
    },

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
      window.location.href = "/welcome";
    },
    goToSelectCourse() {
      // 执行已选页面跳转的逻辑
      window.location.href = "/selectcourse";
    },
    goToAlreadySelect() {
      // 执行已选页面跳转的逻辑
      window.location.href = "/alreadyselect";
    },
    goToCourseLayout() {
      // 执行课程表页面跳转的逻辑
      window.location.href = "/courselayout";
    },
    goToNowUserInfo() {
      // 执行个人信息页面跳转的逻辑
      window.location.href = "/nowuserinf";
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

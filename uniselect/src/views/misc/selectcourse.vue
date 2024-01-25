<template>
  <div>
    <div class="navdiv">
      <el-button type="primary" @click="goToWelcome">回到首页</el-button>
      <el-button type="primary" @click="goToSelectCourse">选课</el-button>
      <el-button type="primary" @click="goToAlreadySelect">已选</el-button>
      <!--      <el-button type="primary" @click="goToCourseLayout">增加课程</el-button>-->
      <el-button type="primary" @click="goToNowUserInfo">个人信息</el-button>
    </div>
    <h1>欢迎选课</h1>
    <p class="welcome">
      您的学号：<span>{{ globalstdid }}</span>
    </p>
    <el-button type="warning" @click="getCourses">刷新课程信息</el-button>
    <div id="message">{{ message }}</div>

    <el-input
      v-model="searchKeyword"
      :style="{ width: '200px' }"
      placeholder="请输入要搜索课程名的子串"
    ></el-input>
    <el-button type="primary" @click="searchCourses">搜索</el-button>
    <table v-if="courses.length > 0">
      <thead>
        <tr>
          <th>课程ID</th>
          <th>课程名称</th>
          <th>主讲教师</th>
          <th>课程描述</th>
          <th>课程余量</th>
          <th>可选操作</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="(course, index) in courses" :key="index">
          <!--      要与表字段一样-->
          <td>{{ course.id }}</td>
          <td>{{ course.name }}</td>
          <td>{{ course.teacher }}</td>
          <td>{{ course.description }}</td>
          <td>{{ course.num }}</td>
          <td>
            <el-button
              type="primary"
              @click="
                getCourseId(course.id, course.num, globalstdid, course.name)
              "
              >选课</el-button
            >
            <!--          <el-button type="danger" @click="deleteCourse(course.id)">删课</el-button>-->
            <!--          <el-button type="warning" @click="modifyCourse(course.id)">修改</el-button>-->
          </td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
import axios from "axios";

export default {
  name: "selectcourse",
  data() {
    return {
      courses: [],
      message: "",
      //这里定义全局变量
      globalstdid: "",
      // 搜索的词
      searchKeyword: "",
    };
  },
  mounted() {
    this.globalstdid = localStorage.getItem("globalstdid");
  },
  methods: {
    async modifyCourse(id) {
      // 调用 deleteCourse(id) 方法
      try {
        await axios.post("http://localhost:9090/uniselect/deletecourse", {
          id,
        });
      } catch (error) {
        console.error(error);
        this.$message.error("修改课程失败！");
        return;
      }
      //在调用增加课程方法
      window.location.href = "/courselayout";
    },
    async deleteCourse(id) {
      try {
        await axios.post("http://localhost:9090/uniselect/deletecourse", {
          id,
        });
      } catch (error) {
        console.error(error);
        this.$message.error("删除课程失败！");
        return;
      }
      this.$message.success("删除课程成功！");
    },
    async searchCourses() {
      this.$message.info("输入的内容: " + this.searchKeyword);
      await axios
        .get("http://localhost:9090/uniselect/courses")
        .then((response) => {
          this.courses = response.data;
          this.$message.success("课程列表已更新");
          this.filterCourses();
        })
        .catch((error) => {
          console.error(error);
          this.$message.error("获取课程信息失败");
        });
    },
    filterCourses() {
      if (this.searchKeyword) {
        const filteredCourses = this.courses.filter((course) =>
          course.name.includes(this.searchKeyword)
        );
        this.courses = filteredCourses;
      }
    },
    async getCourses() {
      await axios
        .get("http://localhost:9090/uniselect/courses")
        .then((response) => {
          this.courses = response.data;
          this.$message.success("课程列表已更新");
        })
        .catch((error) => {
          console.error(error);
          this.$message.error("获取课程信息失败");
        });
    },

    async getCourseId(course_id, num, student_id, course_name) {
      // 处理获取课程id的逻辑

      console.log("全局学生id: ", student_id);
      console.log("课程id: ", course_id);
      console.log("课程名: ", course_name);
      // 发送POST请求
      try {
        await axios.post(
          "http://localhost:9090/uniselect/Course_selection_insert",
          {
            //变量名要匹配到表名
            student_id,
            course_id,
            course_name,
          }
        );
      } catch (error) {
        console.log("服务器异常");
        return;
      }
      //刷新课程信息
      await axios
        .get("http://localhost:9090/uniselect/courses")
        .then((response) => {
          this.courses = response.data;
        })
        .catch((error) => {
          console.error(error);
          this.$message.error("刷新课程信息失败");
        });
      this.$message.success("选课成功");
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
      // 执行页面跳转的逻辑
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

<!--是由于在页面加载时，JavaScript尝试访问DOM元素之前，-->
<!--元素还没有被加载到页面上所导致的lobalstdidDisplay的值为null，-->
<!--无法设置其textContent属性。。-->

<!--为了解决这个问题，你可以将JavaScript代码放在页面底部，-->
<!--或者使用DOMContentLoaded事件来确保在DOM完全加载后再执行代码。-->
<!-- 在每个HTML页面中使用JavaScript读取LocalStorage的值 -->
<template>
  <div>
    <nav>
      <div class="navdiv">
        <el-button type="primary" @click="goToWelcome">回到首页</el-button>
        <el-button type="primary" @click="goToSelectCourse">课程管理</el-button>
        <el-button type="primary" @click="goToAlreadySelect"
          >查看学生已选</el-button
        >
        <el-button type="primary" @click="goToCourseLayout">增加课程</el-button>
        <el-button type="primary" @click="goToNowUserInfo">个人信息</el-button>
      </div>
    </nav>
    <h1>User Info</h1>
    <h1>您是：教师</h1>
    <p>
      教师ID：<span id="globalstdid-display">{{ globalstdid }}</span>
    </p>
  </div>
</template>

<script>
export default {
  name: "nowuserinf",
  data() {
    return {
      globalstdid: "",
    };
  },
  mounted() {
    this.globalstdid = localStorage.getItem("globalstdid");
  },
  methods: {
    goToWelcome() {
      // 执行首页跳转的逻辑
      this.$router.push('/welcometeacher');
    },
    goToSelectCourse() {
      // 执行已选页面跳转的逻辑
      this.$router.push('/selectcourseteacher');
    },
    goToAlreadySelect() {
      // 执行已选页面跳转的逻辑
      this.$router.push('/alreadyselectteacher');
    },
    goToCourseLayout() {
      // 执行课程表页面跳转的逻辑
      this.$router.push('/courselayoutteacher');
    },
    goToNowUserInfo() {
      // 执行个人信息页面跳转的逻辑
      this.$router.push('/nowuserinfteacher');
    },
  }
};
</script>
<style>
body {
  background-image: url("@/images/teacher.jpg");
  background-repeat: no-repeat;
  background-size: cover;
  font-family: Arial, sans-serif;
  margin: 20px;
}

h1 {
  text-align: center;
}

p {
  text-align: center;
}

#globalstdid-display {
  font-weight: bold;
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

<template>
  <nav>
    <router-link to="/">系统欢迎页</router-link>
    |
    <router-link to="/login">学生登录</router-link>
    |
    <router-link to="/loginteacher">教师登录</router-link>
    |
    <!--    <router-link to="/register">添加学生</router-link> |-->
    <!--    <router-link to="/test">test</router-link> |-->
  </nav>
  <router-view />
</template>

<style lang="scss">
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

nav {
  padding: 30px;

  a {
    font-weight: bold;
    color: #2c3e50;

    &.router-link-exact-active {
      color: #42b983;
    }
  }
}
</style>

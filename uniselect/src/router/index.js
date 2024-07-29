import {createRouter, createWebHashHistory, createWebHistory} from "vue-router";
import HomeView from "@/views/HomeView.vue";

const routes = [
  {
    path: "/home",
    name: "home",
    component: HomeView,
  },
  {
    path: "/register",
    name: "register",
    component: () => import("@/views/Register.vue"),
  },
  {
    path: "/registerstuadmin",
    name: "registerstuadmin",
    component: () => import("@/views/RegisterStuAdmin.vue"),
  },
  {
    path: "/registerteacher",
    name: "registerteacher",
    component: () => import("@/views/RegisterTeacher.vue"),
  },
  {
    path: "/test",
    name: "test",
    component: () => import("@/views/Test.vue"),
  },
  {
    path: "/",
    name: "firstonce",
    component: () => import("@/views/FirstOnce.vue"),
  },
  {
    path: "/login",
    name: "login",
    component: () => import("@/views/Login.vue"),
  },
  {
    path: "/loginteacher",
    name: "loginteacher",
    component: () => import("@/views/LoginTeacher.vue"),
  },
  {
    path: "/loginadmin",
    name: "loginadmin",
    component: () => import("@/views/LoginAdmin.vue"),
  },
  {
    path: "/welcome",
    name: "welcome",
    component: () => import("@/views/Welcome.vue"),
  },
  {
    path: "/welcometeacher",
    name: "welcometeacher",
    component: () => import("@/views/WelcomeTeacher.vue"),
  },
  {
    path: "/welcomeadmin",
    name: "welcomeadmin",
    component: () => import("@/views/WelcomeAdmin.vue"),
  },
  {
    path: "/alreadyselect",
    name: "alreadyselect",
    component: () => import("@/views/misc/alreadyselect.vue"),
  },
  {
    path: "/alreadyselectteacher",
    name: "alreadyselectteacher",
    component: () => import("@/views/misc/alreadyselectTeacher.vue"),
  },
  {
    path: "/alreadyselectadmin",
    name: "alreadyselectadmin",
    component: () => import("@/views/misc/alreadyselectAdmin.vue"),
  },
  {
    path: "/courselayout",
    name: "courselayout",
    component: () => import("@/views/misc/courselayout.vue"),
  },
  {
    path: "/courselayoutteacher",
    name: "courselayoutteacher",
    component: () => import("@/views/misc/courselayoutTeacher.vue"),
  },
  {
    path: "/courselayoutadmin",
    name: "courselayoutadmin",
    component: () => import("@/views/misc/courselayoutAdmin.vue"),
  },
  {
    path: "/nowuserinf",
    name: "nowuserinf",
    component: () => import("@/views/misc/nowuserinf.vue"),
  },
  {
    path: "/nowuserinfteacher",
    name: "nowuserinfteacher",
    component: () => import("@/views/misc/nowuserinfTeacher.vue"),
  },
  {
    path: "/nowuserinfadmin",
    name: "nowuserinfadmin",
    component: () => import("@/views/misc/nowuserinfAdmin.vue"),
  },
  {
    path: "/selectcourse",
    name: "selectcourse",
    component: () => import("@/views/misc/selectcourse.vue"),
  },
  {
    path: "/selectcourseadmin",
    name: "selectcourseadmin",
    component: () => import("@/views/misc/selectcourseAdmin.vue"),
  },
  {
    path: "/selectcourseteacher",
    name: "selectcourseteacher",
    component: () => import("@/views/misc/selectcourseTeacher.vue"),
  },
];

const router = createRouter({
  // history: createWebHistory(process.env.BASE_URL),
  history: createWebHashHistory(),
  routes,
});

export default router;

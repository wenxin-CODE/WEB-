import Vue from 'vue'
import VueRouter from 'vue-router'
import Login from '@/views/Login'

Vue.use(VueRouter)

const routes =  [
  {
    path: '/',
    name: '框架',
    component: () => import('../views/Manage.vue'),
    // component: () => Promise.resolve(require('../views/Manage.vue').default),
    // '/'重定向到'/home'
    redirect: "/login",
    children: [
      {
        path: 'home',
        name: '主界面',
        component: () => import("../views/Home.vue")
      },
      {
        path: 'user',
        name: '用户表',
        component: () => import("../views/User.vue")
      },
      {
        path: 'person',
        name: '个人信息',
        component: () => import("../views/Person.vue")
      },
      {
        path: '/about',
        name: 'About',
        // route level code-splitting
        // this generates a separate chunk (about.[hash].js) for this route
        // which is lazy-loaded when the route is visited.
        component: () => import(/* webpackChunkName: "about" */ '../views/About.vue')
      },
    ]
  },
  // {
  //   path: '/about',
  //   name: 'About',
  //   // route level code-splitting
  //   // this generates a separate chunk (about.[hash].js) for this route
  //   // which is lazy-loaded when the route is visited.
  //   component: () => import(/* webpackChunkName: "about" */ '../views/About.vue')
  // },
  {
    path: '/login',
    name: 'Login',
    component: () => import('../views/Login.vue')
  },
  {
    path: '/register',
    name: 'Register',
    component: () => import('../views/Register.vue')
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

// 获取当前路由
router.beforeEach((to,from,next) => {
  localStorage.setItem("currentPathName",to.name)
  // store.commit("setPath") //触发store数据更新
  next() //放行
})

export default router

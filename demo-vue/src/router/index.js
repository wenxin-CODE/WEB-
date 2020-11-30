import Vue from 'vue'
import Router from 'vue-router'
import AppIndex from '@/components/home/AppIndex'
import Login from '@/components/Login'
import Home from '../components/Home'
import FoodIndex from '../components/food/FoodIndex'
/*配置路由 */

Vue.use(Router)

export default new Router({
  //hash模式转history模式：六节；还可打包部署至后端
  mode: 'history',
  routes: [
    {
      path: '/login',
      name: 'Login',
      component: Login
    },
    {
      path: '/home',
      //home并不需要被访问
      path: '/Home',
      component: Home,
      children: [
        {
          path: '/index',
          name: 'Appindex',
          component :AppIndex,
          meta: {
            requireAuth: true
          }
        },
        {
          path: '/food',
          name: 'Food',
          component: FoodIndex,
          meta: {
            requireAuth: true
          }
        }
      ]
    }
  ]
})

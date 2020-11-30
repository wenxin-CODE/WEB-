// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import store from './store'

/*设置反向代理，可以用一个端口跑多个应用*/
/**
 * 利用axios库，和后台交互获取数据
 * https://www.cnblogs.com/ysx215/p/10501998.html
 */
var axios = require('axios')
axios.defaults.baseURL = 'http://localhost:8445/api'

Vue.prototype.$axios = axios
Vue.config.productionTip = false
//引入ElementUI
Vue.use(ElementUI)

//首先判断访问的路径是否需要登录，如果需要，
//判断 store 里有没有存储 user 的信息，如果存在，则放行，
//否则跳转到登录页面，并存储访问的页面路径
router.beforeEach((to, from, next) => {
  if (to.meta.requireAuth) {
    if (store.state.user.username) {
      next()
    } else {
      next({
        path: 'login',
        query: {redirect: to.fullPath}
      })
    }
  } else {
    next()
  }
}
)

/* eslint-disable no-new */
new Vue({
  el: '#app',
  render: h => h(App),
  router,
  store,
  components: { App },
  template: '<App/>'
})

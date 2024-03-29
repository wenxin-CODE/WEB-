import Vue from 'vue'
import App from './App.vue'
import router from './router'
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
import './assets/gloable.css'
import request from './utils/request';
import axios from "axios"
// ��������ȫ��css

Vue.config.productionTip = false

Vue.use(ElementUI,{ size: "mini" })
// ����elementui��ָ��ʹ��С�Ϳؼ�

// ����utils/request.js,ע��http
// Vue.prototype.request=request
Vue.prototype.axios=axios

new Vue({
  router,
  // store,
  render: h => h(App)
}).$mount('#app')

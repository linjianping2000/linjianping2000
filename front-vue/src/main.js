import Vue from 'vue'
import App from './App.vue'

import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
// vue-router
import router from '@/router/index'

// vuex
import store from "@/store/index";

import axios from 'axios'
import VueAxios from 'vue-axios'

import mavonEditor from 'mavon-editor'
import 'mavon-editor/dist/css/index.css'

Vue.use(mavonEditor)

axios.defaults.baseURL = 'http://localhost:8082/ap'
axios.defaults.withCredentials = true
// 默认是发的json格式，后端用对象接收
axios.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded';

Vue.use(VueAxios, axios)
Vue.use(ElementUI)

Vue.config.productionTip = false

new Vue({
    router,
    render: h => h(App),
    store,
    data() {
        return {}
    },
}).$mount('#app')

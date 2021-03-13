import { createApp } from 'vue'
import App from '@/App.vue'
import '@/styles/base.scss'
import router from './router'
const axios = require('axios').default

axios.defaults.baseURL = process.env.VUE_APP_API

createApp(App).use(router).mount('#app')

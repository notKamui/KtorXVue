import {createApp} from 'vue'
import App from '@/App.vue'
const axios = require('axios').default

axios.defaults.baseURL = process.env.VUE_APP_API

createApp(App).mount('#app')

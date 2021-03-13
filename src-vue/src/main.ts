import { createApp } from 'vue';
import router from './router';
import App from '@/App.vue';
import '@/styles/base.scss';

require('axios').default.defaults.baseURL = process.env.VUE_APP_API;

createApp(App).use(router).mount('#app');

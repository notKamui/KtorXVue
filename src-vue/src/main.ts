import { createApp } from "vue";
import App from "@/App.vue";
import router from "@/router";
import store from "@/store";

require("axios").default.defaults.baseURL = process.env.VUE_APP_API;

createApp(App).use(store).use(router).mount("#app");

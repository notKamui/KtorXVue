<template>
  <div id="app">
    <img alt="Vue logo" src="../assets/logo.png"/>
    <div>
      <h1>This is a Ktor x Vue template</h1>
      <h2>{{ apiVersion }}</h2>
    </div>
  </div>
</template>

<script lang="ts">
import { ref, defineComponent } from 'vue';
const axios = require('axios').default;

const apiVersion = ref<string>('');

const getApiVersion = () => {
  axios.get('/').then((res: any) => {
    apiVersion.value = res.data;
  }).catch(() => {
    apiVersion.value = 'Could not resolve API version';
  })
};

export default defineComponent({
  setup() {
    return {
      apiVersion
    }
  },
  mounted() {
    getApiVersion();
  }
});
</script>

<style scoped>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>

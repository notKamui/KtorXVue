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
import axios from 'axios'

export default {
  name: 'HelloWorld',
  setup() {
    let apiVersion = '';
    axios.get('/').then(res => {
      apiVersion = res.data;
    }).catch(() => {
      apiVersion = 'Could not resolve API version';
    })
    return {
      apiVersion
    }
  },
};
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

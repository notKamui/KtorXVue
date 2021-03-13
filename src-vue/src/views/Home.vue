<template>
  <div class="home">
    <img alt="Vue logo" src="../assets/logo.png" />
    <div>
      <h1>This is a Ktor x Vue template</h1>
      <h2>{{ state.apiVersion }}</h2>
    </div>
  </div>
</template>

<script lang="ts">
import { reactive } from "vue";

export default {
  setup() {
    const axios = require("axios").default;
    const state = reactive({
      apiVersion: "",
    });

    function getApiVersion() {
      axios
        .get("/")
        .then((res: any) => {
          state.apiVersion = res.data;
        })
        .catch(() => {
          state.apiVersion = "Could not resolve API version";
        });
    }

    getApiVersion();

    return {
      state,
    };
  },
};
</script>

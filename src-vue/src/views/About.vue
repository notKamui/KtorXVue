<template>
  <div>
    <img alt="Vue logo" src="@/assets/logo.png" />
    <div>
      <h1>This is a Ktor x Vue template</h1>
      <h2>{{ apiVersion }}</h2>
    </div>
  </div>
</template>

<script lang="ts">
import { computed, ComputedRef } from "vue";
import { useStore } from "vuex";

interface State {
  apiVersion: ComputedRef<string>;
}

export default {
  setup(): State {
    const store = useStore();
    store.dispatch("KotlinAPI/fetchApiVersion");

    const apiVersion = computed(() => store.state.KotlinAPI.apiVersion);

    return {
      apiVersion,
    };
  },
};
</script>

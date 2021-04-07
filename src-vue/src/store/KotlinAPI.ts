const axios = require("axios").default;

export const KotlinAPIModule = {
  namespaced: true,

  state: {
    apiVersion: "",
  },

  mutations: {
    SET_API_VERSION(state: { apiVersion: string }): void {
      axios
        .get("/")
        .then((res: { data: string }) => {
          state.apiVersion = res.data;
        })
        .catch(() => {
          state.apiVersion = "Could not resolve API version";
        });
    },
  },

  actions: {
    fetchApiVersion({ commit }: { commit: (mut: string) => void }): void {
      commit("SET_API_VERSION");
    },
  },
};

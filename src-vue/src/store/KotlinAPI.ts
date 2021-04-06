const axios = require("axios").default;

export const KotlinAPIModule = {
  namespaced: true,

  state: {
    apiVersion: "",
  },

  mutations: {
    SET_API_VERSION(state: any): void {
      axios
        .get("/")
        .then((res: any) => {
          state.apiVersion = res.data;
        })
        .catch(() => {
          state.apiVersion = "Could not resolve API version";
        });
    },
  },

  actions: {
    fetchApiVersion({ commit }: any): void {
      commit("SET_API_VERSION");
    },
  },
};

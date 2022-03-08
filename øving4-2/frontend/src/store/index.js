import Vuex from "vuex";

export const store = new Vuex.Store({
  strict: true,
  state: {
    name: "",
    email: "",
    message: "",
  },
  mutations: {
    updateMessage(state, message) {
      state.message = message;
    },
    updateName(state, name) {
      state.name = name;
    },
    updateEmail(state, email) {
      state.email = email;
    },
  },
});

export default store;

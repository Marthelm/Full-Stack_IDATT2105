import Vuex from "vuex";

export const store = new Vuex.Store({
  strict: true,
  state: {
    name: "",
    email: "",
    message: "",
    signedInStatus: "",
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
    updateSignedInStatus(state, signedInStatus) {
      state.signedInStatus = signedInStatus;
    },
  },
});

export default store;

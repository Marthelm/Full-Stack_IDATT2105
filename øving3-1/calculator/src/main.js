import { createApp } from "vue";
import App from "./App.vue";
import router from "./router";
import Vuex from "vuex";

// Create a new store instance.
const store = new Vuex.Store({
  strict: true,
  state: {
    message: "",
  },
  mutations: {
    updateMessage(state, message) {
      state.message = message;
    },
  },
});

const app = createApp(App);
app.use(store);
app.use(router).mount("#app");

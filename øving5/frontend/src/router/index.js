import { createRouter, createWebHistory } from "vue-router";
import Home from "../views/Calculator.vue";
import FeedBackForm from "../views/FeedBackForm.vue";
import SignIn from "../views/SignIn.vue";

const routes = [
  {
    path: "/",
    name: "Home",
    component: Home,
  },
  {
    path: "/feedBack",
    name: "FeedBack",
    component: FeedBackForm,
  },
  {
    path: "/signin",
    name: "SignIn",
    component: SignIn,
  },
];

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes,
});

export default router;

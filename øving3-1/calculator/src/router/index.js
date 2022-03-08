import { createRouter, createWebHistory } from "vue-router";
import Home from "../views/Calculator.vue";
import FeedBackForm from "../views/FeedBackForm.vue";

const routes = [
  {
    path: "/",
    name: "Home",
    component: Home,
  },
  {
    path: "/feedBack",
    name: "FeedBack",
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: FeedBackForm,
  },
];

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes,
});

export default router;

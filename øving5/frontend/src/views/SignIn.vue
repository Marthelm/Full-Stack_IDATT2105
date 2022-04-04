<template>
  <form @submit.prevent="handleSignIn">
    <label>Username:</label>
    <input v-model="username" required name="username" />
    <div v-if="usernameError" class="error">{{ nameError }}</div>

    <label>Password:</label>
    <input v-model="password" required name="password"/>
    <div v-if="passwordError" class="error">{{ passwordError }}</div>

    <div class="btnSignIn">
      <button>Send FeedBack</button>
    </div>
  </form>
  <div class="status">{{ status }}</div>
</template>
<script>
  import {getUser} from "../service/importHandling.js";
export default {
  state:{
  },
  data() {
    return {
      username: "",
      usernameError: null,
      passwordError: null,
      status: null,
    };
  },
  methods: {
    async handleSignIn(submitEvent) {
      let typedUsername = submitEvent.target.elements.username.value;
      let typedPassword = submitEvent.target.elements.password.value;
      const user = await getUser(typedUsername);
      console.log(user.data)
      if(user.data == null){
        console.log("user not in system")
      }else{
        if(user.data.username == typedUsername && user.data.password == typedPassword){
          console.log("match in system")
          this.updateSignedInStatus(user.data.username)
        }
      }
    },
    updateSignedInStatus(e) {
      this.$store.commit("updateSignedInStatus", e);
    }
  },
};
</script>
<style scoped></style>
<template>
  <form @submit.prevent="handleSignIn" v-if="!signedInStatus" >
    <label>Username:</label>
    <input v-model="username" required name="username" />
    <div v-if="usernameError" class="error">{{ nameError }}</div>

    <label>Password:</label>
    <input type="password" name="password"/>
    <div v-if="passwordError" class="error">{{ passwordError }}</div>

    <div class="btnSignIn">
      <button>Send FeedBack</button>
    </div>
  </form>
  <p v-else>Already signed in</p>
  <div class="status">{{ status }}</div>
</template>
<script>
  import {doLogin} from "../service/importHandling.js";
export default {
  state:{
  },
  data() {
    return {
      username: "",
      usernameError: null,
      passwordError: null,
      status: null,
      signedInStatus: this.$store.state.signedInStatus,
    };
  },
  methods: {
    async handleSignIn(submitEvent) {
      let typedUsername = submitEvent.target.elements.username.value;
      let typedPassword = submitEvent.target.elements.password.value;
      const loginRequest = { username:typedUsername, password: typedPassword };
      const loginResponse = await doLogin(loginRequest);
      if(loginResponse == "success"){
          this.updateSignedInStatus(typedUsername);
          this.$router.push('/');
      }else{
        console.log("User not in system");
      }
      },
    updateSignedInStatus(e) {
      this.$store.commit("updateSignedInStatus", e);
    }
  },
};
</script>
<style scoped></style>
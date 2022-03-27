<template>
  <form @submit.prevent="handleSignIn">

    <label>Username:</label>
    <input :placeholder="username" v-model="username" required>
    <div v-if="usernameError" class="error">{{ nameError }}</div>

    <label>Password:</label>
    <input :placeholder="password" v-model="password" required>
    <div v-if="passwordError" class="error">{{ passwordError }}</div>


    
    <div class="btnSignIn">
      <button>Send FeedBack</button>
    </div>
  </form>
  <div class="status">{{ status }}</div>
</template>
<script>
export default {
    data(){
        return {
            usernameError : null,
            passwordError:null,
            status:null,
        }
    },
    methods:{
        handleSignIn(){
            console.log("signed in");
        },
        updateSignedInStatus(e){
            this.$store.commit("updateSignedInStatus",e)
        },
    }
}
</script>
<style scoped>

</style>
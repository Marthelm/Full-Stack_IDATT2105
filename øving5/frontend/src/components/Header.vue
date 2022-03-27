<template>
  <div id="nav-bar">
    <div id="tags">
      <router-link to="/">Home</router-link> |
      <router-link to="/signin">Sign In</router-link>|
      <router-link to="/feedBack">FeedBack</router-link>
    </div>

    <div id="status">
        <p>{{signedInStatus}}</p>
    </div>
  </div>
</template>

<style scoped>
#nav-bar {
  width: 100%;
  padding: 30px 0px 30px 0px;
  display: flex;
  flex-direction: row;
  justify-content: center;
}
#tags {
    background-color: antiquewhite;
}
#status {
    position: absolute;
    right: 0;
    top:0;
    margin-top: 30px;
}
#nav-bar a {
  font-weight: bold;
  color: #2c3e50;
}

#nav-bar a.router-link-exact-active {
  color: #42b983;
}
</style>
<script>
export default{
computed:{
    signedInStatus:{
        get() {
            return this.$store.state.signedInStatus
        }
    },
},
};
</script>

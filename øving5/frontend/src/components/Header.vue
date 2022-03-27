<template>
    <div id="nav-bar">
    <router-link to="/">Home</router-link> |
    <router-link to="/signin">Sign In</router-link>|
    <router-link to="/feedBack">FeedBack</router-link>
    <div>
      <p> tag that shows hows logged in</p>  
    </div> 
  </div>
</template>

<style scoped>
#nav-bar {
  padding: 30px;
}

#nav-bar a {
  font-weight: bold;
  color: #2c3e50;
}

#nav-bar a.router-link-exact-active {
  color: #42b983;
}
</style>
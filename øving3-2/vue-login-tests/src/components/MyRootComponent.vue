<template>
  <!--3. Use -->
  <LoginComponent></LoginComponent>
  <SyncAsyncExample></SyncAsyncExample>
</template>

<script>
// 1. Import
import LoginComponent from "./LoginComponent.vue";
import SyncAsyncExample from "./SyncAsyncExample.vue";

// 2. Bind
export default {
  name: 'MyRootComponent',
  components: {
    LoginComponent,
    SyncAsyncExample
  }
}
</script>

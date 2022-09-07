<template>
  <v-main>
    <h1 align="center" class="mb-8">Movies</h1>
    <h3 align="center">In development, check again soon</h3>
  </v-main>
</template>

<script>
  import store from "@/store/store";

  export default {
    mounted() {
      if (store.state.user.loggedIn === false) {
        this.$router.push('/');
      }
    }
  }
</script>
<template>
  <v-card>
    <v-toolbar>
      <v-toolbar-title>movie-rankings</v-toolbar-title>
      <v-icon class="ml-3">mdi-movie</v-icon>

      <v-spacer></v-spacer>

      <v-btn plain x-large to="/">Home</v-btn>
      <v-btn v-if="loggedIn" plain x-large to="/movies">Movies</v-btn>
      <v-btn plain x-large to="/about">About</v-btn>
      <v-btn plain x-large to="/changelog">Changelog</v-btn>
    </v-toolbar>
  </v-card>
</template>

<script>
  import store from "@/store/store";

  export default {
    name: "NavBar",

    computed: {
      loggedIn() {
        return store.state.user.loggedIn;
      }
    }
  }
</script>
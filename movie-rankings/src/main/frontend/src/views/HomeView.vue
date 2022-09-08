<template>
  <v-layout justify-center align-center>
    <v-card justify="center" width="250px">
      <v-card-title class="justify-center mb-5 color:color='#1DB954'">
        movie-rankings
      </v-card-title>

      <v-card-actions>
        <v-row justify="center">
          <v-btn
              v-if="this.loggedIn===false"
              large
              width="200px"
              class="mb-5"
              @click="redirect('/login')"
          >Login</v-btn>

          <v-btn
              v-if="this.loggedIn===false"
              large
              width="200px"
              class="mb-5"
              @click="redirect('/create-account')"
          >Create Account</v-btn>

          <v-btn
              v-if="this.loggedIn===true"
              large
              width="200px"
              class="mb-5"
              @click="redirect('/movies')"
          >Rank Movies</v-btn>

          <v-btn
              large
              width="200px"
              class="mb-5"
              @click="redirect('/about')"
          >About</v-btn>

          <v-btn
              large
              width="200px"
              class="mb-5"
              @click="redirect('/changelog')"
          >Changelog</v-btn>

          <v-btn
              v-if="this.loggedIn===true"
              large
              width="200px"
              class="mb-5"
              @click="logout()"
          >Logout</v-btn>
        </v-row>

      </v-card-actions>

    </v-card>
  </v-layout>
</template>

<script>
  import store from "../store/store";

  export default {
    created() {
      document.title = "movie-rankings"
    },

    computed: {
      loggedIn() {
        return store.state.user.loggedIn;
      }
    },

    methods: {
      redirect(link) {
        this.$router.push(link);
      },

      logout() {
        store.state.user.username = "";
        store.state.user.password = "";
        store.state.user.jwt = "";
        store.state.user.email = "";
        store.state.user.movies = [];
        store.state.user.loggedIn = false;
      }
    }
  }
</script>
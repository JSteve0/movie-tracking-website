<template>
  <v-layout justify-center align-center>
    <v-card justify="center" width="250px">
      <v-card-title class="justify-center mb-5">
        movie-rankings
      </v-card-title>

      <v-card-actions>
        <v-row justify="center">
          <v-btn
              v-if="this.$loggedIn===false"
              large
              width="200px"
              class="mb-5"
              @click="redirect('/login')"
          >Login</v-btn>

          <v-btn
              v-if="this.$loggedIn===false"
              large
              width="200px"
              class="mb-5"
              @click="redirect('/create-account')"
          >Create Account</v-btn>

          <v-btn
              v-if="this.$loggedIn===true"
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
        </v-row>

      </v-card-actions>

    </v-card>
  </v-layout>
</template>

<script>
  export default {
    created() {
      document.title = "movie-rankings"
    },

    methods: {
      redirect(link) {
        this.$router.push(link);
      }
    }
  }
</script>
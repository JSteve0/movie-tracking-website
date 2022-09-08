<template>
  <v-layout justify-center align-center>
    <v-card justify="center" width="350px">
      <v-card-title class="justify-center">Login Page</v-card-title>

      <v-card-text>
        <v-text-field
            v-model="email"
            label="Email"
            :rules="[() => !!email || 'This field is required']"
            outlined
            class="mx-5"
        >
        </v-text-field>

        <v-text-field
            v-model="password"
            label="Password"
            type="password"
            :rules="[() => !!password || 'This field is required']"
            outlined
            class="mx-5"
        >
        </v-text-field>
      </v-card-text>

      <v-card-actions>

        <v-row justify="center">
          <v-btn
            large
            class="mb-5"
            :disabled="checkFields"
            color="#1DB954"
            @click="login()"
          >Login</v-btn>
        </v-row>

      </v-card-actions>
    </v-card>
  </v-layout>
</template>

<script>
  import api from '../api.js'
  import store from "@/store/store";

  export default {
    data() {
      return {
        email: "",
        password: ""
      }
    },

    computed: {
      checkFields() {
        return !(this.email !== "" && this.password !== "");
      }
    },

    methods: {
      async login() {
        let response = await api.login(this.email, this.password);
        if (response.status !== 200) {
          console.log("Error");
          this.$root.$emit("showMessage", "Error", 3000);
        } else if (response.data === null || response.data === "") {
          console.log("Username and/or password is incorrect");
          this.$root.$emit("showMessage", "Username and/or password is incorrect", 3000);
        } else {
          let user = response.data;
          this.$root.$emit("showMessage", "Logged in. Welcome " + user.username + "!", 3000);
          store.state.user.loggedIn = true;
          store.state.user.username = user.username;
          store.state.user.password = this.password;
          store.state.user.movies = user.movies;
          store.state.user.email = user.email;
          console.log(store.state.user);
          setTimeout(() => {
            this.redirect('/')
          }, 1000)
        }
      },

      redirect(link) {
        this.$router.push(link);
      }
    }
  }
</script>
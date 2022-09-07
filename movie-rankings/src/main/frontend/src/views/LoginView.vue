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
            @click="login()"
          >Login</v-btn>
        </v-row>

      </v-card-actions>

    </v-card>
  </v-layout>
</template>

<script>
  import api from '../api.js'

  export default {
    data() {
      return {
        email: "",
        password: ""
      }
    },

    created() {

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
          console.log("error: " + response.data);
        } else {
          console.log(response.data);
          this.$loggedIn = true;
          console.log(this.$loggedIn);
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
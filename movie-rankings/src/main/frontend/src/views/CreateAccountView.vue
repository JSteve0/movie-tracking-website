<template>
  <v-layout justify-center align-center>
    <v-card justify="center" width="350px">

      <v-card-title class="justify-center">Create Account</v-card-title>

      <v-card-text>

        <v-text-field
            v-model="username"
            label="Username"
            :rules="[() => !!username || 'This field is required']"
            outlined
            class="mx-5"
        >
        </v-text-field>

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

        <v-text-field
            v-model="confirmPassword"
            label="Confirm Password"
            type="password"
            :rules="[
              () => !!confirmPassword || 'This field is required',
              () => !!confirmPassword && confirmPassword === password || 'Passwords must match'
            ]"
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
              @click="createAccount()"
          >Create Account</v-btn>
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
        username: "",
        email: "",
        password: "",
        confirmPassword: ""
      }
    },

    created() {

    },

    computed: {
      checkFields() {
        return !(this.username !== "" &&
                this.email !== "" &&
                this.password !== "" &&
                this.confirmPassword !== "" &&
                this.password === this.confirmPassword);
      }
    },

    methods: {
      async createAccount() {
        await api.createUser({
          email: this.email,
          password: this.password,
          username: this.username,
          movies: null,
          id: null
        });
      }
    }
  }
</script>
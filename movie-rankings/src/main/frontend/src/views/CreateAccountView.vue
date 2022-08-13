<template>
  <v-layout justify-center align-center>
    <v-card justify="center" width="350px">

      <v-card-title class="justify-center">Create Account</v-card-title>

      <v-card-text>

        <v-text-field
            label="Username"
            outlined
            class="mx-5"
        >
        </v-text-field>

        <v-text-field
            label="Email"
            outlined
            class="mx-5"
        >
        </v-text-field>

        <v-text-field
            label="Password"
            type="password"
            outlined
            class="mx-5"
        >
        </v-text-field>

        <v-text-field
            label="Confirm Password"
            type="password"
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
          >Create Account</v-btn>
        </v-row>

      </v-card-actions>

    </v-card>
  </v-layout>
</template>
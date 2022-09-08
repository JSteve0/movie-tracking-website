<template>
  <v-app>
    <nav-bar/>
    <router-view/>
    <v-snackbar
      v-model="snackbar"
      :timeout="timeout"
    >
      {{ snackbarMessage }}

      <template v-slot:action="{ attrs }">
        <v-btn
            color="blue"
            text
            v-bind="attrs"
            @click="snackbar = false"
        >
          Close
        </v-btn>
      </template>
    </v-snackbar>
  </v-app>
</template>

<style lang="scss">
  //fixes navbar
  html { overflow-y: auto }
</style>

<script>
import NavBar from "@/components/NavBar";
export default {
  components: {NavBar},
  data: () => ({
    snackbar: false,
    snackbarMessage: '',
    timeout: 2000,
  }),

  mounted() {
    this.$root.$on("showMessage", (snackbarMessage, duration) => {
      this.snackbar = false;
      this.snackbarMessage = snackbarMessage;
      this.timeout = duration;
      this.snackbar = true;
    }),
    this.$root.$on("showMessage", (snackbarMessage) => {
      this.snackbar = false;
      this.snackbarMessage = snackbarMessage;
      this.snackbar = true;
    })
  }
}
</script>
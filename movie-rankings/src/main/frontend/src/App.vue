<template>
  <v-app>
    <nav-bar/>
    <router-view/>
  </v-app>
</template>

<style lang="scss">
  //fixes navbar
  html { overflow-y: auto }
</style>

<script>
import NavBar from "@/components/NavBar";
export default {
  components: {NavBar}
}
</script>
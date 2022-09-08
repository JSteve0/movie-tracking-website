<template>
  <v-layout justify-center align-center>
    <v-card>
      <v-card-title class="justify-center">
        All Movies
        <v-spacer></v-spacer>
        <v-btn>click</v-btn>
      </v-card-title>

      <v-data-table
        :headers="headers"
        :items="items"
        :items-per-page="15"
        class="elevation-1"
      >
        <template #[`item.actions`]>
          <v-icon
              small
              class="mr-2"
          >
            mdi-pencil
          </v-icon>
          <v-icon
              small
          >
            mdi-delete
          </v-icon>
        </template>

      </v-data-table>
    </v-card>
  </v-layout>
</template>

<script>
  import store from "@/store/store";
  export default {
    data() {
      return {
        headers: [
          {
            text: 'Movie',
            value: 'name',
            sortable: true,
            align: 'start'
          },
          {text: 'Rating', value: 'rating', align: ''},
          {text: 'Actions', value: 'actions', sortable: false }
        ]
      }
    },

    computed: {
      items() {
        let movies = [];
        store.state.user.movies.forEach(movie => {
          movies.push({name: movie.name, rating: movie.rating})
        });
        console.log(movies)
        return movies;
      }
    },

    mounted() {
      if (store.state.user.loggedIn === false) {
        this.$router.push('/');
      }
    }
  }
</script>
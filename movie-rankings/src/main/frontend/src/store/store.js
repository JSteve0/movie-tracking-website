import Vue from 'vue';
import Vuex from 'vuex';

Vue.use(Vuex);

const moduleUser = {
    namespaced: true,
    state: {
        loggedIn: false,
        username: "",
        email: "",
        password: "",
        jwt: "",
        movies: []
    }
}

export default new Vuex.Store({
    modules: {
        user: moduleUser
    }
});
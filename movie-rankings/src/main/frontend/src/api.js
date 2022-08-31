import axios from 'axios'

export default {

    async getAllUsers() {
        return axios.get('http://localhost:8081/api/user/find-all')
    },

    async createUser(user) {
        return axios.post('http://localhost:8081/api/user/create-user', user);
    }

}
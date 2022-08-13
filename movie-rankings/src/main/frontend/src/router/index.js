import Vue from 'vue'
import VueRouter from 'vue-router'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: '',
    component: () => import(/* webpackChunkName: "about" */ '../views/HomeView.vue')
  },
  {
    path: '/login',
    name: 'login',
    component: () => import(/* webpackChunkName: "about" */ '../views/LoginView.vue')
  },
  {
    path: '/create-account',
    name: 'create-account',
    component: () => import(/* webpackChunkName: "about" */ '../views/CreateAccountView.vue')
  },
  {
    path: '/about',
    name: 'about',
    component: () => import(/* webpackChunkName: "about" */ '../views/AboutPageView.vue')
  },
  {
    path: '/changelog',
    name: 'changelog',
    component: () => import(/* webpackChunkName: "about" */ '../views/ChangeLogView.vue')
  },
  {
    path: '/movies',
    name: 'movies',
    component: () => import(/* webpackChunkName: "about" */ '../views/MoviesView.vue')
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router

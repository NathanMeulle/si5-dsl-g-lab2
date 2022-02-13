import Vue from 'vue'
import VueRouter from 'vue-router'
import Pagedeclassement1 from '../views/Pagedeclassement1.vue'
import Pagedeclassement2 from '../views/Pagedeclassement2.vue'
Vue.use(VueRouter)
const routes = [
  {
    path: '/',
    name: 'Pagedeclassement1',
    component: Pagedeclassement1
  },  {
    path: '/Pagedeclassement1',
    name: 'Pagedeclassement1',
    component: Pagedeclassement1
  },  {
    path: '/Pagedeclassement2',
    name: 'Pagedeclassement2',
    component: Pagedeclassement2
  },
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
import Vue from 'vue'
import VueRouter from 'vue-router'
import Login from '../views/Login.vue'
import Admin from '../views/Admin.vue'
import PageNotFound from '../views/PageNotFound.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Login',
    component: Login
  },
  {
    path: '/login',
    name: 'Login',
    component: Login
  },
  {
    path: '/admin',
    name: 'Admin',
    component: Admin,
    children: [
      {
        path: 'modifyPwd',
        name: 'ModifyPwd',
        component: () => import("../components/ModifyPwd.vue")
      },
      {
        path: 'information',
        name: 'Information',
        component: () => import('../components/Information.vue')
      },
      {
        path: 'addBlog',
        name: 'AddBlog',
        component: () => import('../components/AddBlog.vue')
      },
      {
        path: 'blogList',
        name: 'BlogList',
        component: () => import('../components/BlogList.vue')
      },
      {
        path: 'updateBlog/:blogId',
        name: 'UpdateBlog',
        component: () => import("../components/UpdateBlog.vue")
      }
    ]
  },
  {
    path:'/*',
    name: 'PageNotFound',
    component: PageNotFound
  }
]

const router = new VueRouter({
  routes
})

export default router

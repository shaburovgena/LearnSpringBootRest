import Vue from 'vue'
import VueRouter from 'vue-router'
import MessagesList from 'pages/MessageList.vue'
import Auth from 'pages/Auth.vue'
import Profile from 'pages/Profile.vue'

Vue.use(VueRouter)

const routes = [
//Порядок маппинга имеет значение
    {path: '/', component: MessagesList},
    {path: '/auth', component: Auth},
    {path: '/profile', component: Profile},
    {path: '*', component: MessagesList},
]

export default new VueRouter({
    mode: 'history',
    routes
})

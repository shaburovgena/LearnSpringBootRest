import Vue from 'vue'
import VueRouter from 'vue-router'
import MessagesList from 'pages/MessageList.vue'
import Auth from 'pages/Auth.vue'
import Profile from 'pages/Profile.vue'

Vue.use(VueRouter)

const router = [
//Порядок маппинга имеет значение
    {path: '/', component: MessagesList},
    {path: '/ath', component: Auth},
    {path: '*', component: MessagesList},
]

export default new VueRouter({
    mode: 'history',

    routes
})

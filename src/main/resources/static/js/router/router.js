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
    //Знак вопроса указывает, что параметр id не обязателен, чтобы был еще маппинг на просто "/user"
    {path: '/user/:id?', component: Profile},
    {path: '*', component: MessagesList},
]

export default new VueRouter({
    mode: 'history',
    routes
})

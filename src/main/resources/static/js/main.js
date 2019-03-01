import Vue from 'vue'
import 'api/resource'
import App from 'pages/App.vue'
import {connect} from './util/ws'
import Vuetify from 'vuetify'
import 'vuetify/dist/vuetify.min.css'

if (frontendData.profile) {
    connect()
}
Vue.use(Vuetify)
new Vue({
    el: '#app',
    //Необходимо в компонент #app поместить отрендеренный App
    render: a => a(App)
})


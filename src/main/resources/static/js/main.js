import Vue from 'vue'
import VueResource from 'vue-resource'
import App from 'pages/App.vue'

Vue.use(VueResource)

new Vue({
    el: '#app',
    //Необходимо в компонент #app поместить отрендеренный App
    render: a => a(App)
})


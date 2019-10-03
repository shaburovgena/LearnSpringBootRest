<template>
    <span></span>
</template>
<!--Отображать обработчик только на время прокрутки, чтобы не занимать память будем от него отписываться,
нужен листенер-->
<script>
    import {mapActions} from 'vuex';

    export default {
        name: "LazyLoader",
        methods: mapActions(['loadPageAction']),
        mounted() {
            window.onscroll = () => {
                const el = document.documentElement;
//Проверяем на соответствие что текущая позиция + высота окна эквивалентна высоте документа
                const isBottomOfScreen = el.scrollTop + window.innerHeight === el.offsetHeight;
                if (isBottomOfScreen) {
                    this.loadPageAction();
                }
            }
        },
        beforeDestroy() {
            window.onscroll = null;
        }
    }
</script>

<style scoped>

</style>
<!--Это что называется однофайловый Vue компонент-->

<!--Разметка-->
<template>
    <div>
        <div v-if="!profile">Необходимо авторизоваться через <a href="/login">Google</a>
        </div>
        <div v-else>
            <div>{{profile.name}}&nbsp;<a href="/logout">Выйти</a>
            </div>
            <!--<messages-list :messages="messages"/>-->
        </div>
    </div>
</template>
<!--Код-->
<script>
    import MessagesList from 'components/messages/MessageList.vue'
    export default {
        comments:{
          MessagesList
        },
        data: {
            messages: frontendData.messages,
            profile: frontendData.profile
        }
    }

</script>
<!--Стили-->
<style>

</style>
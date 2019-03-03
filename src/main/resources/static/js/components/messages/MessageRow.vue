<template>
        <v-card class="my-2">
            <v-card-text primary-title>
                <i>({{ message.id }})</i>
                {{ message.text }}
            </v-card-text>

        <v-card-actions>
            <v-btn @click="edit" flat>
                <v-icon>edit</v-icon>
            </v-btn>
            <v-btn @click="del" flat>
                <v-icon>delete</v-icon>
            </v-btn>
        </v-card-actions>
        </v-card>
</template>

<script>
    import { mapActions} from 'vuex'

    export default {
        props: ['message', 'editMessage', 'deleteMessage'],
        methods: {
            ...mapActions(['removeMessageAction']),
            edit() {
                this.editMessage(this.message)
            },
            del() {
                this.removeMessageAction(this.message)
            }
        }
    }
</script>

<style>
</style>
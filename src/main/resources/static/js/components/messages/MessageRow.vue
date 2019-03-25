<template>
    <v-card class="my-2">
        <v-card-text primary-title>
            <user-link
                    :user="message.author"
                    size="48"
            ></user-link>
            <div class="pt-3">
                <!--<i>({{ message.id }})</i>-->
                {{ message.text }}
            </div>
        </v-card-text>
        <media v-if="message.link" :message="message"></media>
        <v-card-actions>
            <v-btn @click="edit" flat>
                <v-icon>edit</v-icon>
            </v-btn>
            <v-btn @click="del" flat>
                <v-icon>delete</v-icon>
            </v-btn>
        </v-card-actions>
        <comment-list :comments="message.comments"
                      :messageId="message.id">
        </comment-list>
    </v-card>
</template>

<script>
    import {mapActions} from 'vuex'
    import Media from 'components/media/Media.vue'
    import CommentList from '../comment/CommentList.vue'
    import UserLink from 'components/UserLink.vue'
    export default {
        props: ['message', 'editMessage'],
        components: {UserLink, Media, CommentList},

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
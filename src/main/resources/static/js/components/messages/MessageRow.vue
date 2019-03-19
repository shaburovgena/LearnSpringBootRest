<template>
    <v-card class="my-2">
        <v-card-text primary-title>
            <div>

                <v-avatar v-if="message.author&&message.author.userpic"
                          size="40px">
                    <img
                            :src="message.author.userpic"
                            :alt="message.author.name"
                    >
                </v-avatar>
                <v-avatar v-else color="indigo"
                          size="40px">
                    <v-icon dark>account_circle</v-icon>
                </v-avatar>
                <span class="pl-2">{{authorName}}</span>
            </div>
            <div class="pt-3">
                <i>({{ message.id }})</i>
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

    export default {
        props: ['message', 'editMessage'],
        components: {Media, CommentList},
        computed: {
            authorName() {
                return this.message.author ? this.message.author.name : 'unknown'
            }
        },
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
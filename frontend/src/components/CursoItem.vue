<template>
    <li @click="tratarClick">
        {{ value }}
        <slot/>
    </li>
</template>

<script>
    export default {
        name: 'CursoItem',
        props: {
            value: String}
        },
        methods: {
            tratarClick(event) {
                this.$emit('click', event);
            }
        }
    }
</script>
<template>
  <div class="mesa">
    <AtualizaMesa msg="Bem-vindo ao Vuestaurante"/>
  </div>
</template>

<script>
// @ is an alias to /src
import AtualizaMesa from '@/components/AtualizaMesa.vue'

export default {
  name: 'mesa',
  components: {
    AtualizaMesa
  }
}
</script>

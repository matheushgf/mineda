<template>
  <div class="produto">
    <RemoveProduto msg="Bem-vindo ao Vuestaurante"/>
  </div>
</template>

<script>
// @ is an alias to /src
import RemoveProduto from '@/components/RemoveProduto.vue'

export default {
  name: 'produto',
  components: {
    RemoveProduto
  }
}
</script>

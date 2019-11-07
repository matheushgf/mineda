<template>
  <div class="produto">
    <Produto msg="Bem-vindo ao Vuestaurante"/>
  </div>
</template>

<script>
// @ is an alias to /src
import Produto from '@/components/Produto.vue'

export default {
  name: 'produto',
  components: {
    Produto
  }
}
</script>

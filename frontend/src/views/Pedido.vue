<template>
  <div class="pedido">
    <Pedido msg="Bem-vindo ao Vuestaurante"/>
  </div>
</template>

<script>
// @ is an alias to /src
import Pedido from '@/components/Pedido.vue'

export default {
  name: 'pedido',
  components: {
    Pedido
  }
}
</script>

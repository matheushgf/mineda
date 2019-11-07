<template>
  <div class="pedido">
    <FechaPedido msg="Bem-vindo ao Vuestaurante"/>
  </div>
</template>

<script>
// @ is an alias to /src
import FechaPedido from '@/components/FechaPedido.vue'

export default {
  name: 'pedido',
  components: {
    FechaPedido
  }
}
</script>

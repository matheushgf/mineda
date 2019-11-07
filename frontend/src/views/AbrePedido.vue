<template>
  <div class="pedido">
    <AbrePedido msg="Bem-vindo ao Vuestaurante"/>
  </div>
</template>

<script>
// @ is an alias to /src
import AbrePedido from '@/components/AbrePedido.vue'

export default {
  name: 'pedido',
  components: {
    AbrePedido
  }
}
</script>

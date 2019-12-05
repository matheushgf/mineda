<template>
  <div class="produto">
    <CadastraProduto msg="Bem-vindo ao Vuestaurante"/>
  </div>
</template>

<script>
// @ is an alias to /src
import CadastraProduto from '@/components/CadastraProduto.vue'
import axios from 'axios'
import { mapState } from 'vuex'

export default {
  name: 'produto',
  components: {
    CadastraProduto
  },
  computed: {
    ...mapState([
      'usuario'
    ])
  },
  methods: {
    onSubmit () {
      axios.post('produto/novoProduto',
        {
          nome: this.nome,
          descricao: this.descricao,
          preco: this.preco,
          tipo: this.tipo,
          validade: this.validade

          //usuario: this.usuario
        })
        .then(res => {
          console.log(res)
        })
        .catch(error => console.log(error))
    }
  }

}
</script>

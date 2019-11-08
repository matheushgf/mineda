<template>
  <div class="produto">
    <CadastraProduto msg="Bem-vindo ao Vuestaurante"/>
  </div>
</template>

<script>
// @ is an alias to /src
import CadastraProduto from '@/components/CadastraProduto.vue'
import axios from 'axios'

export default {
  name: 'produto',
  components: {
    CadastraProduto
  },
  methods: {
    onSubmit () {
      axios.post('autorizacao/save',
        {
          nome: this.nome
        })
        .then(res => {
          console.log(res)
        })
        .catch(error => console.log(error))
    }
  }

}
</script>

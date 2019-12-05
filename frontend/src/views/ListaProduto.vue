<template>
  <div id="app">
    <div class="row">
      <div class="col-2"></div>
      <div class="col-8">
        <table class="table table-bordered center">
          <tr>
            <th>Id</th>
            <th>Nome</th>
            <th>Descricao</th>
            <th>Preço</th>
            <th>Tipo</th>
            <th>Validade</th>
          </tr>
          <tr v-for="produto in produtos" :key="produto.id">
            <td>{{ produto.id }}</td>
            <td>{{ produto.nome }}</td>
            <td>{{ produto.descricao }}</td>
            <td>{{ produto.preco }}</td>
            <td>{{ produto.tipo }}</td>
            <td>{{ produto.validade }}</td>
          </tr>
        </table>
      </div>
    </div>
  </div>
</template>

<!--<script>-->
<!--// @ is an alias to /src-->
<!--import Mesa from '@/components/Mesa.vue'-->

<!--export default {-->
<!--  name: 'mesa',-->
<!--  components: {-->
<!--    Mesa-->
<!--  }-->
<!--}-->
<!--</script>-->
<script>
import axios from 'axios'

export default {
  name: 'app',
  data () {
    return {
      produtos: []
    }
  },
  created () {
    axios.get('/produto/getAll',
      { headers: { Accept: 'application/json' } })
      .then(res => {
        console.log(res)
        this.produtos = res.data
      }).catch(error => console.log(error))
  }
}
</script>

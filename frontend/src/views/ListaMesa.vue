<template>
  <div id="app">
    <div class="row">
      <div class="col-2"></div>
      <div class="col-8">
        <table class="table table-bordered">
          <tr>
            <th>ID</th>
            <th>Quantidade de Lugares</th>
          </tr>
          <tr v-for="mesa in mesas" :key="mesa.id">
            <td>{{ mesa.id }}</td>
            <td>{{ mesa.quantidade_lugares }}</td>
          </tr>
          <tr>
            <td colspan="2"><button @click="novaMesa">Adicionar</button></td>
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
  name: 'Mesas',
  data () {
    return {
      mesas: []
    }
  },
  created () {
    axios.get('/mesa/getAll',
      { headers: { Accept: 'application/json' } })
      .then(res => {
        this.mesas = res.data
      })
  },
  methods: {
    novaMesa () {
      this.$router.push('cadastro')
    }
  }

}
</script>

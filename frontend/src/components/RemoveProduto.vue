<template>
  <div id="app">
    <div id="nav">
      <router-link to="/produto">Voltar</router-link>
      <div>
        <h3>Lista de produtos cadastrados na sistema </h3>
        <p><strong>Clique no produto para excluí-lo </strong></p>
        <table>
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
        <!--ul>
          <li v-for="produto in produtos"  v-bind:key="type">
            {{produto.id, produto.nome, produto.descricao, produto.preco, produto.tipo, produto.validade}}
          </li>
        </ul-->
      </div>
    </div>
    <router-view/>
  </div>
</template>

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

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

#nav {
  padding: 30px;
}

#nav a {
  font-weight: bold;
  color: #2c3e50;
}

#nav a.router-link-exact-active {
  color: #42b983;
}
</style>

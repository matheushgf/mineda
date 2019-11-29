<template>
  <div id="app">
    <div id="nav">
      <router-link to="/pedido">Voltar</router-link>
      <div>
        <h3>Dados do Pedido </h3>
        <p>
        Mesa:
        <select>
          <option v-for="(mesa, indice) in mesas" @click="incluir(indice)">{{ mesa.id }}</option>
        </select>
        </p>
        <p>
        Clique sobre o produto para adiciona-lo ao pedido:
        <ul>
          <li v-for="(produto, indiceProduto) in produtos">{{ produto.nome }} <button v-on:click="inclui(indiceProduto)">Adiciona</button></li>
        </ul>
        </p>
        <p>
          <ul>
            <li v-for="(produto, indiceProduto) in produtosAdicionados">{{ produto.nome }}</li>
          </ul>
        </p>
        <!--p>
          Valor total:
          <input type="text" min="0" v-model="valorTotal">
        </p-->
      </div>
    </div>
    <router-view/>
  </div>
</template>

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

<script>
// @ is an alias to /src
import axios from 'axios'

export default {
  name: 'app',
  data () {
    return {
      produtos: [],
      produtosAdicionados: [],
      mesas: []
    }
  },
  created () {
    axios.get('/produto/getAll',
      { headers: { Accept: 'application/json' } })
      .then(res => {
        this.produtos = res.data
      }),
    axios.get('/mesa/getAll',
      { headers: { Accept: 'application/json' } })
      .then(res => {
        this.mesas = res.data
      })
  },
  methods: {
    onSubmit () {
      axios.get('produto/getAll',
      {
        if (id = this.mesaId) {
          this.isOpen = true
        }
      })
      .then(res => {
          console.log(res)
        })
      .catch(error => console.log(error))
    }
  },
  incluir(indiceProduto) {
    this.produtosAdicionados.vm.add(indiceProduto, produto.nome);
  }
}
</script>
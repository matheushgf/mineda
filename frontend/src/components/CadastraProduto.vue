<template>
  <div id="app">
    <div id="nav">
      <router-link to="/produto">voltar</router-link>
      <div>
      <form @submit.prevent="onSubmit">
        <h3>Dados do Produto </h3>
        <p>
          Nome:
          <input id="nome" type="text" v-model="nome">
        </p>
        <p>
          Descrição:
          <input type="text" v-model="descricao">
        </p>
        <p>
          Preço:
          <input type="float" v-model="preco">
        </p>
        <p>
          Tipo:
          <input type="text" v-model="tipo">
        </p>
        <p>
          Validade:
          <input type="text" v-model="validade">
        </p>
        <p>
          <button type="submit">Enviar</button>
        </p>
        <!--ul>
          <li v-for="produto in produtos"  v-bind:key="type">
            {{produto.nome, produto.descricao, produto.preco, produto.tipo, produto.validade}}
          </li>
        </ul-->
      </form>
      </div>
    </div>
    <router-view/>
  </div>
</template>

<script>
import { AxiosInstance as axios } from 'axios'

export default {
  name: 'app',
  data () {
    return {
      nome: '',
      descricao: '',
      preco: '',
      tipo: '',
      validade: ''
    }
  },
  methods: {
    onSubmit () {
      if (this.nome.trim().length === 0) {
        //alert('O nome deve ser preenchido!')
        this.erro_nome = true
      }
      if (this.descricao.trim().length === 0) {
        //alert('A descrição deve ser preenchida!')
      }
      if (this.preco.trim().length === 0) {
        //alert('O preço deve ser preenchido!')
      }
      if (this.tipo.trim().length === 0) {
        //alert('O tipo deve ser preenchido!')
      }
      if (this.validade.trim().length === 0) {
        //alert('A validade deve ser preenchida!')
      } else {
        axios.post('produto/novoProduto',
          {
            nome: this.nome,
            Descricao: this.descricao,
            Preco: this.preco,
            Tipo: this.tipo,
            Validade: this.validade
          })
          .then(res => {
            console.log(res)
          })
          .catch(error => console.log(error))
      }
    }
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

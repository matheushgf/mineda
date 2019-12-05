<template>
  <div id="app">
    <div id="nav">
      <router-link to="/mesa">voltar</router-link>
      <form @submit.prevent="onSubmit">
        <div>
          <h3>Dados da Mesa </h3>
          <p>
            Quantidade de lugares:
            <input type="number" v-model="quantidade_lugares">
          </p>
        </div>
        <div @if>

        </div>
        <input type="submit" value="Enviar">
      </form>
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
  name: 'mesa',
  data () {
    return {
      quantidade_lugares: ''
    }
  },
  methods: {
    onSubmit () {
      axios.post('mesa/novaMesa',
        {
          quantidade_lugares: this.quantidade_lugares,
          isOpen: true
        })
        .then(res => {
          console.log(res)
          this.$router.push('lista');
        })
        .catch(error => console.log(error))
    }
  }
}
</script>

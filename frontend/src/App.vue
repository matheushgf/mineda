<template>
  <div id="app">
    <div id="nav">
      <router-link to="/">Home</router-link> |
      <router-link to="/pedido">Pedido</router-link> |
      <router-link to="/produto">Produto</router-link> |
      <router-link to="/mesa">Mesa</router-link> |
       <a v-if="usuario" @click="logout">Logout</a> 
      <router-link v-if="!usuario" to="/login">Login</router-link>
    </div>
    <router-view/>
  </div>
</template>

<script>
import { mapState } from 'vuex'
import { mapMutations } from 'vuex'

export default {
  name: 'app',
  computed: {
    ...mapState([
      'usuario'
    ])
  },
  methods: {
    ...mapMutations([
      'logout'
    ])
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

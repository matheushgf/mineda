<template>
  <div id="app">
    <div id="nav">
      <router-link to="/mesa">Voltar</router-link>
      <h3>Digite o ID da mesa que deseja fechar ou abrir </h3>
      <p>
        ID:
        <input type="number" v-model="id" min="0">
      </p>
      <label for="opcoes"></label>
      <input type="radio" name="opcoes" id="abrir" value="1" v-model="picked">
      <label for="abrir">Abrir</label>
      <input type="radio" name="opcoes" id="fechar" value="0" v-model="picked">
      <label for="fechar">Fechar</label>
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

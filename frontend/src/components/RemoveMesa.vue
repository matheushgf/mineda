<template>
  <div id="app">
    <div id="nav">
      <router-link to="/mesa">Voltar</router-link>
    </div>
    <router-view/>
    <h3>Lista de mesas cadastradas na sistema </h3>
        <p><strong>Clique na mesa para excluí-la </strong></p>
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

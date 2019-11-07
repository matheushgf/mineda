<template>
  <div id="app">
    <div id="nav">
      <router-link to="/pedido">Voltar</router-link>
      <div>
        <h3>Dados do Pedido </h3>
        <p>
          ID da mesa:
          <input type="text" v-model="mesa">
        </p>
        <p>
          Quantidade de produtos:
          <input type="number" min="0" v-model="quantidade">
        </p>
        <p>
          ID do produto:
          <input type="number" min="0" v-model="produtoID">
        </p>
        <p>
          Valor total:
          <input type="text" min="0" v-model="valorTotal">
        </p>
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

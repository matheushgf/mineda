<template>
  <div class="hello">
    <h1>{{ msg }}</h1>
    <h3>Sobre nós</h3>
    <ul>
      <li>ashud adhausdgau dagsdua</li>
      <li>ashdahsd asgdausydg gasd</li>
    </ul>
    <h3>Endereços</h3>
    <ul>
      <li>1</li>
      <li>2</li>
      <li>3</li>
    </ul>
  </div>
</template>

<script>
export default {
  name: 'HelloWorld',
  props: {
    msg: String
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h3 {
  margin: 40px 0 0;
}
ul {
  list-style-type: none;
  padding: 0;
}
a {
  color: #42b983;
}
</style>

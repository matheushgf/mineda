<template>
  <div class="mesa">
    <CadastraMesa msg="Bem-vindo ao Vuestaurante"/>
  </div>
</template>

<script>
// @ is an alias to /src
import CadastraMesa from '@/components/CadastraMesa.vue'
import axios from 'axios'

export default {
  name: 'mesa',
  components: {
    CadastraMesa
  },
  methods: {
    onSubmit () {
      axios.post('mesa/novaMesa',
        {
          quantidade_lugares: this.lugares
        })
        .then(res => {
          console.log(res)
        })
        .catch(error => console.log(error))
    }
  }
}
</script>

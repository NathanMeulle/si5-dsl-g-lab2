<template>
  <div>
    <h4 class="text-left">helloworld</h4>
    <b-table striped hover :items="items" :fields="fields" :per-page="5" show-empty>></b-table>
  </div>
</template><script>
var data = require('../external/getData_getData');
  export default {
  mounted() {
    this.items =  data.getData();
  },    data() {
      return {
        items: [],
        fields: ['Equipe', 'Prenom', 'Nom', 'Nationalité', 'Score'],
      }
    }
  }
</script>
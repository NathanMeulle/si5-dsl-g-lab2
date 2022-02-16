<template>
  <div>
    <b-table striped hover :items="items"></b-table>
  </div>
</template><script>
var data = require('../external/getData_getDataTableau1');
  export default {
  mounted() {
    this.items =  data.getDataTableau1();
  },    data() {
      return {
        items: []
      }
    }
  }
</script>
<template>
  <div>
    <b-table striped hover :items="items"></b-table>
  </div>
</template><script>
var data = require('../external/getData_getData');
  export default {
  mounted() {
    this.items =  data.getData();
  },    data() {
      return {
        items: []
      }
    }
  }
</script>
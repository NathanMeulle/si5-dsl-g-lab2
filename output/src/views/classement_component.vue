<template>
  <b-container>
    <h3>classement</h3>
    <Tableau />
  </b-container>
</template><script>
import Tableau from '../components/Tableau.vue'
export default {
  name: 'Classement',
  components: {
    Tableau
  }
}
</script>
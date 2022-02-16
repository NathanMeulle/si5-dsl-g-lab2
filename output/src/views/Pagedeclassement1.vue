<template>
  <b-container>
    <h3>Page de classement 1</h3>
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
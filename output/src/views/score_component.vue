<template>
  <b-container>
    <h3>Score</h3>
    <Tableau
      :title="'Top 10'"
      :perPage="0"
      :items="items_data_Top10_Score"
      :fields="fields_Top10_Score"
      :filterTable="filterMethod_Top10_Score"
      :activateFiltre="false"
      :rowNb="10"
      :options="options_Top10_Score"
      :checkBoxStyle="checkBoxStyle_Top10_Score"
      @updateFilterSelected="updateSelected_Top10_Score"
    />

  </b-container>
</template>
<script>
import Tableau from '../components/Tableau.vue'
var data_Top10_Score = require('../external/getData_Top10_Score');

export default {
  name: 'Classement',
  components: {
    Tableau
  },
  created: function () {
    this.items_data_Top10_Score =  data_Top10_Score.Top10().slice(0, 10);

  },
   data() {
      return {
        selected_Top10_Score: [],
        checkBoxStyle_Top10_Score: "",

        options_Top10_Score: [],

        fields_Top10_Score: [
        {
          key:'Prenom',
        },
        {
          key:'Nom',
        },
        {
          key:'Nage',
        },
        {
          key:'Velo',
        },
        {
          key:'Course',
        },
        ],

      }
     },
     methods: {
       filterMethod_Top10_Score(row) {
         if ((this.selected_Top10_Score.includes("")?row==undefined:false)) {
          return false;
        } else {
          return true;
        }
       },
     updateSelected_Top10_Score(value) {
        this.selected_Top10_Score = value
      },
     }
}
</script>
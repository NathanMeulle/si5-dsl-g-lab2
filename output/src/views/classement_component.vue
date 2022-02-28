<template>
  <b-container>
    <h3>Classement</h3>
    <Tableau
      :title="'Classement Hommes'"
      :perPage="5"
      :items="items_data_ClassementHommes_Classement"
      :fields="fields_ClassementHommes_Classement"
      :filterTable="filterMethod_ClassementHommes_Classement"
      :activateFiltre="true"
      :rowNb="50"
      :options="options_ClassementHommes_Classement"
      :checkBoxStyle="checkBoxStyle_ClassementHommes_Classement"
      @updateFilterSelected="updateSelected_ClassementHommes_Classement"
    />
    <Tableau
      :title="'Classement Femmes'"
      :perPage="10"
      :items="items_data_ClassementFemmes_Classement"
      :fields="fields_ClassementFemmes_Classement"
      :filterTable="filterMethod_ClassementFemmes_Classement"
      :activateFiltre="true"
      :rowNb="40"
      :options="options_ClassementFemmes_Classement"
      :checkBoxStyle="checkBoxStyle_ClassementFemmes_Classement"
      @updateFilterSelected="updateSelected_ClassementFemmes_Classement"
    />

  </b-container>
</template>
<script>
import Tableau from '../components/Tableau.vue'
var data_ClassementHommes_Classement = require('../external/getData_ClassementHommes_Classement');
var data_ClassementFemmes_Classement = require('../external/getData_ClassementFemmes_Classement');

export default {
  name: 'Classement',
  components: {
    Tableau
  },
  created: function () {
    this.items_data_ClassementHommes_Classement =  data_ClassementHommes_Classement.ClassementHommes().slice(0, 50);
    this.items_data_ClassementFemmes_Classement =  data_ClassementFemmes_Classement.ClassementFemmes().slice(0, 40);

  },
   data() {
      return {
        selected_ClassementHommes_Classement: [],
        checkBoxStyle_ClassementHommes_Classement: "RADIO",
        selected_ClassementFemmes_Classement: [],
        checkBoxStyle_ClassementFemmes_Classement: "SWITCH",

        options_ClassementHommes_Classement: [
          { text: 'Equipe', value: 'Equipe' }, 
          { text: 'Nationalité', value: 'Nationalité' }],
        options_ClassementFemmes_Classement: [
          { text: 'Score', value: 'Score' }],

        fields_ClassementHommes_Classement: [
        {
          key:'Equipe',
        },
        {
          key:'Prenom',
          sortable: true

        },
        {
          key:'Nom',
        },
        {
          key:'Nationalité',
        },
        {
          key:'Score',
          sortable: true

        },
        ],
        fields_ClassementFemmes_Classement: [
        {
          key:'Equipe',
        },
        {
          key:'Prenom',
        },
        {
          key:'Nom',
        },
        {
          key:'Nationalité',
        },
        {
          key:'Score',
        },
        ],

      }
     },
     methods: {
       filterMethod_ClassementHommes_Classement(row) {
         if ((this.selected_ClassementHommes_Classement.includes("Equipe")?row.Equipe==undefined:false) ||(this.selected_ClassementHommes_Classement.includes("Nationalité")?row.Nationalité==undefined:false) || false) {
          return false;
        } else {
          return true;
        }
       },       filterMethod_ClassementFemmes_Classement(row) {
         if ((this.selected_ClassementFemmes_Classement.includes("Score")?row.Score==undefined:false) || false) {
          return false;
        } else {
          return true;
        }
       },
     updateSelected_ClassementHommes_Classement(value) {
        this.selected_ClassementHommes_Classement = value
      },     updateSelected_ClassementFemmes_Classement(value) {
        this.selected_ClassementFemmes_Classement = value
      },
     }
}
</script>
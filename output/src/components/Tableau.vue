<template>
  <div>
    <h4 class="text-left">helloworld</h4>
    <Filtre v-if="activateFiltre" 
      :checkBoxStyle="'SWITCH'"      :options="options"
      @updateFilterSelected="updateSelected"
    />
    <b-table striped hover id="classementTable" 
      :items="items" 
      :fields="fields" 
      :per-page="perPage"  
      :current-page="currentPage" 
      :filter="filter" 
      :filter-function="filterTable"
      show-empty
    >
    </b-table>  </div>
</template>
<script>
import Filtre  from "./Filtre"
var data_helloworld = require('../external/getData_helloworld');
  export default {
  components: {
    Filtre,
  },  mounted() {
    this.items =  data_helloworld.helloworld().slice(0, 50);
  },
    data() {
      return {
        perPage: "50",
        currentPage: 1,
        items: [],
        fields: [
        {
          key:'Equipe'
        },
        {
          key:'Prenom'
        },
        {
          key:'Nom'
        },
        {
          key:'Nationalité'
        },
        {
          key:'Score'
        },
        ],
        filter: "_",
        activateFiltre:true,
        selected: [],
        options: [
          { text: 'Equipe', value: 'Equipe' }, 
          { text: 'Nationalité', value: 'Nationalité' }],
      }
     },
     computed: {
       rows() {
           return 50
       }
    },
     methods: {
      filterTable(row) {
        if (((this.selected.includes("Equipe")?row.Equipe==undefined:false) ||(this.selected.includes("Nationalité")?row.Nationalité==undefined:false) || false)) {
          return false;
        } else {
          return true;
        }
      },
      updateSelected(value) {
        this.selected = value
      }
    },  }
</script>
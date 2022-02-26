<template>
  <div>
    <h4 class="text-left">{{title}}</h4>
    <Filtre v-if="activateFiltre" 
      :checkBoxStyle="checkBoxStyle"      
      :options="options"
      @updateFilterSelected="updateSelected"
    />
    <b-table striped hover id="classementTable" 
      :items="items" 
      :fields="fields" 
      :per-page="perPage"  
      :current-page="currentPage" 
      :filter="filter" 
      :filter-function="filterTable"
    >
    </b-table>
    <b-pagination v-if="perPage>0"
      v-model="currentPage"
      :total-rows="rowNb"
      :per-page="perPage"
      aria-controls="classementTable"
    ></b-pagination>
  </div>
</template>
<script>
import Filtre  from "./Filtre"
  export default {
  components: {
    Filtre,
  },
  props: {
    perPage: Number,
    items: Array,
    fields: Array,
    title: String,
    filterTable: { type: Function },
    activateFiltre: Boolean,
    rowNb: Number,
    options: Array,
    selected: Array,
    checkBoxStyle: String
    },
    data() {
      return {
        currentPage: 1,
        filter: "_",
      }
     },
     methods: {
      updateSelected(value) {
        this.$emit("updateFilterSelected", value)
      }
    },  
  }
</script>
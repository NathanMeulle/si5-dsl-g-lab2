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
      @row-clicked="onRowClicked"
    >
     <template v-if="details != undefined && details.length>0" #row-details="row">
        <b-card>
          <b-row v-for="d in details" :key="d" class="mb-2">
            <b-col sm="3" class="text-sm-right"><b>{{d}}</b></b-col>
            <b-col>
            <template v-for="(value, name) in row.item">
              <div v-if="d==name" :key="name">{{ value }} </div>
            </template>
            </b-col>
          </b-row>
        </b-card>
      </template>
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
    checkBoxStyle: String,
    details: Array,
    detailEvent: String
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
      },
      onRowClicked(item) {
        let value = !item._showDetails
        this.$set(item, '_showDetails', value)
      },
      onRowHover(item) {
        this.$set(item, '_showDetails', true)
      },
      onRowUnHover(item) {
        this.$set(item, '_showDetails', false)
      },
    },  
  }
</script>
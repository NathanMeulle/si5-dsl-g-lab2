<template>
    <b-form-group label="Filtre de données vides : " v-slot="{ ariaDescribedby }" class="text-left">
        
        <b-form-radio-group v-if="isRadio"
          id="checkbox-group-1"
          v-model="selected"
          :options="options"
          :aria-describedby="ariaDescribedby"
          name="flavour-1"
          @change="updateValue"
          switches 
        ></b-form-radio-group>
    <b-form-checkbox-group v-else-if="isSwitch"
        id="checkbox-group-2"
        v-model="selected"
        :options="options"
        :aria-describedby="ariaDescribedby"
        name="flavour-1"
        @change="updateValue"
        switches
    ></b-form-checkbox-group>
    <b-form-checkbox-group v-else
          id="checkbox-group-3"
          v-model="selected"
          :options="options"
          :aria-describedby="ariaDescribedby"
          name="flavour-1"
          @change="updateValue"
        >
    </b-form-checkbox-group>
    </b-form-group>
</template>

<script>
export default {
  name: 'Filtre',
  props: ['options', 'checkBoxStyle'],
  computed: {
    isRadio: function () {
        this.initSelected()
        return this.checkBoxStyle=='RADIO'
    },
    isSwitch: function () {
        return this.checkBoxStyle=='SWITCH'
    }
  },

  data() {
      return {
        selected: [],
     }
  },
  methods: {
    updateValue() {
        this.$emit("updateFilterSelected", this.selected)
    },
    initSelected() {
        this.selected = []
    }
  },
mounted() {
    this.selected = []
  },
}
</script>

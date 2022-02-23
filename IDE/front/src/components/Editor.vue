<template>
  <div class="editor">
    <MonacoEditor id="monaco" v-model="code" :options="options"/>
    <v-btn @click="render" id="render" elevation="2">
      Render
    </v-btn>
  </div>
</template>

<script>
import MonacoEditor from 'vue-monaco'
import axios from 'axios'

export default {
  props:['init_code'],
  watch: {
    init_code(n){
      this.code = n;
    }
  },
  components: {
    MonacoEditor
  },

  data() {
    return {
      code: '',
      options:{
        theme: 'vs',
        automaticLayout: true,
        minimap: {
          enabled: false
        }
      }
    }
  },

  methods: {
    render(){
      axios.post(`http://${process.env.VUE_APP_BACK_BASE_API}/render`, {code:this.code});
    }
  }
}
</script>

<style>
#monaco {
  width: 100%;
  height: 100%;
}
.editor {
  display: flex;
  flex-direction: column;
  align-items: center;
  width: 100%;
  height: 100%;
}
#render {
  margin: 5px;
  width: 50px;
}
</style>
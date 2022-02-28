<template>
  <div class="editor">
    <MonacoEditor id="monaco" v-model="editorCode" :options="options" ref="editor"/>
    <v-btn @click="render" id="render" elevation="2" :loading="loading">
      Render
    </v-btn>
  </div>
</template>

<script>
import MonacoEditor from 'vue-monaco'

export default {

  props:['code', 'syntax_error'],
  watch: {
    code(n){
      this.editorCode = n;
    },
    syntax_error(n){
      const monaco = this.$refs.editor.monaco
      let model = monaco.editor.getModels()[0]
      monaco.editor.setModelMarkers(model,"owner",n)
      this.loading = false
    }
  },
  components: {
    MonacoEditor
  },

  data() {
    return {
      editorCode: '',
      options:{
        theme: 'vs',
        automaticLayout: true,
        minimap: {
          enabled: false
        }
      },
      loading: true
    }
  },

  methods: {
    render(){
      this.loading = true
      this.$emit('render', this.editorCode)
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
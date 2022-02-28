<template>
  <div class="editor">
    <MonacoEditor id="monaco" v-model="code" :options="options" ref="editor"/>
    <v-btn @click="render" id="render" elevation="2" :loading="loading">
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
      },
      loading: false
    }
  },

  methods: {
    render(){
      this.loading = true
      axios.post(`http://${process.env.VUE_APP_BACK_BASE_API}/render`, {code:this.code}).then((response) => {
        console.log(response.data)
        const monaco = this.$refs.editor.monaco

        console.log(response.data.output)
        if(response.data.errors === undefined) return

        let monacoErrors = [];
        for (let e of response.data.errors) {
          let infos = e.information.replace('[','').replace(']','').replaceAll('\'', '').split(',')
          console.log(infos)
          monacoErrors.push({
            startLineNumber: parseInt(infos[3].split(':')[0]),
            startColumn: parseInt(infos[3].split(':')[1]) + 1,
            endLineNumber: parseInt(infos[3].split(':')[0]),
            endColumn: parseInt(infos[3].split(':')[1]) + infos[1].split('=')[1].length + 1,
            message: e.message,
            severity: monaco.MarkerSeverity.Error
          });
        }
        console.log(monacoErrors)
        let model = monaco.editor.getModels()[0]
        monaco.editor.setModelMarkers(model,"owner",monacoErrors)
        this.loading = false
      });
      
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
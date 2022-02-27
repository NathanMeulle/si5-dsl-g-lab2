<template>
  <div id="grid-container">
    <Editor class="grid-item" :init_code="init_code"/>
    <Preview class="grid-item"/>
    <div class="grid-item"> Code </div>
    <div class="grid-item"> Other </div>
  </div>
</template>

<script>
import Editor from './components/Editor.vue'
import Preview from './components/Preview.vue'
import axios from 'axios'

export default {
  data(){
    return {
      session_host: null,
      init_code: ''
    }
  },
  components: {
    Editor,
    Preview
  },
  created(){
    axios.defaults.withCredentials = true;
    axios.post(`http://${process.env.VUE_APP_BACK_BASE_API}/login`, {})
    .then((response) => {

      if(response.data.new_session){
        setTimeout(() => {
          this.session_host = `http://${process.env.VUE_APP_SESSION_IP}:${response.data.session_port}`
          this.init_code = response.data.code
        }, 7000)
      }
      else{
        this.session_host = `http://${process.env.VUE_APP_SESSION_IP}:${response.data.session_port}`
        this.init_code = response.data.code
      }
      
    });
  }
}
</script>
<style>
html, body {
  width: 100%;
  height: 100%;
}
#grid-container {
  width: 100%;
  height: 100%;
  display: grid;
  grid-template-columns: 50% 50%;
  grid-template-rows: 50% 50%;
  
}

.grid-item {
  border: 1px solid rgba(0, 0, 0, 0.8);
  width: 100%;
  height: 100%;
}
</style>
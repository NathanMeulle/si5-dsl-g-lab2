<template>

  <div id="grid-container">
    <Editor class="grid-item" :code="code" :syntax_error="syntax_error" @render="render($event)"/>
    <Preview class="grid-item"/>
    <Events class="grid-item" :state="state"/>
    <div class="grid-item"> Other </div>
  </div>
</template>

<script>
import Editor from './components/Editor.vue'
import Preview from './components/Preview.vue'
import Events from './components/Events.vue'
import axios from 'axios'

export default {
  data(){
    return {
      session_host: null,
      code: '',
      syntax_error: [],
      state: {
        uuid: '                                    ',
        state: 'connecting',
        maxAge: null,
        events: []
      }
    }
  },
  components: {
    Editor,
    Preview,
    Events
  },
  created(){
    axios.defaults.withCredentials = true;
    axios.post(`http://${process.env.VUE_APP_BACK_BASE_API}/login`, {})
    .then((response) => {

      if(response.data.new_session){
        setTimeout(() => {
          this.session_host = `http://${process.env.VUE_APP_SESSION_IP}:${response.data.session_port}`
          this.state = {
            uuid: response.data.uuid,
            state: 'connected',
            maxAge: response.data.session_time,
            events: [`[${new Date().toLocaleTimeString()}] Connecting to the session`]
          }
          this.render(response.data.code)
        }, 7000)
      }
      else{
        this.session_host = `http://${process.env.VUE_APP_SESSION_IP}:${response.data.session_port}`
        this.state = {
          uuid: response.data.uuid,
          state: 'connected',
          maxAge: response.data.session_time,
          events: [`[${new Date().toLocaleTimeString()}] Reconnecting to the session`]
        }
        this.render(response.data.code)
      }
    });
  },
  methods: {
    render(e){
      console.log(e)
      axios.post(`http://${process.env.VUE_APP_BACK_BASE_API}/render`, {code:e}).then((response) => {

        let monacoErrors = [];
        for (let e of response.data.errors) {
          let infos = e.information.replace('[','').replace(']','').replaceAll('\'', '').split(',')
          monacoErrors.push({
            startLineNumber: parseInt(infos[3].split(':')[0]),
            startColumn: parseInt(infos[3].split(':')[1]) + 1,
            endLineNumber: parseInt(infos[3].split(':')[0]),
            endColumn: parseInt(infos[3].split(':')[1]) + infos[1].split('=')[1].length + 1,
            message: e.message,
            severity: 7
          });
          this.state.events.push(`[${new Date().toLocaleTimeString()}] Syntax error: ${e.message}`)
        }

        this.code = response.data.code
        this.syntax_error = monacoErrors

        let state = {
          uuid: this.state.uuid,
          state: this.state.state,
          maxAge: this.state.maxAge,
          events: this.state.events
        }
        if(this.syntax_error.length > 0) state.state = 'syntax error'
        else state.state = 'connected'
        this.state = state
        
      });
    }
  }
}
</script>
<style>
html, body {
  width: 100%;
  height: 100%;
}
#editor {
  height: 50%;
  width: 50%;
}
</style>
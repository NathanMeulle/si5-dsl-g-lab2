<template>
  <div class="editor">
    <MonacoEditor id="monaco"  v-model="code"/>
    <v-btn @click="render" id="render" elevation="2">
      Render
    </v-btn>
  </div>
</template>

<script>
import MonacoEditor from 'vue-monaco'

export default {
  components: {
    MonacoEditor
  },

  data() {
    return {
      code: ''
    }
  },

  methods: {
    render(){
      console.log(this.code)
    }
  }
}
</script>

<style>
#monaco {
  width: 100%;
  height: 100%;
  resize: vertical;
  border: solid 1px black;
}
.editor {
  width: 100%;
  height: 100%;
  display: flex;
  flex-direction: column;
  align-items: center;
}
#render {
  margin: 5px;
  width: 50px;
}
</style>
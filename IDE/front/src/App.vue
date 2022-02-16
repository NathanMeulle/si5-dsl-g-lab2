<template>
  <div id="editor">
    <Editor/>
  </div>
</template>

<script>
import Editor from './components/Editor.vue'

export default {
  components: {
    Editor
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
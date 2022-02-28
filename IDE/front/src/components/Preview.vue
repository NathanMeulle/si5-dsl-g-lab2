<template>
  <div id="preview">
      <div class="full_screen" v-if="this.$parent.session_host === null">
          <div>Loading</div>
      </div>
      <div class="full_screen" v-else>
        <iframe id="site"
            :src="this.$parent.session_host">
        </iframe>
      </div>
  </div>
</template>

<script>

export default {
}
</script>

<style>
#preview {
    width: 100%;
    height: 100%;
}
#site {
    width: 100%;
    height: 100%;
}
.full_screen {
    width: 100%;
    height: 100%;
}
</style>
<template>
  <img class="mx-2" :src="imgSrc" width="30" height="30" alt="">
</template>

<script>
export default {
  name: 'Logo',
  props: ['imgSrc']
}
</script>

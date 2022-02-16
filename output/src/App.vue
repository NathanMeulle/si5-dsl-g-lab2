<template>
	<div id="app">
   <Navbar :logoUrl="'https://drive.google.com/uc?export=view&id=1IXY8IZai07UAj0yamXUTTy-RA8baWN2I'" :NavbarTitle="'Triathlon'" :MenuItems="['Page de classement 1', 'Page de classement 2']" :colorNavBar="'#aa3333'" />
    <div class="container">
      <router-view />
    </div>
  </div>
</template>
<script>
import Navbar from './components/Navbar.vue'

export default {
  name: 'App',
  components: {
    Navbar,
  },
}
</script>

<style>
#app {
  font-family: Times, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}
html {
  min-height: 100%;
  position: relative;
}
body {
  height: 100%;
}
#nav a {
  font-weight: bold;
  color: #000;
}

#nav a.router-link-exact-active {
  color: #fff;
}
</style>
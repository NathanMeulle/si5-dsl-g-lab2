<template>
	<div id="app">
    <Navbar :logoUrl="'https://drive.google.com/uc?export=view&id=1IXY8IZai07UAj0yamXUTTy-RA8baWN2I'"
      :NavbarTitle="'Triathlon'"
      :MenuItems="['Page de classement 1', 'Page de classement 2']"
      :colorNavBar="'#aa3333'"
      @swapComponent="loadComponent"
    />
    <div class="container">
      <div :is="currentComponent"></div>
    </div>
  </div>
</template>
<script>
import Navbar from './components/Navbar.vue'
import Pagedeclassement1 from './views/Pagedeclassement1.vue'
import Pagedeclassement2 from './views/Pagedeclassement2.vue'
export default {
  name: 'App',
  components: {
    Navbar, Pagedeclassement1, Pagedeclassement2
  },
  data() {
    return {
      currentComponent: null,
    }
  },
  methods: {
    loadComponent: function(component)
    {
        this.currentComponent = component
    }
  }
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
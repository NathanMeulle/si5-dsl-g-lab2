<template>
	<div id="app">
    <Navbar      :NavbarTitle="'triathlon'"
      :MenuItems="['classement']"
      :colorNavBar="'null'"
      @swapComponent="loadComponent"
    />
    <div class="container">
      <div :is="currentComponent"></div>
    </div>
  </div>
</template>
<script>
import Navbar from './components/Navbar.vue'
import classement_component from './views/classement_component.vue'
export default {
  name: 'App',
  components: {
    Navbar, classement_component
  },
  data() {
    return {
      currentComponent: classement_component,
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
  font-family: null, null;
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
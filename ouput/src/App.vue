<template>
	<div id="app">
      <b-navbar toggleable="lg" class="navbar navbar-dark bg-primary justify-content-left">
        <img class="mx-2" :src="'https://drive.google.com/uc?export=view&id=1IXY8IZai07UAj0yamXUTTy-RA8baWN2I'" width="30" height="30" alt=""/>
        <b-navbar-brand href="#">
          Triathlon
        </b-navbar-brand>
        <b-navbar-toggle target="nav-collapse"></b-navbar-toggle>

        <b-collapse id="nav-collapse" is-nav class="d-lg-block">
          <b-navbar-nav>
            <b-nav-item v-for="item in ['Page de classement 1', 'Page de classement 2']" :key="item.message">
                <a class="nav-link" href="#">{{item}}</a>
            </b-nav-item>
          </b-navbar-nav>
        </b-collapse>
    </b-navbar>
	</div>
</template>

<script>
export default {
	name: 'App'
}
</script>
}

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
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
</style>
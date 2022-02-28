<template>
  <div>
      <div id="events">
        <div id="console">
            <div class="line" v-for="(e,i) in state.events" :key=i>
                {{e}}
            </div>
        </div>
        <div id="footer">
            <div class="footer-element">
                {{state.uuid}}
            </div>
            <div class="footer-element">
                {{endingUntil}}
            </div>
            <div class="footer-element" :style="{'background-color':stateColor}">
                {{state.state}}
            </div>
        </div>
      </div>
  </div>
</template>

<script>
export default {
  props:['state'],
  watch: {
      state(s){
            clearInterval(this.timeoutId)
            this.endingUntil = s.maxAge / 1000
            this.timeoutId = setInterval(()=>{
                if(--this.endingUntil == 0) {
                    s.state = 'session expired'
                    clearInterval(this.timeoutId)
                }
            },1000)
            setTimeout(()=>this.$el.querySelector("#console").scrollTop = this.$el.querySelector("#console").scrollHeight, 50)
            switch (s.state) {
                case 'connected':
                    this.stateColor = '#008000'
                    break;
            
                case 'syntax error':
                    this.stateColor = '#FF8C00'
                    break;

                default:
                    this.stateColor = '#FF0000'
            }
      }
  },
  data() {
    return {
        endingUntil: 0,
        timeoutId: 0,
        stateColor: '#FFFFFF'
    }
  }
}
</script>

<style>
#events {
  display: flex;
  flex-direction: column;
  height: 100%;
  width: 100%;
}
#console {
    flex: 0 1 auto;
    overflow-y: scroll;
    height: 100%;
    width: 100%;
}
#footer {
    display: flex;
    flex-direction: row;
}
.footer-element{
    padding: 3px;
    border: 1px solid rgba(0, 0, 0, 0.8);
}
</style>
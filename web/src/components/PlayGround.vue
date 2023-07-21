<template>
  <div class="playground">
    <GameMap />
  </div>
</template>

<script>
import GameMap from './GameMap'

export default {
  name: "PlayGround",
  components: {
    GameMap,
  }
}
</script>

<style scoped>
div.playground {
  width: 60vw;
  height: 70vh;
  margin: 60px auto;
}
</style>
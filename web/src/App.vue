<template>
<NavBar/>
  <router-view></router-view>
</template>

<script>

import NavBar from './components/NavBar.vue'
import "bootstrap/dist/css/bootstrap.min.css"
import "bootstrap/dist/js/bootstrap"
// import $ from 'jquery'

export default {
  components: {
    NavBar
  },
  setup() {
    // $.ajax({
    //   url:"http://localhost:3000/user/account/token/",
    //   type:"post",
    //   data:{
    //     username:'haye',
    //     password:'xiahaoyang1113',
    //   },
    //   success(resp) {
    //     console.log(resp);
    //   },
    //   error(resp) {
    //     console.log(resp);
    //   }
    // });
    //
    // $.ajax({
    //   url:"http://localhost:3000/user/account/info/",
    //   type:"get",
    //   headers: {
    //     Authorization: "Bearer " + "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiI5MWNkY2M4ZWY5MTk0MWU4YWM2YzEwOTYxY2E3NTIyMCIsInN1YiI6IjEiLCJpc3MiOiJzZyIsImlhdCI6MTY4NzYyMDYzNywiZXhwIjoxNjg4ODMwMjM3fQ.CLU5s453-tBk8206H3NumnoQgHX7MH8bq3mW4C7CBdQ"
    //   },
    //   success(resp) {
    //     console.log(resp);
    //   },
    //   error(resp) {
    //     console.log(resp)
    //   }
    // })
    //
    // $.ajax({
    //   url: "http://localhost:3000/user/account/register/",
    //   type: "post",
    //   data: {
    //     username: "hay",
    //     password: "123",
    //     confirmedPassword: "123",
    //   },
    //   success(resp) {
    //     console.log(resp);
    //   },
    //   error(resp) {
    //     console.log(resp);
    //   }
    // })

  }
}
</script>

<style>
body {
  background-image: url("assets/images/background.jpg");
  background-size: cover;
}
</style>

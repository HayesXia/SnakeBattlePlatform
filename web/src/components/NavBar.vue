<template>
  <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container-fluid">
      <router-link class="navbar-brand" :to="{name:'pk_index'}">ProjectPractice</router-link>
      <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavDropdown"
              aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarNavDropdown">
        <ul class="navbar-nav">
          <li class="nav-item">
            <router-link :class="route_name === 'pk_index' ? 'nav-link active' : 'nav-link'" :to="{name:'pk_index'}">
              对战
            </router-link>
          </li>
          <li class="nav-item">
            <router-link :class="route_name === 'record_index' ?'nav-link active' : 'nav-link'"
                         :to="{name:'record_index'}">对局列表
            </router-link>
          </li>
          <li class="nav-item">
            <router-link :class="route_name === 'ranklist_index' ?'nav-link active' : 'nav-link'"
                         :to="{name:'ranklist_index'}">排行榜
            </router-link>
          </li>
          <li class="nav-item dropdown " v-if="$store.state.user.is_login">
            <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
              {{ $store.state.user.username }}
            </a>
            <ul class="dropdown-menu">
              <li>
                <router-link class="dropdown-item" :to="{name:'user_bot_index'}">我的Bot</router-link>
              </li>
              <li><a class="dropdown-item" href="#" @click="logout">退出</a></li>
            </ul>
          </li>
          <ul class="navbar-nav" v-else>
            <li class="nav-item ">
              <router-link class="nav-link" :to="{name: 'user_account_login'}" role="button">
                登录
              </router-link>

            </li>
            <li class="nav-item">
              <router-link class="nav-link " :to="{name: 'user_account_register'}" role="button">
                注册
              </router-link>

            </li>
          </ul>
        </ul>
      </div>
    </div>
  </nav>
</template>

<script>
import {useRoute} from 'vue-router'
import {computed} from "vue"
import {useStore} from 'vuex'

export default {
  name: "NavBar",
  setup() {
    const store = useStore();
    const route = useRoute();
    let route_name = computed(() => route.name)
    const logout = () => {
      store.dispatch("logout");
    }
    return {
      route_name,
      logout
    }
  }
}
</script>

<style scoped>

</style>
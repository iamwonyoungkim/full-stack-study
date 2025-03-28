<template>
  <div>
    <h2 class="m-4">이날치 멤버</h2>
    <div class="container">
      <div class="row">
        <div
          v-for="m in members"
          :key="m.id"
          class="col-6 col-xs-6 col-sm-4 col-md-3 col-lg-2"
        >
          <!-- 왜 to가 아닌 :to로 했을까?
         string이 아닌 javascript 로직(표현식)이 들어갔기 때문이다 -->
          <router-link :to="'/members/' + m.id">
            <img
              class="img-thumbnail"
              style="width: 90px; height: 110px"
              :src="m.photo"
              :title="m.name"
            /><br />
            <h6 class="display-7">{{ m.name }}</h6>
          </router-link>
        </div>
      </div>
    </div>
  </div>
</template>
<script>
import members from '@/members.json';
export default {
  name: 'Members',
  setup() {
    return { members };
  },
};
</script>

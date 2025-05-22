<template>
  <InfoCard>
    <template #header="{ title }">
      <h2>{{ title }}</h2>
    </template>
    <template #items="{ items }">
      <ul v-for="item in items">
        <li>{{ item }}</li>
      </ul>
    </template>
    <template #footer="{ date }">
      <h2>{{ date }}</h2>
    </template>
  </InfoCard>

  <!-- 사용자 정의 v-model -->
  <!-- 내가 만든 태그에는 아무것도 안 하고 v-model 사용 불가.. -->
  <!-- <InfoCard v-model=""></InfoCard> -->
  <CustomInput v-model:title="message" />
  {{ message }} <br />

  <CustomInput2 v-model:checked="isChecked" />
  {{ isChecked }} <br />

  <!-- 동적 컴포넌트 -->
  <button @click="currentTab = 'TabA'">TabA</button>
  <button @click="currentTab = 'TabB'">TabB</button>
  <keep-alive>
    <component :is="currentTab"></component>
  </keep-alive>

  <!-- provide and inject -->
</template>

<script>
import InfoCard from './components/InfoCard.vue';
import CustomInput from './components/CustomInput.vue';
import CustomInput2 from './components/CustomInput2.vue';
import TabA from './components/TabA.vue';
import TabB from './components/TabB.vue';

export default {
  name: 'App',
  components: { InfoCard, CustomInput, CustomInput2, TabA, TabB },
  data() {
    return {
      message: '봄맞이 특별 이벤트',
      isChecked: false,
      currentTab: 'TabA',
    };
  },
};
</script>

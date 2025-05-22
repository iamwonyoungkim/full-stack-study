<template>
  <div class="not-found">
    <h1>404</h1>
    <h2>페이지를 찾을 수 없습니다</h2>
    <p>요청하신 페이지가 존재하지 않거나 이동되었을 수 있습니다.</p>
    <router-link to="/" class="home-link"> 홈으로 돌아가기 </router-link>
  </div>
</template>

<style scoped>
.not-found {
  text-align: center;
  padding: 50px 20px;
}

h1 {
  font-size: 72px;
  color: #e74c3c;
  margin-bottom: 0;
}

h2 {
  margin-top: 10px;
  color: #2c3e50;
}

.home-link {
  display: inline-block;
  margin-top: 20px;
  padding: 10px 20px;
  background-color: #3498db;
  color: white;
  text-decoration: none;
  border-radius: 5px;
}

.home-link:hover {
  background-color: #2980b9;
}
</style>

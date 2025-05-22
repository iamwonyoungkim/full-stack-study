<!-- Header.vue -->
<template>
  <div class="header">
    <h1>로고</h1>
    <nav class="nav-center">
      <ul class="menu-list">
        <li><a href="#">메뉴1</a></li>
        <li><a href="#">메뉴2</a></li>
        <li><a href="#">메뉴3</a></li>
      </ul>
    </nav>
  </div>
</template>

<script>
export default {
  name: 'Header',
};
</script>

<style scoped>
.header {
  display: flex;
  justify-content: space-around;
  align-items: center;
  padding: 1rem;
  background-color: #f8f9fa;
}

.nav-center {
  flex: 1;
  display: flex;
  justify-content: center;
}

.menu-list {
  display: flex;
  list-style: none;
  margin: 0;
  padding: 0;
  gap: 2rem;
}

.menu-list li a {
  text-decoration: none;
  color: #333;
  font-weight: bold;
  padding: 0.5rem 1rem;
  border-radius: 4px;
  transition: background-color 0.3s;
}

.menu-list li a:hover {
  background-color: #e9ecef;
}
</style>

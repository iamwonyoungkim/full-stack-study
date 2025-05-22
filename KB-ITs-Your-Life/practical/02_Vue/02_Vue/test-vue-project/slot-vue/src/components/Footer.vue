<!-- Footer.vue -->
<template>
  <footer>
    <div class="footer-content">
      <div class="footer-section">
        <h4>회사 정보</h4>
        <p>{{ companyInfo }}</p>
      </div>
      <div class="footer-section">
        <h4>연락처</h4>
        <p>{{ contactInfo }}</p>
      </div>
      <div class="footer-section">
        <h4>소셜 미디어</h4>
        <ul class="social-links">
          <li v-for="link in socialLinks" :key="link.id">
            <a :href="link.url" target="_blank">{{ link.name }}</a>
          </li>
        </ul>
      </div>
    </div>
    <div class="footer-bottom">
      <p>{{ copyright }}</p>
    </div>
  </footer>
</template>

<script>
export default {
  name: 'Footer',
  data() {
    return {
      companyInfo: '회사명: Vue Company',
      contactInfo: 'email@example.com | Tel: 02-1234-5678',
      socialLinks: [
        { id: 1, name: 'Facebook', url: 'https://facebook.com' },
        { id: 2, name: 'Twitter', url: 'https://twitter.com' },
        { id: 3, name: 'Instagram', url: 'https://instagram.com' },
      ],
      copyright: '© 2025 Vue Company. All rights reserved.',
    };
  },
};
</script>

<style scoped>
footer {
  background-color: #333;
  color: white;
  padding: 2rem;
}

.footer-content {
  display: grid;
  grid-template-columns: repeat(3, 1fr);
  gap: 2rem;
}

.social-links {
  list-style: none;
  padding: 0;
}

.social-links li {
  margin-bottom: 0.5rem;
}

.social-links a {
  color: white;
  text-decoration: none;
}

.social-links a:hover {
  text-decoration: underline;
}

.footer-bottom {
  margin-top: 2rem;
  text-align: center;
  border-top: 1px solid #555;
  padding-top: 1rem;
}
</style>

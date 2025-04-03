<script setup>
import axios from 'axios';

// 테스트 실행을 위한 메인 함수
const runTests = async () => {
  try {
    // GET 테스트 - 전체 목록
    console.log('\n=== GET 테스트 (전체 목록) ===');
    const getResponse = await axios.get('/api/products');
    console.log('상품 목록:', getResponse.data);

    // GET 테스트 - 단일 상품 조회
    console.log('\n=== GET 테스트 (단일 상품) ===');
    const getSingleResponse = await axios.get('/api/products/1');
    console.log('단일 상품 정보:', getSingleResponse.data);

    // GET 테스트 - 특정 카테고리 조회
    console.log('\n=== GET 테스트 (특정 카테고리 조회:전자기기) ===');
    let productList;
    let getCategoryResponse = await axios.get('/api/products');
    productList = getCategoryResponse.data;
    for (let i = 0; i < productList.length; i++) {
      getCategoryResponse = await axios.get(
        '/api/products/' + productList[i].id
      );
      if (getCategoryResponse.data.category === '전자기기') {
        console.log('전자기기 상품: ', getCategoryResponse.data);
      }
    }

    // GET 테스트 - 카테고리 순으로 조회
    console.log('\n=== GET 테스트 (카테고리순) ===');
    const getsortedByCategoryResponse = await axios.get(
      '/api/products?_sort=category'
    );
    console.log('카테고리순 상품:', getsortedByCategoryResponse.data);

    // GET 테스트 - 페이지네이션 (가격 역정렬)
    console.log('\n=== GET 테스트 (페이지네이션) ===');
    const getPageResponse = await axios.get(
      '/api/products?_sort=price&_page=1&_per_page=3'
    );
    console.log('가격 높은순 1페이지 3개 목록:', getPageResponse.data);

    // POST 테스트
    console.log('\n=== POST 테스트 ===');
    const newProduct = {
      name: '블루투스 스피커',
      category: '전자기기',
      price: 150000,
      description: '고음질 휴대용 스피커',
    };
    const postResponse = await axios.post('/api/products', newProduct);
    console.log('추가된 상품:', postResponse.data);

    // PUT 테스트
    console.log('\n=== PUT 테스트 ===');
    const updateProduct = {
      name: '프리미엄 노트북',
      category: '전자기기',
      price: 1500000,
      description: '최신 프리미엄 노트북',
    };

    const putResponse = await axios.put('/api/products/0ba0', updateProduct);
    console.log('수정된 상품:', putResponse.data);

    // DELETE 테스트
    console.log('\n=== DELETE 테스트 ===');
    await axios.delete('/api/products/43a7');
    const afterDeleteResponse = await axios.get('/api/products');
    console.log('삭제 후 상품 목록:', afterDeleteResponse.data);
  } catch (error) {
    console.error('에러 발생:', error.message);
    if (error.response) {
      console.error('에러 상세:', error.response.data);
    }
  }
};

// 테스트 실행
runTests();
</script>

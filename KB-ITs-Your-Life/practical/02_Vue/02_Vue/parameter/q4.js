function showProductDetails({ name, price, stock }) {
  console.log(`상품: ${name}, 가격: ${price}원, 재고: ${stock}개`);
}
showProductDetails({ name: '노트북', price: 1200000, stock: 50 });

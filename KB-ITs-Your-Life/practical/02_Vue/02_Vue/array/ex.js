const products = [
  { id: 1, name: '노트북', price: 1200000, category: '전자기기' },
  { id: 2, name: '스마트폰', price: 800000, category: '전자기기' },
  { id: 3, name: '커피', price: 5000, category: '음료' },
  { id: 4, name: '키보드', price: 150000, category: '전자기기' },
  { id: 5, name: '마우스', price: 50000, category: '전자기기' },
  { id: 6, name: '콜라', price: 2500, category: '음료' },
];

// 문제 1: products 배열에서 '키보드' 상품의 인덱스를 찾으시오.
// [출력형태]
// 키보드 인덱스: 3
// findIndex 사용
let keyboard = products.findIndex((product) => product.name === '키보드');
console.log(`키보드 인덱스: ${keyboard}`);

// 문제 2: price가 100000원 이상인 첫 번째 상품을 찾으시오.
// [출력형태]
// 비싼 상품: { id: 1, name: '노트북', price: 1200000, category: '전자기기' }
// find 사용
let expensive = products.find((product) => product.price >= 100000);
console.log('비싼 상품:', expensive);

// 문제 3: category가 '전자기기'인 상품들만 모아 새로운 배열을 만드시오.
// [출력형태]
/*
  전자기기: [
    { id: 1, name: '노트북', price: 1200000, category: '전자기기' },
    { id: 2, name: '스마트폰', price: 800000, category: '전자기기' },
    { id: 4, name: '키보드', price: 150000, category: '전자기기' },
    { id: 5, name: '마우스', price: 50000, category: '전자기기' }
  ]
  */
// forEach를 활용한 방법
let elecDevice = [];
products.forEach(function (product) {
  if (product.category === '전자기기') {
    elecDevice.push(product);
  }
});
console.log('전자기기:', elecDevice);

// filter를 활용한 방법
const elecDevice2 = products.filter(function (product) {
  return product.category === '전자기기';
});
console.log('전자기기:', elecDevice2);

// 문제 4: 모든 상품의 가격을 20% 할인한 새로운 배열을 만드시오.
// [출력형태]
/*
  할인품: [
    { id: 1, name: '노트북', price: 960000, category: '전자기기' },
    { id: 2, name: '스마트폰', price: 640000, category: '전자기기' },
    { id: 3, name: '커피', price: 4000, category: '음료' },
    { id: 4, name: '키보드', price: 120000, category: '전자기기' },
    { id: 5, name: '마우스', price: 40000, category: '전자기기' },
    { id: 6, name: '콜라', price: 2000, category: '음료' },
  ];
  */
// forEach를 이용하는 방법
let sale = structuredClone(products);
sale.forEach(function (product) {
  product.price *= 0.8;
});
console.log('할인품:', sale);

// map을 이용하는 방법
const sale2 = products.map(function (product) {
  product.price *= 0.8;
  return product;
});
console.log('할인품:', sale2);

// 문제 5: 모든 상품의 총 가격을 계산하시오.
// [출력형태]
// 총액: 2207500
let sum = 0;

products.forEach(function (product) {
  sum += product.price;
});

console.log(`총액: ${sum}`);

// 문제 6: 각 상품의 이름과 가격을 출력하시오.
// [출력형태]
// 노트북: 1200000원
// 스마트폰: 800000원
// 커피: 5000원
// 키보드: 150000원
// 마우스: 50000원
// 콜라: 2500원
products.forEach(function (product) {
  console.log(`${product.name}: ${product.price}원`);
});

// 문제 7: 상품들을 가격 기준으로 오름차순 정렬하시오.
// [출력형태]
/*
  정렬: [
    { id: 6, name: '콜라', price: 2500, category: '음료' },
    { id: 3, name: '커피', price: 5000, category: '음료' },
    { id: 5, name: '마우스', price: 50000, category: '전자기기' },
    { id: 4, name: '키보드', price: 150000, category: '전자기기' },
    { id: 2, name: '스마트폰', price: 800000, category: '전자기기' },
    { id: 1, name: '노트북', price: 1200000, category: '전자기기' }
  ]
  */
let sortedProducts = structuredClone(products);
sortedProducts.sort(function (left, right) {
  return left.price - right.price;
});

console.log('정렬:', sortedProducts);

// 문제 8: products 배열의 세 번째 위치에 새로운 상품을 추가하시오.
// [출력형태]
/*
  추가 후: [
    { id: 1, name: '노트북', price: 1200000, category: '전자기기' },
    { id: 2, name: '스마트폰', price: 800000, category: '전자기기' },
    { id: 7, name: '이어폰', price: 30000, category: '전자기기' },
    { id: 3, name: '커피', price: 5000, category: '음료' },
    { id: 4, name: '키보드', price: 150000, category: '전자기기' },
    { id: 5, name: '마우스', price: 50000, category: '전자기기' },
    { id: 6, name: '콜라', price: 2500, category: '음료' }
  ]
  */
products.splice(2, 0, {
  id: 7,
  name: '이어폰',
  price: 30000,
  category: '전자기기',
});
console.log(products);

// 문제 9: 전자기기 카테고리의 상품들의 이름만 추출하여 바로 이름만 출력하시오.
// (filter, map, forEach 체이닝을 이용하세요.)
// [출력형태]
// 노트북
// 스마트폰
// 이어폰
// 키보드
// 마우스
products
  .filter((product) => product.category === '전자기기')
  .map((product) => product.name)
  .forEach((name) => console.log(name));

// 문제 10: 카테고리별 상품의 총 가격을 계산하시오.
// [출력형태]
// 카테고리별: { '전자기기': 2230000, '음료': 7500 }
// const obj = {};
// console.log(obj['temp']); // output: undefined
// console.log(Boolean(obj['temp'])); // output: false

// obj['temp'] = 10;
// console.log(obj['temp']); // output: 10
// console.log(Boolean(obj['temp'])); // output: true

const byCategory = products.reduce((acc, product) => {
  console.log(acc);
  console.log(`acc [${product.category}] :`, acc[product.category]);
  acc[product.category] = (acc[product.category] || 0) + product.price;
  return acc;
}, {}); // acc = { '전자기기': 1790000, '음료': 4000 }

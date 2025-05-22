function createAddress({ city, district, street }) {
  return `${city} ${district} ${street}`;
}
createAddress({ city: '서울', district: '강남구', street: '테헤란로' });

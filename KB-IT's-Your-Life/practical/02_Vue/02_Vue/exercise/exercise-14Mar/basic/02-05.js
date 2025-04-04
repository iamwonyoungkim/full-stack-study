function addContact(
  name,
  mobile,
  home = '없음',
  address = '없음',
  email = '없음'
) {
  console.log(
    `name=${name}, mobile=${mobile}, home=${home}, address=${address}, email=${email}`
  );
}

addContact('홍길동', '010-222-3331');
addContact('이몽룡', '010-222-3331', '02-3422-9900', '서울시');

// 원하는 output:
// name=홍길동, mobile=010-222-3331, home=없음, address=없음, email=없음
// name=이몽룡, mobile=010-222-3331, home=02-3422-9900, address=서울시, email=없음

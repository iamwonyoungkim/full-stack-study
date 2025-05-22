const user = {
  name: '김철수',
  age: 25,
};

const userProxy = new Proxy(user, {
  get: function (target, property) {
    console.log(`${property} 속성 값이 읽어졌어~`);
    return target[property];
  },
  set: function (target, property, value) {
    if (value >= 0) {
      target[property] = value;
    } else {
      target[property] = 0;
    }
    // console.log(`${property} 속성 값이 ${value}로 바뀌었어~`);
    // target[property] = value; // proxy가 가로채왔으므로 set하는 작업을 여기서 해줘야 한다.
    return true;
  },
});

// console.log(user.name); // 읽기(get)
// user.age = 30; // 쓰기(set)

console.log(userProxy.name);
userProxy.age = -30;
console.log(userProxy.age);

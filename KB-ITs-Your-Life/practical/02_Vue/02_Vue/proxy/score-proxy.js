const score = {
  math: 90,
  english: 95,
};

const gradeProxy = new Proxy(score, {
  get: function (target, property) {
    if (target[property] == undefined) {
      return '미응시';
    } else {
      return target[property];
    }
  },
  set: function (target, property, value) {
    if (0 <= value && value <= 100) {
      target[property] = value;
    }
    return true;
  },
});

console.log(gradeProxy.math); // 출력: 90
console.log(gradeProxy.science); // 출력: '미응시'
gradeProxy.korean = 95; // 정상 작동
//gradeProxy.history = 120;      // Error: 점수는 0-100 사이여야 합니다

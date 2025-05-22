function createUser(name, age) {
  return {
    name: name,
    age: age,
  };
}

const createUser1 = (name, age) => {
  return {
    name: name,
    age: age,
  };
};

console.log(createUser('wonyoung', 22));
console.log(createUser1('wonyoung', 22));

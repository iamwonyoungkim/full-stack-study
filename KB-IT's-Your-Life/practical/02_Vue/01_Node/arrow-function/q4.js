function calculateArea(width, height) {
  const area = width * height;
  return `면적은 ${area}입니다.`;
}

const calculateArea1 = (width, height) => {
  const area = width * height;
  return `면적은 ${area}입니다.`;
};

console.log(calculateArea(3, 5));
console.log(calculateArea1(3, 5));

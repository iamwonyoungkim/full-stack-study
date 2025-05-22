let base = 100;
// 첫 번째 방법
// const add = (x) => base + x;
// const multiply = (x) => base * x;

// export { add, multiply };

// 두 번째 방법
// export const add = (x) => base + x;
// export const multiply = (x) => base * x;

// 세 번째 방법
const add = (x) => base + x;
const multiply = (x) => base * x;
const getBase = () => base;

export { add, multiply };
export default getBase;

const str = `1   변리사
2   공인중개사
3   노무사
4   치위생사
5   정보처리기사
6   간호사
7   조산사
8   토목기사
9   공인 세무사
10   법무사
11   공인회계사`;

const res = str.split('\n').map((line) => {
  const job = line.slice(2).trim();
  const obj = {};
  obj.value = job;
  obj.label = job;
  return obj;
});

console.log(res);

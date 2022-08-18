/* BubbleSort.js */
// Bubble Sort

// 指定元素是否存在
function exists(numbers, value, maxIndex = -1)
{
  if (maxIndex === -1)
  {
    maxIndex = numbers.length;
  }
  for (let i = 0; i < maxIndex; i++)
  {
    if (value === numbers[i])
    {
      return true;
    }
  }
  return false
}

// 用不重复的随机数填充数组
function makeNumbers(len)
{
  let results = new Array(len);
  pos = 0;
  while (pos < len)
  {
    let newValue = Math.floor(Math.random() * len + 1);
    if (!exists(results, newValue, pos + 1))
    {
      results[pos] = newValue;
      pos++;
    }
  }
  return results;
}

// 冒泡排序算法
function bubbleSort(numbers)
{
  for (let i = 0; i < numbers.length; i++)
  {
    for (let j = i + 1; j < numbers.length; j++)
    {
      if (numbers[i] > numbers[j])
      {
        let tmp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = tmp;
      }
    }
  }
}

// 验证程序运行结果
function validateResult(numbers)
{
  let total = numbers[0];
  for (let i = 1; i < numbers.length; i++)
  {
    if (numbers[i - 1] > numbers[i])
    {
      return false;
    }
    total += numbers[i];
  }
  return total === (numbers.length + 1) * (Math.floor(numbers.length / 2));
}

console.log("Javascript Program Starting");
let totalTime = new Date().getTime();
let taskTime = new Date().getTime();
let len = 10000;
let numbers = makeNumbers(len);
console.log(`Make Numbers ${(new Date().getTime()) - taskTime} Milliseconds`);
taskTime = new Date().getTime();
bubbleSort(numbers);

console.log(`Bubble Sort ${(new Date().getTime()) - taskTime} Milliseconds`);
taskTime = new Date().getTime();
let ok = validateResult(numbers);
console.log(`Validate Result ${(new Date().getTime()) - taskTime} Milliseconds`);
console.log(`${ok? "Success": "Fail"},  Total Time ${(new Date().getTime()) - totalTime} Milliseconds`);

/* BubbleSort.cs */
// Bubble Sort

using System;

// 指定元素是否存在
bool Exists(int[] numbers, int value, int maxIndex = -1)
{
  if (maxIndex == -1)
  {
    maxIndex = numbers.Length;
  }
  for (int i = 0; i < maxIndex; i++)
  {
    if (value == numbers[i])
    {
      return true;
    }
  }
  return false;
}

// 用随机数填充数组的每一个元素
int[] MakeNumbers(int len)
{
  int[] results = new int[len];
  Random random = new Random();
  int pos = 0;
  while (pos < results.Length)
  {
    int newValue = random.Next(1, len + 1);
    if (!Exists(results, newValue, pos + 1))
    {
      results[pos] = newValue;
      pos++;
    }
  }
  return results;
}

// 冒泡排序算法
void BubbleSort(int[] numbers)
{
  for (int i = 0; i < numbers.Length; i++)
  {
    for (int j = i + 1; j < numbers.Length; j++)
    {
      if (numbers[i] > numbers[j])
      {
        int tmp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = tmp;
      }
    }
  }
}

// 验证程序运行结果
bool ValidateResult(int[] numbers)
{
  int len = numbers.Length;
  long total = numbers[0];
  for (int i = 1; i < numbers.Length; i++)
  {
    if (numbers[i - 1] > numbers[i])
    {
      return false;
    }
    total += numbers[i];
  }
  return total == ((len + 1L) * (len / 2L));
}

Console.WriteLine("CSharp Program Starting");
DateTime totalTime = DateTime.Now;
DateTime taskTime = DateTime.Now;
int len = 10000;
int[] numbers = MakeNumbers(len);
Console.WriteLine("Make numbers {0} Milliseconds", DateTime.Now.Subtract(taskTime).TotalMilliseconds);
taskTime = DateTime.Now;
BubbleSort(numbers);
Console.WriteLine("Bubble Sort {0} Milliseconds", DateTime.Now.Subtract(taskTime).TotalMilliseconds);
taskTime = DateTime.Now;
bool ok = ValidateResult(numbers);
Console.WriteLine("Validate Result {0} Milliseconds", DateTime.Now.Subtract(taskTime).TotalMilliseconds);
Console.WriteLine("{0} Total Time {1} Milliseconds", ok? "Success": "Fail", DateTime.Now.Subtract(totalTime).TotalMilliseconds);

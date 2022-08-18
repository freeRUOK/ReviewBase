/* BubbleSort.c */
// Bubble Sort

#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <time.h>
#include <assert.h>

// 指定元素是否存在
bool exists(int *numbers, int value, int maxIndex)
{
  for (int i = 0; i < maxIndex; i++)
  {
    if (numbers[i] == value)
    {
      return true;
    }
  }
  return false;
}

// 用不重复的随机数填充数组
int *makeNumbers(int *results, int len)
{
  int pos = 0;
  srand(time(0));
  while (pos < len)
  {
    int newValue = rand() % len + 1;
    if (!exists(results, newValue, pos + 1))
    {
      results[pos] = newValue;
      pos++;
    }
  }
  return results;
}

// 冒泡排序算法
void bubbleSort(int *numbers, int len)
{
  for (int i = 0; i < len; i++)
  {
    for (int j = i + 1; j < len; j++)
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
bool validateResult(int *numbers, int len)
{
  long long sum = numbers[0];
  for (int i = 1; i < len; i++)
  {
    if (numbers[i - 1] > numbers[i])
    {
      return false;
    }
    sum += numbers[i];
  }
  return sum == ((len + 1LL) * (len / 2LL));
}

int main(void)
{
  printf("The C Language Program Starting\n");
  clock_t totalTime = clock();
  clock_t taskTime = clock();
  int len = 10000;
  int *numbers = (int *)malloc(len * sizeof(int));
  assert(numbers);
  makeNumbers(numbers, len);
  printf("Make Numbers %ld Milliseconds\n", clock() - taskTime);
  taskTime = clock();
  bubbleSort(numbers, len);
  printf("Bubble Sort %ld Milliseconds\n", clock() - taskTime);
  taskTime = clock();
  bool ok = validateResult(numbers, len);
  printf("Validate Result %ld Milliseconds\n", clock() - taskTime);
  printf("%s,  Total Time %ld Milliseconds\n", ok? "Success": "Fail", clock() - totalTime);
  free(numbers);
  return 0;
}

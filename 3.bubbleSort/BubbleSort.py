# --*-- Encoding: UTF-8 --*--
#! filename: bubblesort.py
# Bubble Sort

import time
import random

# 指定元素是否存在
def exists(numbers, value, maxIndex = -1):
  if maxIndex == -1:
    maxIndex = len(numbers)

  for i in range(maxIndex):
    if value == numbers[i]:
      return True

  return False


# 用不重复的随机数填充数组
def makeNumbers(len):
  results = []
  pos = 0
  while pos < len:
    newValue = random.randint(1, len)
    if not exists(results, newValue):
      results.append(newValue)
      pos += 1

  return results


# 冒泡排序算法
def bubbleSort(numbers):
  for i in range(len(numbers)):
    for j in range(i +1, len(numbers)):
      if numbers[i] > numbers[j]:
        numbers[i], numbers[j] = numbers[j], numbers[i]


# 验证运行结果
def validateResult(numbers):
  total = numbers[0]
  for i in range(1, len(numbers)):
    if numbers[i - 1] > numbers[i]:
      return False

    total += numbers[i]

  return total == ((num + 1) * (num // 2))


if __name__ == "__main__":
  print("Python Program Starting")
  totalTime = time.time()
  taskTime = time.time()
  num = 10000
  numbers = makeNumbers(num)
  print("Make Numbers {} Milliseconds".format(int((time.time() - taskTime) * 1000)))
  taskTime = time.time()
  bubbleSort(numbers)
  print("Bubble Sort {} Milliseconds".format(int((time.time() - taskTime) * 1000)))
  taskTime = time.time()
  ok = validateResult(numbers)
  print("Validate Result {} Milliseconds".format(int((time.time() - taskTime) * 1000)))
  print("{}， Total Time {} Milliseconds".format(("Success" if ok else "Fail"), int((time.time() - totalTime) * 1000)))

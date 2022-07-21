# --*-- Encoding: UTF-8 --*--
#! fileName: sum.py
# Range Sum

import sys

def sumRange(num):
  total = 0
  for i in range(1, num + 1):
    total += i

  return total

if __name__ == "__main__":
  if len(sys.argv) == 1:
    userInput = input("Enter Range\n")
  else:
    userInput = sys.argv[1]

  try:
    num = int(userInput)
  except ValueError:
    print("Enter Error.")
    sys.exit()

  result = sumRange(num)
  print("Result: {}".format(result))

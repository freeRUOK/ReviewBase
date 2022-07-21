/* sum.c */
// Sum Range

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

long long sumRange(long long);

int main(int argv, char **args)
{
  char userInput[256];
  if (argv == 1)
  {
    printf("Enter Range\n");
  if (scanf("%s", userInput) != 1)
    {
      printf("Input Error Or Zero.\n");
      return -1;
    }
  }
  else
  {
    strcpy(userInput, args[1]);
  }
  long long num = atoll(userInput);
  if (num == 0)
  {
    printf("Input Error Or Zero.\n");
    return -1;
  }
  long long result = sumRange(num);
  printf("Result: %lld\n", result);
  return 0;
}

long long sumRange(long long num)
{
  long long sum = 0LL;
  for (long long i = 1; i <= num; i++)
  {
    sum += i;
  }
  return sum;
}

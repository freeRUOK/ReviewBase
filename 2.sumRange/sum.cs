/* sum.cs */
// Range Sum
using System;

namespace Sum
{
  public class Program
  {
    public static long SumRange(long num)
    {
      long sum = 0L;
      for (long i = 1; i <= num; i++)
      {
        sum += i;
      }
      return sum;
    }
    public static void Main(string[] args)
    {
      string userInput;
      if (args.Length == 0)
      {
        Console.WriteLine("Enter Range");
        userInput = Console.ReadLine();
      }
      else
      {
        userInput = args[0];
      }
      long num = 0L;
      try
      {
        num = Convert.ToInt64(userInput);
      }
      catch (FormatException)
      {
        Console.WriteLine("Input Error.");
        return;
      }
      long result = SumRange(num);
      Console.WriteLine("Result: {0}", result);
    }
  }
}

/* sum/Program.java */
// Sum Range

package sum;
import java.util.Scanner;

public class Program
{
  public static long sumRange(long num)
  {
    long sum = 0L;
    for (long i = 1L; i <= num; i++)
    {
      sum += i;
    }
      return sum;
  }
  public static void main(String[] args)
  {
    String userInput;
    if (args.length == 0)
    {
      System.out.println("Enter Range");
      userInput = new Scanner(System.in).next();
    }
    else
    {
      userInput = args[0];
    }
    long num = 0L;
    try
    {
      num = Long.parseLong(userInput);
    }
    catch (NumberFormatException e)
    {
      System.err.println("Input Error.");
      return;
    }
    long result = sumRange(num);
    System.out.println(String.format("Result: %d", result));
  }
}

/* bubblesort/Program.java */
// Bubble Sort

package bubblesort;
import java.util.Random;

public class Program
{
  // 指定元素是否存在
  public static boolean  exists(int[] numbers, int value, int maxIndex)
  {
    if (maxIndex == -1)
    {
      maxIndex = numbers.length;
    }
    for (int i = 0; i < maxIndex; i++)
    {
      if (numbers[i] == value)
      {
        return true;
      }
    }
    return false;
  }

  // 生成有随机值组成的数组
  public static int[] mkNumbers(int len)
  {
    int[] results = new int[len];
    Random random = new Random();
    int pos = 0;
    while (pos < results.length)
    {
      int newValue = random.nextInt(results.length + 1);
      if (!exists(results, newValue, pos + 1))
      {
        results[pos] = newValue;
        pos++;
      }
    }
    return results;
  }

  // 冒泡排序
  public static void bubbleSort(int[] numbers)
  {
    for (int i = 0; i < numbers.length; i++)
    {
      for (int j = i + 1; j < numbers.length; j++)
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

  // 验证程序执行结果
  public static boolean validateResult(int[] numbers)
  {
    long sum = numbers[0];;
    for (int i = 1; i < numbers.length; i++)
    {
      if (numbers[i - 1] > numbers[i])
      {
        return false;
      }
    sum += numbers[i];
    }
    return sum == ((numbers.length + 1L) * (numbers.length / 2L));
  }

  public static void main(String[] args)
  {
    System.out.println("Java Program Starting");
    long totalTime = System.currentTimeMillis();
    long taskTime = System.currentTimeMillis();
  int len = 10000;
    int[] numbers = mkNumbers(len);
    System.out.println("Make Numbers " + (System.currentTimeMillis() - taskTime) + "Milliseconds");
    taskTime = System.currentTimeMillis();
    bubbleSort(numbers);
    System.out.println("Bubble Sort " + (System.currentTimeMillis() - taskTime) + "Milliseconds");
    taskTime = System.currentTimeMillis();
    boolean ok = validateResult(numbers);
    System.out.println("Validate Result " + (System.currentTimeMillis() - taskTime) + "Milliseconds");
    System.out.printf("%s，  %d Milliseconds\n", (ok? "Success": "Fail"), System.currentTimeMillis() - totalTime);
  }
}

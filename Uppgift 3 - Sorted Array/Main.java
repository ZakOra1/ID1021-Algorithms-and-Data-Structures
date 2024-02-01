import java.util.Random;

public class Main {

  public static void main(String[] args) {
    Random rand = new Random();
    int n = 1000;
    int[] array1 = new int[0];
    int[] array2 = new int[0];
    boolean foundKey = false;
    boolean foundOnce = false;
    double min = Double.POSITIVE_INFINITY;
    long max = 0;

    long t0 = System.nanoTime();
    long t_total = 0;
    long temp = 0;

    for (int i = 0; i < 1000; i++) {
      array1 = sorted(n);
      array2 = sorted(n);

      temp += even_better(array1, array2);
    }

    temp = 0;

    for (int i = 0; i < 1000; i++) {
      array1 = sorted(n);
      array2 = sorted(n);

      // Find key and clock the time
      temp = even_better(array1, array2);
      t_total += temp;

      if (temp > max) {
        max = temp;
      }
      if (temp < min && temp != 0) {
        min = temp;
      }
      if (foundKey == true) {
        foundOnce = true;
      }
    }

    System.out.println("Found key? " + foundOnce);
    System.out.println("Average runtime: " + t_total / 1000 + "ns");
    System.out.println("Min runtime: " + min + "ns");
    System.out.println("Max runtime: " + max + "ns");
  }

  public static long even_better(int[] array, int[] key) {
    long t0 = System.nanoTime();
    int index = 0;
    for (int i = 0; i < key.length; i++) {
      int nextKey = key[i];
      while (index < array.length) {
        if (array[index] == nextKey) {
          index++;
          break;
        }
        if (array[index] < nextKey) {
          index++;
          continue;
        }
        break;
      }
    }
    long t1 = (System.nanoTime() - t0);
    return t1;
  }

  public static boolean binary_search(int[] array, int key) {
    int first = 0;
    int last = array.length - 1;
    while (true) {
      // jump to the middle
      int index = (first + last) / 2;
      if (array[index] == key) {
        return true;
      }

      if (array[index] < key && index < last) {
        // The index position holds something that is less than
        // what we're looking for, what is the first possible page?
        first = index + 1;
        continue;
      }

      if (array[index] > key && index > first) {
        // The index position holds something that is larger than
        // what we're looking for, what is the last possible page?
        last = index - 1;
        continue;
      }

      // Why do we land here? What should we do?
      // If we land here, the element is not found within the array
      break;
    }
    return false;
  }

  private static int[] sorted(int n) {
    Random rnd = new Random();
    int[] array = new int[n];
    int nxt = 0;
    for (int i = 0; i < n; i++) {
      nxt += rnd.nextInt(10) + 1;
      array[i] = nxt;
    }
    return array;
  }

  public static boolean search_unsorted(int[] array, int key) {
    for (int index = 0; index < array.length; index++) {
      if (array[index] == key) {
        return true;
      }
    }
    return false;
  }

  public static boolean search_sorted(int[] array, int key) {
    for (int index = 0; index < array.length; index++) {
      if (array[index] == key) {
        return true;
      }
      if (array[index + 1] > key) {
        break;
      }
    }
    return false;
  }
}

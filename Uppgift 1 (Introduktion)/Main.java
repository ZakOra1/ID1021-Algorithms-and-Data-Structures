import java.util.Random;

public class Main {
  
    public static void main(String[] args) {
        //int n = 100000;
        //System.out.println("Average time: " + access(n) + "ns"); 
        
        //System.out.println("Average time: " + search(100, 100, 10_000) + "ns");
        double ans = 0;
        //int m = 10000;
        int n = 10;
        int k = 1000;
        search_duplicates(n,k);
        for(int i = 0; i < 1000; i++) {
            ans += search_duplicates(n,k);
        }
        System.out.println("Average time: " + ans/1000 + "ns");
    }

    private static double search_duplicates(int n, int k) {
        int[] array_keys = new int[n];
        int[] array = new int[n];
        
        double t_total = 0;
        
        Random rnd = new Random();

        for (int j = 0; j < k; j++) {
            
            for(int i = 0; i < n; i++){
                array_keys[i] = rnd.nextInt(10*n);
                array[i] = rnd.nextInt(10*n);
            }
            int sum = 0; 
            long t0 = System.nanoTime();
            for (int ki = 0; ki < n; ki++) {
                int key = array_keys[ki];
                for (int i = 0; i < n ; i++) {
                    if (array[i] == key) {
                        sum++;
                    }
                }
            }
            t_total += (System.nanoTime() - t0);
        }
        return (double)((double)t_total/(double)k);
    }


    private static double search(int n, int m, int k) {
        int[] keys = new int[m];
        int[] array = new int[n];
        double t_total = 0;
        Random rnd = new Random();
        int sum = 0;
        for (int j = 0; j < k; j++) {
            // fill the keys array with random number from 0 to 10*n
            for(int i = 0; i < m; i++){
                keys[i] = rnd.nextInt(10*n);
            }
            // fill the array with with random number from 0 to 10*n
            for(int i = 0; i < n; i++){
                array[i] = rnd.nextInt(10*n);
            }
            
            long t0 = System.nanoTime();
            for (int ki = 0; ki < m; ki++) {
                int key = keys[ki];
                for (int i = 0; i < n ; i++) {
                    if (array[i] == key) {
                        sum++;
                        break;
                    }
                }
            }
            t_total += (System.nanoTime() - t0);
        }
        return t_total/(m*k);
    }

    private static double access(int n) {
        int k = 1_000_000;
        int l = n;
        Random rnd = new Random();

        //Filling the indx array with ranom numbers from 0 up to n-1
        int[] indx = new int[l];
        for(int i = 0; i < n; i++){
            indx[i] = rnd.nextInt(n);
        }
        
        //Filling the array with random values from 0 up to 11
        int[] array = new int[n];
        for(int i = 0; i < n; i++) {
            array[i] = i;
        }

        int sum = 0;
        long t0 = System.nanoTime();
        for (int j = 0; j < k; j++) {
            for (int i = 0; i < l; i++) {
                sum += array[indx[i]];
            }
        }
        long t_access = (System.nanoTime() - t0);
        
        t0 = System.nanoTime();
        // do the same loop iteration but only do a dummy add operation
        sum = 0;
        for (int j = 0; j < k; j++) {
            for (int i = 0; i < l; i++) {
                sum += 1;
            }
        }
        long t_dummy = (System.nanoTime() - t0);
        return ((double)(t_access - t_dummy))/((double)k*(double)l);
    }
  }
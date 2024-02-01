import java.util.Random;

public class Main {
    public static void main(String[] args) {
        long time_insert = 0;
        long time_section = 0;
        long time_merge = 0;
        int n = 16000;
        int[] array = new int[0];
        

        // SECTION_SORT
        for(int i = 0; i < 1000; i++) {
            array = random_array(n);
            time_section += section_sort(array);
        }
        time_section = 0;
        for(int i = 0; i < 1000; i++) {
            array = random_array(n);
            time_section += section_sort(array);
        }

        // INSERT SORT
        for(int i = 0; i < 1000; i++) {
            array = random_array(n);
            time_insert += insert_sort(array);
        }
        time_insert = 0;
        for(int i = 0; i < 1000; i++) {
            array = random_array(n);
            time_insert += insert_sort(array);
        }

        // MERGE SORT
        for (int i = 0; i < 1000; i++) {
            array = random_array(n);
            long t0 = System.nanoTime();
            sort(array);
            time_merge += (System.nanoTime() - t0); 
        }
        time_merge = 0;
        for (int i = 0; i < 1000; i++) {
            array = random_array(n);
            double t0 = System.nanoTime();
            array = sort(array);
            time_merge += (System.nanoTime() - t0);
        }
        
        
        System.out.println("For n = " + n + "\nSection Sort: " + time_section/1000 + "ns\nInsert sort: " + time_insert/1000 + "ns\nMerge Sort: " + time_merge/1000 + "ns");
    }

    public static int[] random_array(int n) {
        Random rand = new Random();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = rand.nextInt(n);
        }
        return array;
    }

    public static int[] sort(int[] org) {
        if (org.length == 0)
            return org;
        int[] aux = new int[org.length];
        return sort(org, aux, 0, org.length - 1);
    }

    private static int[] sort(int[] org, int[] aux, int lo, int hi) {
        if (lo != hi) {
            int mid = lo + (hi - lo) / 2;
            // sort the items from lo to mid
            sort(org, aux, lo, mid);
            // sort the items from mid+1 to hi
            sort(org, aux, mid+1, hi);
            // merge the two sections using the additional array
            org = merge(org, aux, lo, mid, hi);
        }
        return org;
    }

    private static int[] merge(int[] org, int[] aux, int lo, int mid, int hi) {
        for (int i = lo; i <= hi; i++) {
            aux[i] = org[i];
        }
        
        int i = lo; // the index in the first part
        int j = mid + 1; // the index in the second part
        
        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                org[k] = aux[j++];
            }
            else if (j > hi) {
                org[k] = aux[i++];
            }
            else if(aux[i] < aux[j]) {
                org[k] = aux[i++];
            }
            else {
                org[k] = aux[j++];
            }
        }
        return org;
    }

    public static long insert_sort(int[] array) {
        long t0 = System.nanoTime();
        for (int i = 0; i < array.length; i++) {
            for (int j = i; j > 0 && array[j] < array[j - 1]; j--) {
                int temp = array[j];
                array[j] = array[j - 1];
                array[j - 1] = temp;
            }
        }
        return (System.nanoTime() - t0);
    }

    public static long section_sort(int[] array) {
        long t0 = System.nanoTime();
        for (int i = 0; i < array.length - 1; i++) {
            int cand = i;
            for (int j = i; j < array.length; j++) {
                if (array[j] < array[cand]) {
                    cand = j;
                }
            }
            int temp = array[i];
            array[i] = array[cand];
            array[cand] = temp;
        }
        return (System.nanoTime() - t0);
    }
}
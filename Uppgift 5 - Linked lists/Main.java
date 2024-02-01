import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int SIZE_A = 16000;
        int SIZE_B = 16000;
        long exec_time = 0;

        //exec_time = benchLinkedList(SIZE_A, SIZE_B);
        //exec_time = benchLinkedList(SIZE_A, SIZE_B);

        //exec_time = benchArrayList(SIZE_A, SIZE_B);
        //exec_time = benchArrayList(SIZE_A, SIZE_B);

        for(int i = 0; i < 2000; i++) {
            long t0 = System.nanoTime();
            LinkedList list_A = randomList(SIZE_A);
            exec_time += (System.nanoTime() - t0);
        }
        exec_time = 0;
        for(int i = 0; i < 2000; i++) {
            long t0 = System.nanoTime();
            LinkedList list_A = randomList(SIZE_A);
            exec_time += (System.nanoTime() - t0);
        }

        System.out.println("Average execution time: " + exec_time/2000 + "ns" + "\n   - SIZE = " + SIZE_A);
        //System.out.println("Average execution time: " + exec_time/2000 + "ns" + "\n   - SIZE_A = " + SIZE_A + "\n   - SIZE_B = " + SIZE_B);
    }

    public static long benchArrayList(int SIZE_A, int SIZE_B) {
        // APPEND ARRAY A TO ARRAY B
        long exec_time = 0;
        for(int i = 0; i < 2000; i++) {
            ArrayList array_A = randomArray(SIZE_A);
            ArrayList array_B = randomArray(SIZE_B);
            
            long t0 = System.nanoTime();
            array_B.append(array_A);
            exec_time += (System.nanoTime() - t0);
        }
        return exec_time;
    }

    public static ArrayList randomArray(int size) {
        Random rand = new Random();
        int[] array = new int[size];
        for(int i = 0; i < size; i++) {
            array[i] = rand.nextInt(1000);
        }
        ArrayList res = new ArrayList(array);
        return res;
    }

    public static long benchLinkedList(int SIZE_A, int SIZE_B) {
        // APPEND LIST A TO LIST B
        long exec_time = 0;
        for(int i = 0; i < 2000; i++) {
            LinkedList list_A = randomList(SIZE_A);
            LinkedList list_B = randomList(SIZE_B);
            
            long t0 = System.nanoTime();
            list_B.append(list_A);
            exec_time += (System.nanoTime() - t0);
        }
        return exec_time;
    }

    public static LinkedList randomList(int size) {
        Random rand = new Random();
        LinkedList resultList = new LinkedList();
        for(int i = 0; i < size; i++) {
            int item = rand.nextInt(1000);
            if(i == 0) {
                resultList = new LinkedList(item, null);
            }
            else {
                LinkedList tempList = new LinkedList(item, resultList);
                resultList = tempList;
            }
        }
        return resultList;
    } 
}

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        int listSize = 10000;
        int sequenceSize = 100;
        long double_LL_time = 0;
        long single_LL_time = 0;
        
        /* 
        DoubleLinkedList test = random_DList(listSize);
        DoubleLinkedList copy = test;
        for(int i = 0; i < listSize; i++) {
            if(test.previous != null) {
                System.out.println("Previous: " + test.previous.value);
            }
            else {
                System.out.println("Previous: NULL");
            }
            System.out.println("Item " + (i+1) + ": " + test.value);
            if(test.tail != null) {
                System.out.println("Next: " + test.tail.value);
            }
            else {
                System.out.println("Next: NULL");
            }
            System.out.println("-----------------------");
            test = test.tail; 
        }


        test = copy;
        DoubleLinkedList second = test.tail;
        test = test.remove(test, second);
        test = test.add(second);
        System.out.println("\n\n");
        for(int i = 0; i < listSize; i++) {
            if(test.previous != null) {
                System.out.println("Previous: " + test.previous.value);
            }
            else {
                System.out.println("Previous: NULL");
            }
            System.out.println("Item " + (i+1) + ": " + test.value);
            if(test.tail != null) {
                System.out.println("Next: " + test.tail.value);
            }
            else {
                System.out.println("Next: NULL");
            }
            System.out.println("-----------------------");
            test = test.tail; 
        }
        */
        
        for (int j = 0; j < 2000; j++) {
            
            int[] sequence = randomSequence(sequenceSize, listSize);    
            DoubleLinkedList double_LL = random_DList(listSize);
            LinkedList single_LL = randomList(listSize);
    
            for (int i = 0; i < sequence.length; i++) {
                double_LL_time += bench_DLL(sequence[i], double_LL);
                //single_LL_time += bench_LL(sequence[i], single_LL);
            }
        }

        double_LL_time = 0;
        single_LL_time = 0;

        for (int j = 0; j < 2000; j++) {
            
            int[] sequence = randomSequence(sequenceSize, listSize);    
            DoubleLinkedList double_LL = random_DList(listSize);
            LinkedList single_LL = randomList(listSize);
    
            for (int i = 0; i < sequence.length; i++) {
                double_LL_time += bench_DLL(sequence[i], double_LL);
                //single_LL_time += bench_LL(sequence[i], single_LL);
            }
        }

        System.out.println("n = " + sequenceSize);
        System.out.println("Average DLL time: " + double_LL_time/2000);
        System.out.println("Average SLL time: " + single_LL_time/2000);
    }

    public static long bench_DLL(int n, DoubleLinkedList list) {
        DoubleLinkedList current = list;
        
        for (int i = 0; current != null && i < n - 1; i++) {
            current = current.tail;
        }

        long t0 = System.nanoTime();

        list.deleteNode(list, current);
        list = list.add(current);

        return (System.nanoTime() - t0);
    }

    public static long bench_LL(int n, LinkedList list) {
        
        LinkedList current = list;
        
        for (int i = 0; current != null && i < n - 1; i++) {
            current = current.tail;
        }
        
        long t0 = System.nanoTime();
        
        list.remove(list,current);
        list.add(list,current);

        return (System.nanoTime() - t0);
    }

    public static int[] randomSequence(int sequenceSize, int listSize) {
        int[] sequence = new int[sequenceSize];
        Random rnd = new Random();
        for (int i = 0; i < sequenceSize; i++) {
            sequence[i] = rnd.nextInt(2000);
        }
        return sequence;
    }

    public static LinkedList randomList(int size) {
        Random rand = new Random();
        LinkedList resultList = new LinkedList();
        for (int i = 0; i < size; i++) {
            int item = rand.nextInt(1000);
            if (i == 0) {
                resultList = new LinkedList(item, null);
            } else {
                LinkedList tempList = new LinkedList(item, resultList);
                resultList = tempList;
            }
        }
        return resultList;
    }

    public static DoubleLinkedList random_DList(int size) {
        Random rand = new Random();
        DoubleLinkedList resultList = new DoubleLinkedList();
        for (int i = 0; i < size; i++) {
            int item = rand.nextInt(1000);
            if (i == 0) {
                resultList = new DoubleLinkedList(item, null, null);
            } else {
                DoubleLinkedList tempList = new DoubleLinkedList(item, resultList, null);
                resultList.previous = tempList;
                resultList = tempList;
            }
        }

        return resultList;
    }
}
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int size = 5000; 
        int loop = 1000;

        bench_Heaps(size, loop);

    }

    public static Integer[] bench_heapTree(Integer[] depth, int size, int loop, int push_size) {
        ListHeap heap = new ListHeap();
        Random rand = new Random();
        Integer[] removed_Ints = new Integer[500];
        Integer[] added_Ints = new Integer[500];

        for (int j = 0; j < 1024; j++) {
            int value = rand.nextInt(100);
            heap.add(value);
        }
        for(int i = 0; i < removed_Ints.length; i++) {
            int value = rand.nextInt(50);
            removed_Ints[i] = heap.remove() + value;
        }
        for(int i = 0; i < removed_Ints.length; i++) {
            //added_Ints[i] = heap.add(removed_Ints[i]);
        }
        return added_Ints;
    }

    public static void bench_List(int size, int loop) {
        PriorityQueueList heapList1 = new PriorityQueueList();
        PriorityQueueList heapList2 = new PriorityQueueList();
        long list1_time = 0;
        long list2_time = 0;
        Random rand = new Random();

        for (int j = 0; j < loop; j++) {
            for (int i = 0; i < size; i++) {
                int value = rand.nextInt(1000000);
                long t0 = System.nanoTime();
                heapList1.add(value);
                list1_time += (System.nanoTime() - t0);
                long t1 = System.nanoTime();
                heapList2.add2(value);
                list2_time += (System.nanoTime() - t1);
            }
            for (int i = 0; i < size; i++) {
                long t0 = System.nanoTime();
                heapList1.remove();
                list1_time += (System.nanoTime() - t0);
                long t1 = System.nanoTime();
                heapList2.remove2();
                list2_time += (System.nanoTime() - t1);
            }
        }
        list1_time = 0;
        list2_time = 0;
        for (int j = 0; j < loop; j++) {
            for (int i = 0; i < size; i++) {
                int value = rand.nextInt(1000000);
                long t0 = System.nanoTime();
                heapList1.add(value);
                list1_time += (System.nanoTime() - t0);
                long t1 = System.nanoTime();
                heapList2.add2(value);
                list2_time += (System.nanoTime() - t1);
            }
            for (int i = 0; i < size; i++) {
                long t0 = System.nanoTime();
                heapList1.remove();
                list1_time += (System.nanoTime() - t0);
                long t1 = System.nanoTime();
                heapList2.remove2();
                list2_time += (System.nanoTime() - t1);
            }
        }
        System.out.println("Heap List 1 time: " + list1_time / loop + "ns");
        System.out.println("Heap List 2 time: " + list2_time / loop + "ns");
    }

    public static void bench_Heaps(int size, int loop) {
        ListHeap listHeap = new ListHeap();
        ArrayHeap arrayHeap = new ArrayHeap(100000);
        long list_time = 0;
        long array_time = 0;
        Random rand = new Random();

        for (int j = 0; j < loop; j++) {
            listHeap = new ListHeap();
            arrayHeap = new ArrayHeap(100000);

            for (int i = 0; i < size; i++) {
                int value = rand.nextInt(10000);
                long t0 = System.nanoTime();
                listHeap.add(value);
                list_time += (System.nanoTime() - t0);
                long t1 = System.nanoTime();
                arrayHeap.add(value);
                array_time += (System.nanoTime() - t1);
            }
            for (int i = 0; i < size; i++) {
                long t0 = System.nanoTime();
                listHeap.remove();
                list_time += (System.nanoTime() - t0);
                long t1 = System.nanoTime();
                arrayHeap.remove();
                array_time += (System.nanoTime() - t1);
            }
        }

        System.out.println("Size: " + size);
        System.out.println("List Heap time: " + list_time/loop);
        System.out.println("Array Heap time: " + array_time/loop);
    }
}
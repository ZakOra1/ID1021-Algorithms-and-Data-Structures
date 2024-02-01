import java.util.*;

public class Main {
    public static void main(String[] args) {
        int loop = 100000;
        int n = 1;
        int k = 1;
        
        for(int j = 0; j < 10; j++){
            System.out.println("n = " + n);
    
            long minList = Long.MAX_VALUE;
            long averageList = 0;
            long minDList = Long.MAX_VALUE;
            long averageDList = 0;
            
            for(int i = 0; i < loop; i++){

                //Lists
                DLinkedList dList = DLinkedList.makeDoubleList(n);
                LinkedList list = LinkedList.makeList(n);

                //Make random elements that will later be used for removing and adding
                int[] sequence = new int[k];
                Random rnd = new Random();
                for (int m = 0; m < k; m++) {
                    sequence[m] = rnd.nextInt(n);
                }

                //Removes and adds all 'k' elements in a Doubly Linked List
                for(int m = 0; m < k; m++){
                    //Finds node to remove for Doubly List
                    DLinkedList randDNode = dList;
                    while(randDNode.head != sequence[m]){
                        randDNode = randDNode.next;
                    }

                    //Benchmark of removing and adding the node for Doubly List
                    long t0 = System.nanoTime();
                    dList = DLinkedList.dRemAdd(dList, randDNode);
                    long time = (System.nanoTime() - t0);
                    if(time < minDList){
                        minDList = time;
                    }
                    averageDList += time;
                }
                
                //Removes and adds all 'k' elements in a Single Linked List
                for(int m = 0; m < k; m++){
                    //Finds node to remove for Single List
                    LinkedList randNode = list;
                    while(randNode.head != sequence[m]){
                        randNode = randNode.tail;
                    }

                    //Benchmark of removing and adding the node for Single List
                    long t0 = System.nanoTime();
                    list = LinkedList.remAdd(list, randNode);
                    long time = (System.nanoTime() - t0);
                    if(time < minList){
                        minList = time;
                    }
                    averageList += time;
                }
                
            }

            System.out.println("Single linked list runtime: " + (averageList/loop) + " ns. (min runtime: " + minList + " ns.)");
            System.out.println("Doubly linked list runtime: " + (averageDList/loop) + " ns. (min runtime: " + minDList + " ns.)");

            System.out.println();
            n=2*n;
        }
    }
}
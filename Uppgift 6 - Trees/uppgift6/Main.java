package uppgift6;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int n = 100000;
        int loop = 1500000;
        Random rnd = new Random();
        /* 
        for(int u = 0; u < 1; u++){
            System.out.println("n = " + n);
            long average = 0;
            long min = Integer.MAX_VALUE;

            BinaryTree tree = new BinaryTree();
            tree.buildTree(n);



            for(int i = 0; i < loop; i++){
                long t0 = System.nanoTime();
                tree.lookup(rnd.nextInt(n));
                long time = (System.nanoTime() - t0);
                if(time < min){
                    min = time;
                }
                average += time;
            }

            System.out.println("Average runtime: " + average/loop + " ns. (Min: " + min + " ns.)");
            System.out.println();
            n= n*2;
        }
        */

        //Testa iterator
        BinaryTree tree = new BinaryTree();
        tree.add(5,105);
        tree.add(2,102);
        tree.add(7,107);
        tree.add(1,101);
        tree.add(8,108);
        tree.add(6,106);
        tree.add(3,103);
        
        tree.printNodes();
        for(int i : tree){
            System.out.println("next value " + i);
        }
        
    }
}
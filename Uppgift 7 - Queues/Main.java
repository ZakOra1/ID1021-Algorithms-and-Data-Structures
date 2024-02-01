public class Main {
    public static void main(String[] args) {

        ArrayQueue queue = new ArrayQueue(5);
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);


        for(int i = 0; i < 5; i++) {
            System.out.println(queue.queue(i));
        }

        /* 
        BinaryTree tree = new BinaryTree();
        tree.add(5, 105);
        tree.add(2, 102);
        tree.add(7, 107);
        tree.add(1, 101);
        tree.add(8, 108);
        tree.add(6, 106);
        tree.add(3, 103);
        tree.add(4, 103);

        for (int i : tree)
            System.out.println("next value " + i);

        */
        // Testa iterator
        // BinaryTree tree = new BinaryTree();
        // tree.add(1, 1);
        // tree.add(2, 2);
        // tree.add(3, 3);
        // tree.add(4, 4);
        // tree.add(5, 5);

        // tree.iterator();

    }
}

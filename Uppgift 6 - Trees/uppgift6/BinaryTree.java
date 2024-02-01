package uppgift6;
import java.util.Iterator;
import java.util.Random;

public class BinaryTree implements Iterable<Integer>  {

    public class Node {
        public Integer key;
        public Integer value;
        public Node left, right;

        public Node(Integer key, Integer value) {
            this.key = key;
            this.value = value;
            this.left = this.right = null;
        }

        public void print() {
            if(left != null)
                left.print();
            System.out.println(" key: " + key + "\tvalue: " + value);
            if(right != null)
                right.print();
        }
    }

    Node root;
    Random rnd = new Random();

    public Iterator<Integer> iterator() {
        return new TreeIterator(this.root);
    }

    public BinaryTree() {
        root = null;
    }

    public void add(Integer key, Integer value){
        root = add(root,key,value);
    }

    public Node add(Node curr, Integer key, Integer value) {
        if(curr == null) {
            curr = new Node(key, value);
            return curr;
        }
        if(curr.key < key) { 
            curr.right = add(curr.right,key,value);
        }
        else if(curr.key > key) {
            curr.left = add(curr.left,key,value);
        }
        else {
            curr.value = value;
        }

        return curr;
    }

    public Integer lookup(Integer key) {
        return lookup(root, key);
    }

    public Integer lookup(Node curr, Integer key) {
        if(curr.right != null && curr.key < key) {
            return lookup(curr.right, key);
        }
        else if(curr.left != null && curr.key > key) {
            return lookup(curr.left, key);
        }
        else if(curr.key == key){
            return curr.value;
        }
        return null;
    }

    public void printNodes(){
        root.print();        
    }
        

    public void buildTree(int n){
        add(n/2, rnd.nextInt(10*n));

        for(int i = 0; i < n; i++){
            int key = rnd.nextInt(10*n);
            int value = rnd.nextInt(10*n);
            
            add(key, value);
        }
    }
}
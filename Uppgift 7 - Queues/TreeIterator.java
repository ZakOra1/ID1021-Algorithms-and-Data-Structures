import java.util.*;

public class TreeIterator implements Iterator<Integer>{
    private BinaryTree.Node next;
    private Queue queue;

    public TreeIterator(BinaryTree.Node root){
        queue = new Queue();

        if(root != null) {
            next = root;
        } else { return; }

    }

    //Return true if there is no next node to the left
    @Override
    public boolean hasNext(){
        if(next == null){
            return false;
        }
    return true;
    }

    @Override
    public Integer next() {
        if(hasNext() == false) {
            throw new NoSuchElementException();
        }
        
        BinaryTree.Node temp = next;

        if(next != null) {
            if (next.left != null) {
                queue.add(next.left);
            }
            if (next.right != null) {
                queue.add(next.right);
            }
            next = queue.remove();
            return temp.key;
        } else { return null; }
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
package uppgift6;
import java.util.*;
import uppgift6.BinaryTree.Node;

public class TreeIterator implements Iterator<Integer>{
    private Node next;
    private Stack<Node> stack;

    public TreeIterator(Node root){
        stack = new Stack<Node>();
        
        //Start at the root if it exists, and push it to the stack
        if(root != null) {
            next = root;
        } else {
            return;
        }

        //We walk as far left as possible and push every node unto the stack
        while(next.left != null){
            stack.push(next);
            next = next.left;
        }
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
        Node temp = next;
        
        if(hasNext() == false) {
            throw new NoSuchElementException();
        }

        // If you can walk right, walk right, then fully left.
        // otherwise, walk up until you come from left.
        if(next.right != null){
            stack.push(next);
            next = next.right;
            while (next.left != null){
                stack.push(next);
                next = next.left;
            }    
            return temp.value;
        }

        while(true){
            if(stack.peek().left == next){
                next = stack.pop();
                return temp.value;
            }
            if(stack.empty() == true){
                next = null;
                return temp.value;
            }
            next = stack.pop();
        }
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
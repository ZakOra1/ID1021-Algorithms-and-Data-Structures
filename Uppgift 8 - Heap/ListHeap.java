import java.util.*;

public class ListHeap {
	
	// This class is used to represent nodes in the heap.
	private class HeapNode {
		Integer size, priority;
		HeapNode left, right;
		
		HeapNode(Integer priority, HeapNode left, HeapNode right) {
			this.priority = priority;
			this.left = left;	
			this.right = right;
			this.size = 0;
		}
	}

	// Heap root declaration
	HeapNode root;
	Random rnd = new Random();
	
	// ListHeap constructor
	ListHeap() {
		root = null;
	}
	
	// This method adds nodes to the heap.
	public void add(Integer priority) {
		// If the heap is empty then the new node becomes root.
		if(root == null) {
			root = new HeapNode(priority, null, null);
			return;
		}
		else {
			addrecurs(priority, root);
		}
		
	}
	
	private void addrecurs(Integer priority, HeapNode cur) {
		cur.size++;	// increase depth of current sub-heap.
		// Check if the priority element should be swapped.
		if(cur.priority > priority) {
			Integer curtemp = cur.priority;
			cur.priority = priority;
			priority = curtemp;
		}
		
		if(cur.left == null) {								// These add new nodes and break recursion
			cur.left = new HeapNode(priority, null, null);
			return;
		}
		else if(cur.right == null) {
			cur.right = new HeapNode(priority, null, null);
			return;
		}													// these go deeper down the tree via recursion	
		else if(cur.left.size < cur.right.size) {	
			addrecurs(priority, cur.left);
		}
		else {
			addrecurs(priority, cur.right);
		}
	}
	
	// This method removes the top node from the heap and restructures the heap appropriately.
	public Integer remove() {
		if(root == null) {
			//System.out.println("nullroot");
			return null;
		}
		else if(root.size == 0) {
			//System.out.println("rootsize");
			Integer returnee = root.priority;
			root = null;
			return returnee;
		}
		else {
			//System.out.println("recur");
			Integer returnee = root.priority;
			removerecur(root, root);
			return returnee;
		}
	}
	
	private void removerecur(HeapNode cur, HeapNode parent) {
		cur.size--;	// decrease cur size since one node will disappear
		if(cur.left == null && cur.right != null) {
			cur.priority = cur.right.priority;
			removerecur(cur.right, cur);
		}
		else if(cur.right == null && cur.left != null) {
			cur.priority = cur.left.priority;
			removerecur(cur.left, cur);
		}
		else if(cur.right == null && cur.left == null) { // recursion is broken here
			if(parent.left == cur) {
				parent.left = null;
			}
			else {
				parent.right = null;
			}
			return;
		}
		else if(cur.right.priority < cur.left.priority) {
				cur.priority = cur.right.priority;
				removerecur(cur.right, cur);
		}
		else {
				cur.priority = cur.left.priority;
				removerecur(cur.left, cur);
		}
		
		
	}
	
	public Integer push() {
		System.out.print("push made " + root.priority);
		root.priority = 10 + rnd.nextInt(30);
		System.out.println(" into " + root.priority);
		Integer doodad = incr(root.priority);
		Integer depth = 0;
		depth = pushrecur(root, depth);
		
		return depth;
	}
	
	private Integer pushrecur(HeapNode cur, Integer depth) {
		Integer temp = cur.priority;
		depth++;
		
		if(cur.left != null && cur.right != null) {
			if(cur.left.priority < cur.right.priority && cur.left.priority < cur.priority) {
				cur.priority = cur.left.priority;
				cur.left.priority = temp;
				depth = pushrecur(cur.left, depth);
			}
			else if(cur.right.priority < cur.priority) {
				cur.priority = cur.right.priority;
				cur.right.priority = temp;
				depth = pushrecur(cur.right, depth);
			}
		}
		else if(cur.left == null && cur.right != null) {
			if(cur.right.priority < cur.priority) {
				cur.priority = cur.right.priority;
				cur.right.priority = temp;
				depth = pushrecur(cur.right, depth);
			}
		}
		else if(cur.right == null && cur.left != null) {
			if(cur.left.priority < cur.priority) {
				cur.priority = cur.left.priority;
				cur.left.priority = temp;
				depth = pushrecur(cur.left, depth);
			}
		}
		return depth;
	}
	
	private Integer incr(Integer something) {
		something++;
		return something;
	}
	
}
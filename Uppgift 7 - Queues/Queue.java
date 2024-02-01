public class Queue {
    Node firstPos;
    Node lastPos;

    public class Node {
        public Node tail;
        public BinaryTree.Node bNode;

        public Node(BinaryTree.Node bNode, Node list) {
            this.bNode = bNode;
            this.tail = list;
        }
    }

    // Create the first instance of the queue
    public Queue() {
    }

    // Add a node to the front of the queue, and update the pointer
    public void add(BinaryTree.Node bNode) {
        if(firstPos == null) {
            this.firstPos = new Node(bNode, null);
            this.lastPos = firstPos;
        } else {
            firstPos.tail = new Node(bNode, null);
            firstPos = firstPos.tail;
        }
    }

    // Change lastPos to its tail and return the previous value
    public BinaryTree.Node remove() {
        if(lastPos != null) {
            Node res = lastPos;
            if(lastPos.tail != null) {
                lastPos = lastPos.tail;
            }
            else {
                lastPos = null;
            }
            return res.bNode;
        }
        return null;
    }

    /*
     * public void add(Integer item) {
     * Node nxtNode = head;
     * while(nxtNode.tail != null) {
     * nxtNode = nxtNode.tail;
     * }
     * nxtNode.tail = new Node(item, null);
     * }
     */

    /*
     * public Integer remove() {
     * Node temp = head;
     * head = head.tail;
     * temp.tail = null;
     * return temp.item;
     * }
     */

}

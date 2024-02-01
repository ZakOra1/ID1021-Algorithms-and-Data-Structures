public class PriorityQueueList {
  Node head;

  public class Node {
    Node tail;
    Integer value;

    public Node(Integer value, Node list) {
      this.value = value;
      this.tail = list;
    }
  }

  public PriorityQueueList() {
  }

  //region add O(n) and remove O(1)
  public void add2(Integer value) {
    if(this.head != null) {
      Node curr = this.head;

      //Find the correct spot 
      while(curr.tail != null && value >= curr.value) {
        curr = curr.tail;
      }
      if(curr == this.head) {
        Node temp = this.head;
        this.head = new Node(value, temp);
      }
      else {
        Node temp = curr.tail;
        curr.tail = new Node(value, temp);
      }
    }
    else {
      this.head = new Node(value, null);
    }
  }

  public Integer remove2() {
    if(this.head != null) {
      Node temp = this.head;
      this.head = temp.tail;
      temp.tail = null;
      return temp.value;
    }
    return null;
  }
  //endregion


  //#region add O(1) and remove O(n)
  // Add function with time complexity O(1)
  public void add(Integer value) {
    if (this.head == null) {
      this.head = new Node(value, null);
    } else {
      Node temp = new Node(value, this.head);
      this.head = temp;
    }
  }

  // Remove function with time complexity O(n)
  public Integer remove() {
    if (this.head != null) {
      Node prioNode = new Node(Integer.MAX_VALUE, null);
      Node curr = this.head;

      // Find the smallest Integer, the highest prio in the queue
      while (curr != null) {
        if (prioNode.value > curr.value) {
          prioNode = curr;
        }
        curr = curr.tail;
      }

      curr = this.head;

      // Once the prio node is found, it needs to be removed and returned
      // If the prio node is the head
      if (prioNode == this.head) {
        //If there is more than 1 item in the list
        if (this.head.tail != null) {
          this.head = this.head.tail;
        } else //else there is only one item {
          this.head = null;
        }
       else { // If not the head, its a body
        while(curr.tail != null) {
          if (curr.tail == prioNode) {
            curr.tail = curr.tail.tail;
            break;
          }
          curr = curr.tail;
        }
      }
      prioNode.tail = null;
      return prioNode.value;
    
    }return null;

  }

  public void printList() {
    Node temp = this.head;
    while(temp != null) {
      System.out.println(temp.value);
      temp = temp.tail;
    }
  }
  //endregion

}

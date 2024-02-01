public class LinkedList {
    int head;
    LinkedList tail;

    public LinkedList(int item, LinkedList list) {
        head = item;
        tail = list;
    }
    
    public LinkedList() {
        
    }

    public LinkedList(int item) {
        head = item;
        tail = null;
    }

    public int head() {
        return this.head;
    }

    public LinkedList tail() {
        return this.tail;
    }

    public void append(LinkedList b) {
        LinkedList nxt = this;
        while (nxt.tail != null) {
            nxt = nxt.tail;
        }
        nxt.tail = b;
    }

    public void add(LinkedList result, LinkedList add) {
        add.tail = this;
        result = add;
    }

    public void remove(LinkedList result, LinkedList del) {
        if(del == this) {
            result = del.tail;
            del.tail = null;
        }
        else {
            LinkedList current = this;
            while(current.tail != del) {
                current = current.tail;
            }
            if(del.tail == null) {
                current.tail = null;
            }
            else {
                current.tail = del.tail;
            }
        }
    }
}

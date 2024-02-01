public class DoubleLinkedList {
    int value;
    DoubleLinkedList tail;
    DoubleLinkedList previous;

    public DoubleLinkedList(int value, DoubleLinkedList tail, DoubleLinkedList previous) {
        this.value = value;
        this.tail = tail;
        this.previous = previous;
    }

    public DoubleLinkedList() {

    }

    public int value() {
        return this.value;
    }

    public DoubleLinkedList tail() {
        return this.tail;
    }

    public DoubleLinkedList previous() {
        return this.previous;
    }

    public void append(DoubleLinkedList b) {
        DoubleLinkedList nxt = this;
        while (nxt.tail != null) {
            nxt = nxt.tail;
        }
        nxt.tail = b;
        b.previous = nxt;
    }

    public DoubleLinkedList add(DoubleLinkedList add) {
        add.tail = this;
        this.previous = add;
        return add;
    }

    public DoubleLinkedList remove(DoubleLinkedList org, DoubleLinkedList obj) {
        if (obj == org) {         //removing the head element
            org = org.tail;                 //moving the pointer down
            org.previous = null;
        } 
        else if (obj.tail == null) {        //removing the last element
            obj.previous.tail = null;       //removing the pointer
        }
        else {                              //removing a body
            obj.previous.tail = obj.tail;
            obj.tail.previous = obj.previous;
        }
        obj.tail = null;
        obj.previous = null;
        
        return org;
    }


    public void deleteNode(DoubleLinkedList head, DoubleLinkedList del)
    {
 
        // Base case
        if (head == null || del == null) {
            return;
        }
 
        // If node to be deleted is head node
        if (head == del) {
            head = del.tail;
        }
 
        // Change next only if node to be deleted
        // is NOT the last node
        if (del.tail != null) {
            del.tail.previous = del.previous;
        }
 
        // Change prev only if node to be deleted
        // is NOT the first node
        if (del.previous != null) {
            del.previous.tail = del.tail;
        }
 
        // Finally, free the memory occupied by del
        return;
    }

    public void printDoublyList(){
        DoubleLinkedList p = this;
        while(p.tail != null){
            System.out.println(p.value);
            p = p.tail;
        }
        System.out.println();
        System.out.println(p.value);
        System.out.println();
        while(p.previous != null){
            p = p.previous;
            System.out.println(p.value);
        }
    }
}

//#region
// public DoubleLinkedList add(DoubleLinkedList result, DoubleLinkedList add) {
//     this.previous = add;
//     add.tail = result;
//     add.previous = null;
//     result = add;
//     return result;
// }

// public void remove(DoubleLinkedList result, DoubleLinkedList del) {
//     if (del.previous == null) { //HUVUD
//         del.tail.previous = null; 
//         result = del.tail;
//         del.tail = null;
//     } 
//     else if (del.tail == null) {
//         del.previous.tail = null;
//         del.previous = null;
//     }
//     else {
//         del.previous.tail = del.tail;
//         del.tail.previous = del.previous;
//     }
// }
// public void printDoublyList(){
//     DoubleLinkedList p = this;
//     while(p.tail != null){
//         System.out.println(p.value);
//         p = p.tail;
//     }
//     System.out.println();
//     System.out.println(p.value);
//     System.out.println();
//     while(p.previous != null){
//         p = p.previous;
//         System.out.println(p.value);
//     }
// }
//#endregion

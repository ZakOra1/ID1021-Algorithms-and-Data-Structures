public class LinkedList {
    int head;
    LinkedList tail;

    public LinkedList(int item, LinkedList list) {
        head = item;
        tail = list;
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

    public static LinkedList makeList(int n)
    {
        //Create a head node, and a representive copy of it
        LinkedList head = new LinkedList(0,null);
        LinkedList nxt = head;

        //Connect a tail to nxt and define the tail as nxt
        for(int i = 0; i < n; i++){
            nxt.tail = new LinkedList(i+1, null);
            nxt = nxt.tail;
        }

        return head;
    }

    public void printList(){
        LinkedList p = this;
        while(p.tail != null){
            System.out.println(p.head);
            p = p.tail;
        }
        System.out.println(p.head);
    }

    public LinkedList remove(LinkedList list){
        //Move to the node infront of the one we're removing
        LinkedList p = list;
        if(p != this){
            while(p.tail != this){
                p = p.tail;
            }
        }

        //If first node
        if(p == this){
            list = list.tail;
        }
        //If last node
        else if(this.tail == null){
            p.tail = null;
        }
        else{
            p.tail = p.tail.tail;
        }

        //Dereference node
        this.tail = null;
        return list;
    }

    public static LinkedList remAdd(LinkedList list, LinkedList node){
        list = node.remove(list);
        node.append(list);
        list = node;
        return list;     
    }
}
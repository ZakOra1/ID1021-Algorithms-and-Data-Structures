import java.util.NoSuchElementException;
public class ArrayHeap
{ private final int[] prioQ; // store items at indices 1 to n
    private int itemsQ; // number of items on priority queue
    private final int maxSize;

    public ArrayHeap(int maxSize) {
        this.maxSize = maxSize;
        this.itemsQ = 0;
        this.prioQ = new int[this.maxSize];
    }

    private int leftChild(int parentIndex) {
        return (2 * parentIndex + 1);
    }

    private int rightChild(int parentIndex) {
        return (2 * parentIndex + 2);
    }

    private int parentIdex(int childIndex) {
        return ((childIndex - 1) / 2);
    }

    private boolean hasLeft(int index) {
        return (leftChild (index) < itemsQ);
    }

    private boolean hasRight(int index) {
        return (rightChild (index) < itemsQ);
    }

    private boolean hasParent(int index) {
        return (parentIdex(index) >= 0);
    }

    private int leftValue(int parentIndex) {
        return this.prioQ[leftChild (parentIndex)];
    }

    private int rightValue(int parentIndex) {
        return this.prioQ[rightChild (parentIndex)];
    }

    private int parentValue(int childIndex) {
        return this.prioQ[parentIdex(childIndex)];
    }

    private void swap(int index, int index2) {
        int temp = this.prioQ[index];
        this.prioQ[index] = this.prioQ[index2];
        this.prioQ[index2] = temp;
    }

    private void bubble() {
        int index = this.itemsQ - 1;
        while (hasParent(index) && parentValue(index) > prioQ[index]) {
            swap (parentIdex(index), index);
            index = parentIdex(index);
        }
    }

    private void sink() {
        int index = 0;
        while (hasLeft (index)) {
            int smallestChildIndex = leftChild (index);
            if (hasRight (index) && rightValue (index) < leftValue (index)) {
                smallestChildIndex = rightChild (index);
            }
            if (this.prioQ[index] < prioQ[smallestChildIndex]) {
                break;
            } else {
                swap (index, smallestChildIndex);
            }
            index = smallestChildIndex;
        }
    }

    public int peek() {
        if (this.itemsQ == 0) {
            throw new NoSuchElementException();
        }
        return this.prioQ[0];
    }

    public int remove() {
        if (this.itemsQ == 0) {
            throw new NoSuchElementException();
        }
        int returnElement = this.prioQ[0];
        this.prioQ[0] = this.prioQ[this.itemsQ - 1];
        this.itemsQ--;
        sink();
        return returnElement;
    }

    public void add(int item) {
        if (this.itemsQ == maxSize) {
            System.out.println("Heap full");
            return;
        }
        this.prioQ[this.itemsQ] = item;
        this.itemsQ++;
        bubble();
    }

    public void printHeap() {
        System.out.println("The Min Heap is ");
        for (int i = 0; i < this.itemsQ / 2; i++) {
            System.out.println("PARENT : " + this.prioQ[i]);

            System.out.println("--LEFT CHILD : " + this.prioQ[2 * i + 1]);

            System.out.println("--RIGHT CHILD : " + this.prioQ[2 * i + 2]);
            System.out.println();
        }
    }
}
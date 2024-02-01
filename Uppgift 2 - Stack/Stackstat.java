public class Stackstat {
    int size = 200;
    int pointer = -1;
    int[] stack = new int[size];

    public Stackstat() {
        
    }

    public void push(int item) {
        if(++pointer < size)
            stack[pointer] = item;
    }

    public int pop() {
        if (stack_empty() == false) {
            int temp = stack[pointer];
            stack[pointer--] = 0;
            return temp;
        } else {
            return 0;
        }
    }

    public boolean stack_empty() {
        boolean result = false;
        if (pointer == -1) {
            result = true;
            System.out.println("Stack is empty");
        }
        return result;
    }

}
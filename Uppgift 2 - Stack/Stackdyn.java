public class Stackdyn {
    int size = 8;
    int pointer = -1;
    int[] stack = new int[size];

    public void push(int item) {
        if(++pointer < size) {
            stack[pointer] = item;
        }
        else {
            enlarge();
            stack[pointer] = item;
        }
    }

    public void enlarge() {
        size *= 2;
        int[] tempStack = new int[size];
        for(int i = 0; i < size/2; i++) {
            tempStack[i] = stack[i];
        }
        stack = tempStack;
    }

    public int pop() {
        if (stack_empty() == false) {
            int temp = stack[pointer];
            stack[pointer--] = 0;
            
            if(pointer < size/4 && pointer > 8) {
                size /= 2;
                int[] tempStack = new int[size];
                for(int i = 0; i < size/2; i++) {
                    tempStack[i] = stack[i];
                }
                stack = tempStack;
            }
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
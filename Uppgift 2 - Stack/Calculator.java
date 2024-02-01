public class Calculator {

    Item[] expr;
    int ip;
    Stackstat stack;

    public Calculator(Item[] expr) {
        this.expr = expr;
        this.ip = 0;
        this.stack = new Stackstat();
    }

    public double run() {
        long t0 = System.nanoTime();
        while (ip < expr.length) {
            step();
        }
        stack.pop();
        return (System.nanoTime() - t0); 
    }

    public void step() {
        Item nxt = expr[ip++];
        switch (nxt.getType()) {
            case ADD: {
                int y = stack.pop();
                int x = stack.pop();
                stack.push(x + y);
                break;
            }
            case SUB: {
                int y = stack.pop();
                int x = stack.pop();
                stack.push(x - y);
                break;
            }
            case MUL: {
                int y = stack.pop();
                int x = stack.pop();
                stack.push(x * y);
                break;
            }
            case DIV: {
                int y = stack.pop();
                int x = stack.pop();
                stack.push(x / y);
                break;
            }
            case VALUE:
                stack.push(nxt.getValue());
                break;
            default:
                break;
        }
    }
}
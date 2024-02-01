public class ArrayQueue {
    private Integer firstPos, lastPos, n;
    private Integer[] queue;

    public ArrayQueue(Integer n) {
        this.firstPos = this.lastPos = 0;
        this.n = n;
        queue = new Integer[n];
    }

    public Integer queue(int pos) {
        return this.queue[pos];
    }
    
    public void add(Integer item) {        
        //If lastPos < n, the queue is not full, and an item can be added
        if(lastPos < n) {
            queue[lastPos++] = item; 
        } 
        //LastPos is out of range
        if(lastPos == n) {
            if(queue[0] != null) {
                //Queue is full
                return;
            }
            else  {
                //Queue is not full
                lastPos = 0;
                queue[lastPos++] = item;
            }
        }
        //LastPos = FirstPos, meaning the queue is either empty or full
        if(lastPos == firstPos) {
            if(queue[firstPos] == null) {
                //The queue is empty
                queue[lastPos++] = item;
            }
            else {
                //the queue is full
                return;
            }
        }
    }

    public Integer remove() {
        if(firstPos < n) {
            Integer temp = queue[firstPos];
            queue[firstPos++] = null;
            return temp;
        }
        //If firstPos equals lastPos, then the queue is empty
        else if(firstPos == lastPos) {
            return null;
        }
        //If none of the other cases are true, then firstPos > n, and it has to reset back to the start
        firstPos = 0;
        return null;
    }
}

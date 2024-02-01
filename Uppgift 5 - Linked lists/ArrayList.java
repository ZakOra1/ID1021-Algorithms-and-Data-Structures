public class ArrayList {
    int[] array;
    
    public ArrayList(int[] array) {
        this.array = array;
    }

    public void append(ArrayList b) {
        int size = this.array.length + b.array.length;
        int[] newArray = new int[size];
        for(int i = 0; i < size; i++) {
            if(i < this.array.length) {
                newArray[i] = this.array[i];
            }
            else {
                newArray[i] = b.array[i-this.array.length];
            }
        }
        this.array = newArray;
    }
    
}

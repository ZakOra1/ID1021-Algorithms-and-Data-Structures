public class Item {
    private ItemType type;
    private int value;
    
    public Item(ItemType type, int value)
    {
        this.type = type;
        this.value = value;
    }

    public ItemType getType() {
        return type; 
    }

    public int getValue() {
        return value;
    }
}


    
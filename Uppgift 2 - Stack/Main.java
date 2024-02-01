public class Main {

    public static void main(String[] args) {
        double t_total = 0;
        int output = 0;
        for (int j = 0; j < 1000; j++) {
            Item[] item = new Item[] {
                new Item(ItemType.VALUE, 1),
                new Item(ItemType.VALUE, 1),
                new Item(ItemType.ADD, 0),
            };
            Calculator calc = new Calculator(item);
            t_total += calc.run();
        }

        System.out.println("Total execution time: " + t_total / 1000 + "ns");
    }
}
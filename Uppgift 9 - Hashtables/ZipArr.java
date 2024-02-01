import java.io.BufferedReader;
import java.io.FileReader;

public class ZipArr {
    Node[] data;
    int max;

    public class Node {
        Integer code;
        String name;
        Integer pop;

        public Node(Integer code, String name, Integer pop) {
            this.code = code;
            this.name = name;
            this.pop = pop;
        }
    }

    public ZipArr(String file) {
        data = new Node[100_000];
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            int i = 0;
            while ((line = br.readLine()) != null) {
                String[] row = line.split(",");
                Integer code = Integer.valueOf(row[0].replaceAll("\\s",""));
                data[code] = new Node(code, row[1], Integer.valueOf(row[2]));
            }
            max = i - 1;
        } catch (Exception e) {
            System.out.println(" file " + file + " not found");
        }
    }

    public Integer lookup(Integer key) {
        Integer res = null;
        try {
            res = this.data[key].code;
        } 
        catch(NullPointerException e) {}
        return res;
    }

    public void bench_lookup() {
        long time_11115 = 0;
        long time_99499 = 0;
        for(int i = 0; i < 10_000; i++) {
            long t0 = System.nanoTime();
            lookup(11515);
            time_11115 += System.nanoTime() - t0;

            t0 = System.nanoTime();
            lookup(99499);
            time_99499 += System.nanoTime() - t0;
        }
        System.out.println("Lookup 115 15: " + time_11115/10000);
        System.out.println("Look up 994 95: " + time_99499/10000);
    }

}
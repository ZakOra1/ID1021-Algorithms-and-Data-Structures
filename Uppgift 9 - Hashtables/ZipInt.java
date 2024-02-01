import java.io.BufferedReader;
import java.io.FileReader;

public class ZipInt {
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

    public ZipInt(String file) {
        data = new Node[10000];
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            int i = 0;
            while ((line = br.readLine()) != null) {
                String[] row = line.split(",");
                Integer code = Integer.valueOf(row[0].replaceAll("\\s",""));
                data[i++] = new Node(code, row[1], Integer.valueOf(row[2]));
            }
            max = i - 1;
        } catch (Exception e) {
            System.out.println(" file " + file + " not found");
        }
    }

    // Linear look up method
    public Integer lookup_linear(Integer search) {
        Node curr = data[0];
        try {
            for (int i = 0; i < data.length && !curr.code.equals(search); i++) {
                curr = data[i];
            }

            return curr.code;
        } catch (NullPointerException e) {}

        //System.out.println("Item does not exist in database");
        return null;
    }

    public Integer lookup_binary(Integer search) {
        int high = this.data.length - 1;
        int low = 0;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int res = 0;
            try {
                res = search.compareTo(this.data[mid].code);
            } catch (NullPointerException e) {
                break;
            }
            if (res > 0) {
                low = mid + 1;
             } else if (res < 0) {
                high = mid - 1;
            } else {
                return this.data[mid].code;
            }
        }

        //System.out.println("Item does not exist in database");
        return null;
    }

    public void linear_vs_binary() {
        long time_linear_11115 = 0;
        long time_linear_99499 = 0;
        long time_binary_11115 = 0;
        long time_binary_99499 = 0; 
        for(int i = 0; i < 10000; i++) {
            long t0 = System.nanoTime();
            lookup_linear(111_15);
            time_linear_11115 += System.nanoTime() - t0;

            t0 = System.nanoTime();
            lookup_linear(994_99);
            time_linear_99499 += System.nanoTime() - t0;
    
            t0 = System.nanoTime();
            lookup_linear(111_15);
            time_binary_11115 += System.nanoTime() - t0;
    
            t0 = System.nanoTime();
            lookup_linear(994_99);
            time_binary_99499 += System.nanoTime() - t0;
        }


        System.out.println("Linear search time for 111 15: " + time_linear_11115/10000);
        System.out.println("Linear search time for 994 99: " + time_linear_99499/10000);
        System.out.println("Time binary search for 111 15: " + time_binary_11115/10000);
        System.out.println("Time binary search for 994 99: " + time_binary_99499/10000);
    }

}
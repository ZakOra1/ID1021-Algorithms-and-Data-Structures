import java.io.BufferedReader;
import java.io.FileReader;

public class ZipHash {
    Node[] data;
    int max;
    int[] keys = new int[9677];
    int[][] buckets = new int[10][0];
    Integer[] better_hash = new Integer[9675];
    int mod = 7500;

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

    public ZipHash(String file) {
        data = new Node[100_000];
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            int i = 0;
            while ((line = br.readLine()) != null) {
                String[] row = line.split(",");
                Integer code = Integer.valueOf(row[0].replaceAll("\\s", ""));
                data[code] = new Node(code, row[1], Integer.valueOf(row[2]));
                keys[i] = code;
                i++;
            }
            max = i - 1;
        } catch (Exception e) {
            System.out.println(" file " + file + " not found");
        }
    }
    public void add_bucket(int hashValue, Integer zipCode) {
        int[] newBuck = new int[buckets[hashValue].length + 1];
        for(int i = 0; i < newBuck.length-1; i++) {
            newBuck[i] = buckets[hashValue][i];
        }
        buckets[hashValue][newBuck.length-1] = zipCode;
    }

    public void hash_Funct() {
        for(int i = 0; i < max; i++) {
            int hashValue = keys[i] % mod;
            while(better_hash[hashValue] != null) {
                if((hashValue+1) == better_hash.length)
                {
                    hashValue = 0;
                    continue;
                }
                hashValue++;
            }
            better_hash[hashValue] = keys[i];
        }
    }

    public Integer lookup_betterHash(Integer zipCode) {
        int hashValue = zipCode % mod;
        int depth = 0;
        while(better_hash[hashValue] != zipCode) {
            if((hashValue+1) == better_hash.length) {
                hashValue = 0;
                depth++;
                //continue;
            }
            hashValue++;
            depth++;
        }
        System.out.println("Depth: " + depth);
        return better_hash[hashValue];
    }

    public void collisions(int mod) {
        System.out.println(this.max);
        int[] data = new int[mod];
        int[] cols = new int[10];

        for (int i = 0; i < max; i++) {
            Integer hashValue = keys[i] % mod;
            cols[data[hashValue]]++;
            if(data[hashValue] < 9) {
                data[hashValue]++;
            }
        }
        System.out.print(mod);
        for (int i = 0; i < 10; i++) {
            System.out.print("\t" + cols[i]);
        }
        System.out.println();
    }

    public Integer lookup(Integer key) {
        Integer res = null;
        try {
            res = this.data[key].code;
        } catch (NullPointerException e) {
        }
        return res;
    }

    public void bench_lookup() {
        long time_11115 = 0;
        long time_99499 = 0;
        for (int i = 0; i < 10_000; i++) {
            long t0 = System.nanoTime();
            lookup(11515);
            time_11115 += System.nanoTime() - t0;

            t0 = System.nanoTime();
            lookup(99499);
            time_99499 += System.nanoTime() - t0;
        }
        System.out.println("Lookup 115 15: " + time_11115 / 10000);
        System.out.println("Look up 994 95: " + time_99499 / 10000);
    }

}
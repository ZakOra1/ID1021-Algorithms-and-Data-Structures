import java.io.BufferedReader;
import java.io.FileReader;

public class Map {
    public City[] cities;
    private final int mod = 541;

    public Map(String file) {
        cities = new City[mod];
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] row = line.split(",");
                Integer time = Integer.valueOf(row[2]);
                City from = lookup(row[0]);
                City to = lookup(row[1]);
                from.add(to, time);
                to.add(from, time);
            }
        } catch (Exception e) {
            System.out.println(" file " + file + " not found or corrupt");
        }
    }

    public Integer hash(String name) {
        int hash = 7;
        for (int i = 0; i < name.length(); i++) {
            hash = (hash * 31 % mod) + name.charAt(i);
        }
        return (hash % mod);
    }

    public void connection(City from, City to, Integer time) {
        for(int i = 0; i < cities.length; i++) {
            if (cities[i].equals(from)) {
                cities[i].add(to, time);
            }
            if (cities[i].equals(to)) {
                cities[i].add(from, time);
            }
        }
    }

    public City lookup(String name) {
        City lookup_City = new City(name);
        Integer hash_value = hash(name);

        // Recive the hash-value and a free spot in the cities array
        for(int i = hash_value; i < cities.length; i++) {
            if(cities[i] == null) {
                cities[i] = lookup_City;
                return cities[i];
            }
            else if(name.equals(cities[i].name)) {
                return cities[i];
            }
        }

        return null;
    }
}

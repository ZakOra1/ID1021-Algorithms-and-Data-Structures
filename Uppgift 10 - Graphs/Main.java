/*
public class Main {
    public static void main(String[] args) {
        Map map = new Map("C:\\Users\\zaken\\OneDrive - KTH\\ID1021 - Algoritmer och datastrukturer\\Uppgift 10 - Graphs\\trains.csv");

        //City stockholm = map.lookup("Stockholm");
        //System.out.println(stockholm.name);
        //System.out.print(stockholm.connections.length);

        /*for(int i = 0; i < map.cities.length; i++) {
            if(map.cities[i] != null) {
                System.out.println(map.cities[i].name);
            }
        }



        String[] input = new String[4];
        int cities = 9;
        switch (cities) {
            case 0 -> {
                input[0] = "Malmö";
                input[1] = "Göteborg";
                input[2] = "153";
            }
            case 1 -> {
                input[0] = "Göteborg";
                input[1] = "Stockholm";
                input[2] = "500";
            }
            case 2 -> {
                input[0] = "Malmö";
                input[1] = "Stockholm";
                input[2] = "500";
            }
            case 3 -> {
                input[0] = "Stockholm";
                input[1] = "Sundsvall";
                input[2] = "500";
            }
            case 4 -> {
                input[0] = "Stockholm";
                input[1] = "Umeå";
                input[2] = "700";
            }
            case 5 -> {
                input[0] = "Göteborg";
                input[1] = "Sundsvall";
                input[2] = "600";
            }
            case 6 -> {
                input[0] = "Sundsvall";
                input[1] = "Umeå";
                input[2] = "1200";
            }
            case 8 -> {
                input[0] = "Umeå";
                input[1] = "Göteborg";
                input[2] = "1000";
            }
            case 9 -> {
                input[0] = "Göteborg";
                input[1] = "Umeå";
                input[2] = "600";
            }
            case 7 -> {
                input[0] = "Malmö";
                input[1] = "Kiruna";
                input[2] = "1200";
            }
            case 10 -> {
                input[0] = "Kiruna";
                input[1] = "Malmö";
                input[2] = "1200";
            }
        }

        String from = input[0];
        String to = input[1];
        Integer max = Integer.valueOf(input[2]);

        long t0 = System.nanoTime();
        Integer dist = shortest(map.lookup(from), map.lookup(to), max);
        long t1 = System.nanoTime();
        long tot = (t1 - t0) / 1000;

        if (dist != null) {
            System.out.println("Quickest route from " + from + " to " + to + " : " + dist + " minutes, found in " + tot + " µs");
        } else {
            System.out.println("No path found - Increase max");
        }
    }

    private static Integer shortest(City from, City to, Integer max) {
        if (max < 0) {
            return null;
        }
        if (from == to) {
            return 0;
        }

        //System.out.println("Max from " + from.name + " initial " + max);

        Integer shrt = null;
        for (int i = 0; i < from.connections.length; i++) {
            if (from.connections[i] != null) {
                City.Connections conn = from.connections[i];
                Integer time = shortest(conn.destination, to, max - conn.time);
                if ((time != null) && ((shrt == null) || (shrt > time + conn.time))) {
                    shrt = time + conn.time;
                }
                if ((shrt != null) && (max > shrt)) {
                    //System.out.println("Max from " + from.name + " set to " + shrt);
                    max = shrt;
                }
            }
        }
        return shrt;
    }


}
*/
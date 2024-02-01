public class Paths {

	City[] path;
	int sp;

	public Paths() {
		path = new City[54];
		sp = 0;
	}

	private Integer shortest(City from, City to, Integer max) {
		if ((max != null) && (max < 0)) {
			return null;
		}
		if (from == to) {
			System.out.println("found path");
			return 0;
		}

		for (int i = 0; i < sp; i++) {
			if (path[i] == from)
				return null;
		}

		path[sp++] = from;
		Integer shrt = null;
		for (int i = 0; i < from.connections.length; i++) {
			if (from.connections[i] != null) {
				City.Connections conn = from.connections[i];
				Integer dist = shortest(conn.destination, to, (max != null) ? max - conn.time : null);
				if ((dist != null) && ((shrt == null) || (shrt > dist + conn.time)))
					shrt = dist + conn.time;
				if ((shrt != null) && ((max == null) || (max > shrt))) {
					max = shrt;
				}
			}

		}
		path[sp--] = null;
		return shrt;
	}

	public static void main(String[] args) {

		String[] input = new String[4];
		int cities = 6;

		switch (cities) {
			case 0: {
				input[0] = "Stockholm";
				input[1] = "Umeå";
				input[2] = "520";
				break;
			}

			case 1: {
				input[0] = "Malmö";
				input[1] = "Stockholm";
				input[2] = "520";
				break;
			}
			case 2: {
				input[0] = "Malmö";
				input[1] = "Uppsala";
				input[2] = "520";
				break;
			}
			case 3: {
				input[0] = "Malmö";
				input[1] = "Gävle";
				input[2] = "520";
				break;
			}
			case 4: {
				input[0] = "Malmö";
				input[1] = "Sundsvall";
				input[2] = "520";
				break;
			}
			case 5: {
				input[0] = "Malmö";
				input[1] = "Umeå";
				input[2] = "520";
				break;
			}
			case 6: {
				input[0] = "Malmö";
				input[1] = "Linköping";
				input[2] = "520";
				break;
			}
			case 7: {
				input[0] = "Malmö";
				input[1] = "Katrineholm";
				input[2] = "520";
				break;
			}
			case 8: {
				input[0] = "Malmö";
				input[1] = "Södertälje";
				input[2] = "520";
				break;
			}

			case 9: {
				input[0] = "Göteborg";
				input[1] = "Umeå";
				input[2] = "1000";
				break;
			}

		}

		Map map = new Map("C:\\Users\\zaken\\OneDrive - KTH\\ID1021 - Algoritmer och datastrukturer\\Uppgift 10 - Graphs\\trains.csv");

		Paths pth = new Paths();
		String from = input[0];
		String to = input[1];

		long t0 = System.nanoTime();
		Integer dist = pth.shortest(map.lookup(from), map.lookup(to), null);
		long t1 = System.nanoTime();
		long total = (t1 - t0) / 1000;
		if (dist != null) {
			System.out.println("quickest rout from " + from + " to " + to + " : " + dist + " min found in " + total + " us ");
		} else {
			System.out.println("no path found- increase max");
		}
	}
}
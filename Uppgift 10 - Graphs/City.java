public class City {
    String name;
    Connections[] connections;

    public class Connections {
        City destination;
        Integer time;

        public Connections(City destination, Integer time) {
            this.destination = destination;
            this.time = time;
        }
    }

    public City(String name) {
        this.name = name;
    }

    public void add(City destination, Integer time) {
        if(connections == null) {
            connections = new Connections[1];
            connections[0] = new Connections(destination, time);
        }
        else {
            Connections[] newArr = new Connections[this.connections.length + 1];
            for(int i = 0; i < this.connections.length; i++) {
                newArr[i] = this.connections[i];
            }
            newArr[this.connections.length] = new Connections(destination, time);
            connections = newArr;
        }
    }




}

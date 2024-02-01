public class Main {
    public static void main(String[] args) {
        ZipString zipcode_String = new ZipString("C:/Users/zaken/OneDrive - KTH/ID1021 - Algoritmer och datastrukturer/Uppgift 9 - Hashtables/postnummer.csv");
        ZipInt zipcode_Int = new ZipInt("C:/Users/zaken/OneDrive - KTH/ID1021 - Algoritmer och datastrukturer/Uppgift 9 - Hashtables/postnummer.csv");
        ZipArr zipcode_Arr = new ZipArr("C:/Users/zaken/OneDrive - KTH/ID1021 - Algoritmer och datastrukturer/Uppgift 9 - Hashtables/postnummer.csv");
        ZipHash zipcode_Hash = new ZipHash("C:/Users/zaken/OneDrive - KTH/ID1021 - Algoritmer och datastrukturer/Uppgift 9 - Hashtables/postnummer.csv");

        zipcode_Hash.hash_Funct();
        //int depth = zipcode_Hash.lookup_betterHash(16453);
        //System.out.println(depth);
        System.out.println(zipcode_Hash.better_hash[9675]);
        
    }
}
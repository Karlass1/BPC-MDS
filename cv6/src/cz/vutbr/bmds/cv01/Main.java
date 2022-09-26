package cz.vutbr.bmds.cv01;

public class Main {
    public static void main(String[] args) {


        MapClass idk = new MapClass();

        try {
            idk.store(5, "Petka");
            idk.store(7, "Sedmicka");
            idk.store(10, "Desitka");

            System.out.println(idk.getValue(7));

            idk.deleteKey(5);

            idk.print();

        } catch (NoSuchFieldException e) {
            System.err.println("Chyba:" + e.getMessage());
        }
    }
}



import java.util.*;

public  class InformeSistema {

    public static void main(String[] args){
        System.out.println("PROCESADORES");
        System.out.println("--------------------");

        int procesadores = Runtime.getRuntime().availableProcessors();
        System.out.println("Disponibles JVM : "+ procesadores);

        System.out.println("\nMEMORIA · ANTES");
        System.out.println("--------------------");

        long memoria_total = Runtime.getRuntime().totalMemory();
        System.out.println("Total reservada: "+ memoria_total);
    }
}





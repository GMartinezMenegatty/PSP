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
        double memoriaMiB = (double) memoria_total / (1024 * 1024);
        System.out.println("Total reservada : "+ memoriaMiB + " MiB");


        long memoria_libre = Runtime.getRuntime().freeMemory();
        long memorialibreMiB = memoria_libre / (1024 * 1024);
        System.out.println("Libre : "+ memorialibreMiB + " MiB");


        double aMib = 1024 * 1024;
        double enUso = memoria_total * 0.5;
        System.out.println("En uso: " + (enUso / aMib) + " MiB");


        long memoria_maxima = Runtime.getRuntime().maxMemory();
        long memoriaMaximaMiB = memoria_maxima / (1024 * 1024);
        System.out.println("Máxima (-Xmx) : "+ memoriaMaximaMiB + " MiB");


        System.out.println("\nMEMORIA · DESPUÉS DE RESERVAR 64 MIB");
        System.out.println("--------------------");

        long[] reservado = new long[8 * 1024 * 1024];

        long memoria_total_reservada = Runtime.getRuntime().totalMemory();
        System.out.println("Total reservada: " + convertirMiB(memoria_total_reservada) + " MiB");

        long memoria_libre_reservada = Runtime.getRuntime().freeMemory();
        System.out.println("Libre: " + convertirMiB(memoria_libre_reservada) + " MiB");

        long memoria_maxima_reservada = Runtime.getRuntime().maxMemory();
        System.out.println("Máxima (-Xmx): " + convertirMiB(memoria_maxima_reservada) + " MiB");

        long memoria_uso_reservada = memoria_total_reservada - memoria_libre_reservada;
        System.out.println("En uso: " + convertirMiB(memoria_uso_reservada) + " MiB (" + calcularPorcentaje(memoria_uso_reservada, memoria_total_reservada) + " % de la total)");

        double incremento = memoria_uso_reservada - enUso;
        System.out.println("Incremento en uso: " + convertirMiB((long) incremento) + " MiB");

        System.out.println("(el array sigue en memoria: reservado[0] = " + reservado[0] + ")");

        System.out.println("\nSISTEMA");
        System.out.println("--------------------");

        String name = System.getProperty("os.name");
        System.out.println("os.name: " + name);

        String separator = System.getProperty("file.separator");
        System.out.println("file.separator: " + separator);

        String ruta = System.getProperty("user.dir");
        System.out.println("Ruta construida con las propiedades: " + ruta + separator + "InformeSistema.java");

        System.out.println("\nPROPIEDADES QUE EMPIEZAN POR os., user., java.version");
        System.out.println("--------------------");

        String javaVersion = System.getProperty("java.version");
        System.out.println("java.version: " + javaVersion);

        String javaVersionDate = System.getProperty("java.version.date");
        System.out.println("java.version.date: " + javaVersionDate);

        String osArch = System.getProperty("os.arch");
        System.out.println("os.arch: " + osArch);

        String osName = System.getProperty("os.name");
        System.out.println("os.name: " + osName);

        String osVersion = System.getProperty("os.version");
        System.out.println("os.version: " + osVersion);

        String userCountry = System.getProperty("user.country");
        System.out.println("user.country: " + userCountry);

        String userDir = System.getProperty("user.dir");
        System.out.println("user.dir: " + userDir);

        String userHome = System.getProperty("user.home");
        System.out.println("user.home: " + userHome);

        String userLanguage = System.getProperty("user.language");
        System.out.println("user.language: " + userLanguage);

        String userName = System.getProperty("user.name") ;
        System.out.println("user.name: " + userName);

        System.out.println("\nPROCESO EN ESPERA");
        System.out.println("--------------------");

        System.out.println("Buscame desde otra terminal con:");
        System.out.println("ps -ef | grep InformeSistema");

        System.out.println("Pulsa INTRO para terminar...");

        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();

        System.out.println("Fin del programa.");

        scanner.close();
    }

    public static long convertirMiB(long bytes) {
        return bytes / (1024 * 1024);
    }

    public static long calcularPorcentaje(long parte, long total) {
        if (total == 0) {
            return 0;
        }
        return (parte * 100) / total;
    }
}







import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Practica_23 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Mostrar información del equipo local
        try {
            InetAddress local = InetAddress.getLocalHost();

            System.out.println("Información del equipo local:");
            System.out.println("Nombre: " + local.getHostName());
            System.out.println("IP: " + local.getHostAddress());
        } catch (UnknownHostException e) {
            System.out.println("No se pudo obtener la información del equipo local.");
        }

        // Consultar dominios
        String externo;

        do {
            System.out.print("\nIntroduce un dominio (o 'salir'): ");
            externo = sc.nextLine();

            if (!externo.equalsIgnoreCase("salir")) {
                try {
                    InetAddress[] direcciones = InetAddress.getAllByName(externo);
                    System.out.println("\nDirecciones IP de " + externo + ":");

                    for (InetAddress direccion : direcciones) {

                        String ip = direccion.getHostAddress();

                        if (direccion.getAddress().length == 4) {
                            System.out.println("IPv4: " + ip);
                        } else {
                            System.out.println("IPv6: " + ip);
                        }
                    }
                } catch (UnknownHostException e) {
                    System.out.println("Error: el dominio no existe o no se pudo resolver.");
                }
            }
        } while (!externo.equalsIgnoreCase("salir"));
        System.out.println("\nPrograma finalizado.");
        sc.close();
    }
}

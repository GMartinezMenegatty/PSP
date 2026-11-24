import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Cliente_tcp {

    public static void main(String[] args) {

        try (Socket socket = new Socket("localhost", 8000);
             Scanner sc = new Scanner(System.in);

             BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));

             PrintWriter salida = new PrintWriter(socket.getOutputStream(), true)) {

            System.out.println("Conectado al servidor");
            System.out.println("Adivina un número entre 1 y 100");
            System.out.println("Escribe ADIOS para salir");

            while (true) {

                System.out.print("Introduce un número: ");
                String mensaje = sc.nextLine();

                // Enviar mensaje al servidor
                salida.println(mensaje);

                // Recibir respuesta
                String respuesta = entrada.readLine();

                if (respuesta == null) {
                    System.out.println("Servidor desconectado");
                    break;
                }

                System.out.println("Servidor: " + respuesta);

                if (mensaje.trim().equalsIgnoreCase("ADIOS")) {
                    break;
                }
            }

        } catch (IOException e) {
            System.out.println("No se pudo conectar con el servidor");
        }
    }
}
import java.net.DatagramSocket;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.SocketTimeoutException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Cliente {

    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in);
             DatagramSocket socket = new DatagramSocket()) {

            // Tiempo de espera 2 segundos
            socket.setSoTimeout(2000);

            InetAddress direccion = InetAddress.getByName("localhost");

            System.out.println("Introduce palabras separadas por comas:");

            String palabras = sc.nextLine();

            if (palabras.replace(",", "").trim().isEmpty()) {

                System.out.println("Debes introducir alguna palabra.");
                return;
            }

            byte[] datos = palabras.getBytes(StandardCharsets.UTF_8);

            DatagramPacket paquete = new DatagramPacket(datos, datos.length, direccion, 5555);

            boolean recibido = false;

            // Envío inicial y hasta 3 reintentos
            for (int intento = 1; intento <= 3; intento++) {

                try {

                    System.out.println("Intento " + intento);

                    socket.send(paquete);

                    byte[] buffer = new byte[1024];

                    DatagramPacket respuesta = new DatagramPacket(buffer, buffer.length);

                    socket.receive(respuesta);

                    String resultado = new String(respuesta.getData(), 0, respuesta.getLength(),
                            StandardCharsets.UTF_8);

                    String[] partes = resultado.split(",");

                    System.out.println("Palabra más larga: " + partes[0]);

                    System.out.println("Longitud: " + partes[1]);

                    recibido = true;
                    break;

                } catch (SocketTimeoutException e) {
                    System.out.println("Tiempo de espera agotado.");
                }
            }

            if (!recibido) {
                System.out.println("Servidor no disponible");
            }

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
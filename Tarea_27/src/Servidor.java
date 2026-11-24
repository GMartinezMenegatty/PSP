import java.net.DatagramSocket;
import java.net.DatagramPacket;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class Servidor {

    public static void main(String[] args) {

        try (DatagramSocket socket = new DatagramSocket(5555)) {

            while (true) {

                byte[] buffer = new byte[1024];

                DatagramPacket paquete = new DatagramPacket(buffer, buffer.length);

                // Recibir las palabras del cliente
                socket.receive(paquete);

                String mensaje = new String(
                        paquete.getData(), 0, paquete.getLength(), StandardCharsets.UTF_8);

                System.out.println("Recibido: " + mensaje);

                // Separar las palabras
                String[] palabras = mensaje.split(",");

                String palabraLarga = "";

                // Buscar la palabra más larga
                for (String palabra : palabras) {
                    palabra = palabra.trim();

                    if (palabra.length() > palabraLarga.length()) {
                        palabraLarga = palabra;
                    }
                }

                // Preparar la respuesta
                String respuesta = palabraLarga + "," + palabraLarga.length();

                byte[] datos = respuesta.getBytes(StandardCharsets.UTF_8);

                // Responder al cliente con la palabra más larga y su longitud
                DatagramPacket paqueteRespuesta =
                        new DatagramPacket(
                                datos,
                                datos.length,
                                paquete.getAddress(),
                                paquete.getPort());

                socket.send(paqueteRespuesta);

                System.out.println("Enviado: " + respuesta);
            }

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
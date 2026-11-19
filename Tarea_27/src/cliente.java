import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketTimeoutException;
import java.nio.charset.StandardCharsets;

public class cliente {
    public static void main(String[] args) throws IOException {

        try (DatagramSocket socket = new DatagramSocket()) { // puerto efímero
            socket.setSoTimeout(2000); // no esperar eternamente

            InetAddress servidor = InetAddress.getByName("localhost");

            byte[] datos = "Hola por UDP".getBytes(StandardCharsets.UTF_8);

            socket.send(new DatagramPacket(datos, datos.length, servidor, 5555));

            byte[] buffer = new byte[1024];

            DatagramPacket respuesta = new DatagramPacket(buffer, buffer.length);

            try {
                socket.receive(respuesta);
                System.out.println(new String(buffer, 0, respuesta.getLength(), StandardCharsets.UTF_8));

            } catch (SocketTimeoutException e) {
                System.out.println("Servidor no disponible");
            }
        }
    }
}

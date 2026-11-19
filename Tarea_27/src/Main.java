import java.io.IOException;
import java.net.*;
import java.nio.charset.StandardCharsets;

public class Main {
    public static void main(String[] args) throws IOException {

        try (DatagramSocket socket = new DatagramSocket(5555)) { // buzón en el 5555
            byte[] buffer = new byte[1024];

            while (true) {
                DatagramPacket recibido = new DatagramPacket(buffer, buffer.length);
                socket.receive(recibido); // BLOQUEA

                String texto = new String(recibido.getData(), 0,
                        recibido.getLength(), StandardCharsets.UTF_8); // ¡solo los bytes válidos!

                System.out.println(recibido.getAddress() + ":" + recibido.getPort() + " -> " + texto);
                byte[] resp = ("ECO: " + texto).getBytes(StandardCharsets.UTF_8);

                socket.send(new DatagramPacket(resp, resp.length,
                        recibido.getAddress(), recibido.getPort())); // respondo al remitente
            }
        }
    }
}





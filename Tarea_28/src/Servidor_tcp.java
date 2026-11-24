import java.io.*;
import java.net.*;
import java.util.Random;

public class Servidor_tcp {

    public static void main(String[] args) {

        try (ServerSocket servidor = new ServerSocket(8000)) {
            while (true) {

                try (Socket cliente = servidor.accept();
                     BufferedReader entrada = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
                     PrintWriter salida = new PrintWriter(cliente.getOutputStream(), true)) {

                    System.out.println("Cliente conectado");

                    Random random = new Random();
                    int numeroSecreto = random.nextInt(100) + 1;
                    int intentos = 0;

                    String mensaje;

                    while ((mensaje = entrada.readLine()) != null) {
                        mensaje = mensaje.trim();

                        if (mensaje.equalsIgnoreCase("ADIOS")) {
                            salida.println("OK Hasta luego");
                            break;
                        }

                        try {
                            int numero = Integer.parseInt(mensaje);

                            if (numero < 1 || numero > 100) {
                                salida.println("ERR Comando no válido");
                                continue;
                            }

                            intentos++;

                            if (numero < numeroSecreto) {
                                salida.println("MAYOR");

                            } else if (numero > numeroSecreto) {
                                salida.println("MENOR");

                            } else {
                                salida.println("ACIERTO en "
                                        + intentos + " intentos");
                            }

                        } catch (NumberFormatException e) {
                            salida.println("ERR Comando no válido");
                        }
                    }

                } catch (IOException e) {
                    System.out.println("Conexión con el cliente finalizada");
                }

                System.out.println("Cliente desconectado");
            }

        } catch (IOException e) {
            System.out.println("Error del servidor: " + e.getMessage());
        }
    }
}
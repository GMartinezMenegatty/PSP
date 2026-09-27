import java.io.*;
import java.math.BigInteger;

/*
A traves de 'factor' y un número recibido.
Mostramos la salida del 'factor' por consola.
 */

public class Lanzador {

    public static int nivel1 (String numero) throws IOException, InterruptedException{
        ProcessBuilder pb = new ProcessBuilder("factor", numero);

        // Unimos la salida normal y la salida de error
        pb.redirectErrorStream(true);

        Process proceso = pb.start();

        // Leemos toda la salida del proceso
        BufferedReader lector = new BufferedReader(
                new InputStreamReader(proceso.getInputStream())
        );

        String linea;

        while ((linea = lector.readLine()) != null) {
            System.out.println(linea);
        }

        // Esperamos a que termine el proceso
        int codigo = proceso.waitFor();

        return codigo;

    }

    public static int nivel2 (String numero) throws IOException,
            InterruptedException{
        ProcessBuilder pb = new ProcessBuilder("factor", numero);
        Process proceso = pb.start();

        // Hilo para leer la salida normal
        Thread hiloSalida = new Thread(() -> {

            try {
                BufferedReader lector = new BufferedReader(
                        new InputStreamReader(proceso.getInputStream())
                );

                String linea;

                while ((linea = lector.readLine()) != null) {
                    System.out.println("[OK] " + linea);
                }

            } catch (IOException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        });


        // Hilo para leer la salida de error
        Thread hiloError = new Thread(() -> {

            try {
                BufferedReader lector = new BufferedReader(
                        new InputStreamReader(proceso.getErrorStream())
                );

                String linea;

                while ((linea = lector.readLine()) != null) {
                    System.out.println("[ERROR] " + linea);
                }

            } catch (IOException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        });


        hiloSalida.start();
        hiloError.start();

        int codigo = proceso.waitFor();

        // Esperamos a que los dos hilos terminen
        hiloSalida.join();
        hiloError.join();

        return codigo;
    }

    public static int nivel3 (String numero) throws IOException,
            InterruptedException{
        ProcessBuilder pb = new ProcessBuilder("factor", numero);

        File ficheroSalida = new File("factor_output.log");
        File ficheroError = new File("factor_error.log");

        // Añadir al final del fichero sin borrar lo anterior
        pb.redirectOutput(ProcessBuilder.Redirect.appendTo(ficheroSalida));
        pb.redirectError(ProcessBuilder.Redirect.appendTo(ficheroError));

        Process proceso = pb.start();

        int codigo = proceso.waitFor();

        return codigo;
    }

    public static int nivel4 (String numero) throws IOException,
            InterruptedException{
        ProcessBuilder pb = new ProcessBuilder("factor", numero);

        Process proceso = pb.start();

        StringBuilder salida = new StringBuilder();

        // Leemos la salida normal
        BufferedReader lector = new BufferedReader(
                new InputStreamReader(proceso.getInputStream())
        );

        String linea;

        while ((linea = lector.readLine()) != null) {
            System.out.println(linea);
            salida.append(linea);
        }


        // Leemos la salida de error
        BufferedReader lectorError = new BufferedReader(
                new InputStreamReader(proceso.getErrorStream())
        );

        while ((linea = lectorError.readLine()) != null) {
            System.out.println(linea);
        }


        int codigo = proceso.waitFor();


        // Solo comprobamos si es primo si factor ha terminado correctamente
        if (codigo == 0) {

            try {

                BigInteger numeroBig = new BigInteger(numero);

                if (esPrimo(numeroBig)) {
                    System.out.println("¡" + numero + " es primo!");
                } else {
                    System.out.println(numero + " no es primo");
                }

            } catch (NumberFormatException e) {
                // No hacemos nada si no es un número válido
            }
        }

        return codigo;
    }
    public static boolean esPrimo(BigInteger numero) {

        if (numero.compareTo(BigInteger.ONE) <= 0) {
            return false;
        }

        return numero.isProbablePrime(100);
    }
}

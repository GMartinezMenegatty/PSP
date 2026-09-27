import java.util.Scanner;

public class Interfaz {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("¿Qué nivel quieres usar? (1, 2, 3 o 4): ");
        String opcion = scanner.nextLine();

        if (opcion.equals("1")) {

            System.out.print("Introduce un número (o 'salir' para terminar): ");
            String numero = scanner.nextLine();

            try {
                Lanzador.nivel1(numero);
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }

        }

        if (opcion.equals("2")) {

            System.out.print("Introduce un número (o 'salir' para terminar): ");
            String numero = scanner.nextLine();

            try {
                Lanzador.nivel2(numero);
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }

        }

        if (opcion.equals("3")) {

            System.out.print("Introduce un número (o 'salir' para terminar): ");
            String numero = scanner.nextLine();

            try {
                Lanzador.nivel3(numero);
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }

        }

        if (opcion.equals("4")) {

            System.out.print("Introduce un número (o 'salir' para terminar): ");
            String numero = scanner.nextLine();

            try {
                Lanzador.nivel4(numero);
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }

        }

        scanner.close();
    }
}
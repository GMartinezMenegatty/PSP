/*

 */

import java.io.IOException;
import java.util.*;
public class Interfaz {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("¿Qué nivel quieres usar? (1, 2, 3 o 4): ");
            String input = scanner.nextLine();

            if (input.equals("1")) {
                System.out.print("Introduce un número (o 'salir' para terminar): ");
                scanner.nextLine();
                Lanzador.nivel1();
            }
            if (input.equals("2")) {
                System.out.print("Introduce un número (o 'salir' para terminar): ");
                scanner.nextLine();
                Lanzador.nivel2();
            }
            if (input.equals("3")) {
                System.out.print("Introduce un número (o 'salir' para terminar): ");
                scanner.nextLine();
                Lanzador.nivel3();
            }
            if (input.equals("4")) {
                System.out.print("Introduce un número (o 'salir' para terminar): ");
                scanner.nextLine();
                Lanzador.nivel4();
            }
        }
    }
}
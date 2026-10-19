//Escribe un programa que pida por teclado 5 consonantes y un texto.
// Cada consonante tendrá un hilo que cuenta cuántas veces aparece
// una de las consonantes y suma sus apariciones a un contador total compartido.
// Al final se muestra lo que ha contado cada hilo y el total.

//Para que se note el problema, repite el texto 2.000 veces: texto.repeat(2000).
import java.util.*;

/*
Clase que contiene la lógica de Consonantes.
 */

class Consonantes extends Thread{
    String consonante;
    String texto;
    ContadorTotal contadorTotal;
    int cantidad = 0;

    public Consonantes(String consonante, String texto, ContadorTotal contadorTotal) {
        this.consonante = consonante;
        this.texto = texto;
        this.contadorTotal = contadorTotal;
    }

    /*
    Método que cuenta las consonantes en el texto proporcionado
     */

    @Override
    public void run() {
        for (int i = 0; i < texto.length(); i++) {
            if (Character.toLowerCase(texto.charAt(i)) ==
                    Character.toLowerCase(consonante.charAt(0))) {
                cantidad++;
            }
        }

        contadorTotal.sumar(cantidad);

        System.out.println("La consonante " + consonante + " aparece " + cantidad + " veces.");
    }
}

/*
Clase que inicializa el Texto
 */

class Texto{
    String texto;
}

/*
Clase que crea el Contador y lo va aumentando
 */

class ContadorTotal {
    private int Total = 0;

    public synchronized void sumar(int cantidad) {
        Total += cantidad;
    }

    public int getTotal() {
        return Total;
    }
}


public class Tarea17 {
    public static void main(String[] args) {
        /*
        Pedimos las 5 consonantes
         */
        Scanner sc = new Scanner(System.in);

        String[] consonantes = new String[5];

        for (int i = 0; i < 5; i++) {
            System.out.print("Introduce la consonante " + (i + 1) + ": ");

            String letra = sc.nextLine();

            /*
            Comprobamos que sean Consonantes
             */

            if (letra.length() == 1 && Character.isLetter(letra.charAt(0)) && !"aeiouAEIOU".contains(letra)) {
                consonantes[i] = String.valueOf(letra.charAt(0));

            } else {
                System.out.println("Introduce una consonante.");
                i--;
            }
        }

        /*
        Pedimos el texto y lo repetimos 2000 veces
         */
        System.out.print("Introduce el texto: ");
        Texto texto = new Texto();
        texto.texto = sc.nextLine().repeat(2000);

        ContadorTotal contadorTotal = new ContadorTotal();

        Consonantes[] consonante = new Consonantes[5];

        /*
        Iniciamos el Contador y Consonantes
         */
        for (int i = 0; i < 5; i++) {
            consonante[i] = new Consonantes(consonantes[i], texto.texto, contadorTotal);
            consonante[i].start();
        }

        for (int i = 0; i < 5; i++) {
            try {
                consonante[i].join();
            } catch (InterruptedException e) {
                System.out.println("El hilo principal ha sido interrumpido.");
                Thread.currentThread().interrupt();
                return;
            }
        }

        /*
        Mostramos el total de repeticiones de consonantes
         */

        System.out.println("El total de apariciones es: " + contadorTotal.getTotal());
        sc.close();
    }
}





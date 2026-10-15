//Escribe un programa que pida por teclado 5 consonantes y un texto.
// Cada consonante tendrá un hilo que cuenta cuántas veces aparece
// una de las consonantes y suma sus apariciones a un contador total compartido.
// Al final se muestra lo que ha contado cada hilo y el total.

//Para que se note el problema, repite el texto 2.000 veces: texto.repeat(2000).
import java.util.*;

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

class Texto{
    String texto;
}

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

        Scanner sc = new Scanner(System.in);

        String[] consonantes = new String[5];

        for (int i = 0; i < 5; i++) {
            System.out.print("Introduce la consonante " + (i + 1) + ": ");
            consonantes[i] = sc.nextLine();
        }

        System.out.print("Introduce el texto: ");
        Texto texto = new Texto();
        texto.texto = sc.nextLine().repeat(2000);


        ContadorTotal contadorTotal = new ContadorTotal();

        Consonantes[] consonante = new Consonantes[5];

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

        System.out.println("El total de apariciones es: " + contadorTotal.getTotal());
        sc.close();
    }
}





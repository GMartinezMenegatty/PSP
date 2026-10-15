//Escribe un programa que pida por teclado 5 consonantes y un texto.
// Cada consonante tendrá un hilo que cuenta cuántas veces aparece
// una de las consonantes y suma sus apariciones a un contador total compartido.
// Al final se muestra lo que ha contado cada hilo y el total.

//Para que se note el problema, repite el texto 2.000 veces: texto.repeat(2000).
import java.util.*;

class Consonantes{
    String consonante;
}

class Texto{
    String texto;
}

class ContadorTotal{

}


public class Tarea17 {
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        Consonantes[] consonantes = new Consonantes[5];
        for (int i = 0; i < 5; i++) {
            consonantes[i] = new Consonantes();
            System.out.print("Introduce la consonante " + (i + 1) + ": ");
            consonantes[i].consonante = sc.nextLine();
        }
        System.out.print("Introduce el texto: ");
        Texto texto = new Texto();
        texto.texto = sc.nextLine().repeat(2000);

        ContadorTotal contadorTotal = new ContadorTotal();



        System.out.println("El total de apariciones es: " + contadorTotal);
    }
}





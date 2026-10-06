/**
 * Gestiona las descargas de los archivos a traves de hilos.
 * Con tiempos reales de cada descarga.
 */

public class GestorDescarga {

    public static void main(String[] args) {

        Descarga cuarzos = new Descarga("cuarzos.png");
        Descarga meditacion = new Descarga("meditacion.mp4");
        Descarga mantras = new Descarga("mantras.mp3");
        Descarga horoscopo = new Descarga("horoscopo.pdf");

        Instalador instalador = new Instalador(meditacion, mantras);
        Thread hiloInstalador = new Thread(instalador);

        hiloInstalador.start();

        cuarzos.setName("Descarga-cuarzos.png");
        meditacion.setName("Descarga-meditacion.mp4");
        mantras.setName("Descarga-mantras.mp3");
        horoscopo.setName("Descarga-horoscopo.pdf");

        long inicio = System.currentTimeMillis();

        // Primero iniciamos todas las descargas
        cuarzos.start();
        meditacion.start();
        mantras.start();
        horoscopo.start();

        // Esperamos y comprobamos 3 segundos por meditacion

        try {
            meditacion.join(3000);

            if(meditacion.isAlive()) {
                System.out.println("[Main] meditacion.mp4 sigue en segundo plano");
            }
        }catch (InterruptedException e){
            System.out.println("Error.");
        }

        // Después esperamos a que todas terminen
        try {
            cuarzos.join();
            meditacion.join();
            mantras.join();
            horoscopo.join();

        } catch (InterruptedException e) {
            System.out.println("Error.");
        }

        long tiempoReal = System.currentTimeMillis() - inicio;

        // Calculamos el tiempo total

        long acumuladoTotal =
                cuarzos.getTiempoTotal()
                        + meditacion.getTiempoTotal()
                        + mantras.getTiempoTotal()
                        + horoscopo.getTiempoTotal();

        System.out.println("-------------");
        System.out.println("Todas las descargas han terminado.");
        System.out.println("Tiempo real: " + tiempoReal + " ms");
        System.out.println("Si se hubieran descargado una detrás de otra: " + acumuladoTotal + " ms");
    }
}

/**
 * Programa que "descarga" 4 archivos mediante hilos.
 * 10 bloques.
 */

public class Descarga extends Thread{

    private String nombre;
    private int tiempoBloque;
    private long tiempoTotal;

    /**
     * Constructor.
     * @param nombre nombre del hilo que se va a descargar.
     */

    public Descarga(String nombre) {
        this.nombre = nombre;
        this.tiempoBloque = (int) (Math.random() * 401) + 100;
    }

    /**
     * Programa principal que crea la descarga de los hilos.
     * Con 10 repeticiones.
     * Muestra el porcentaje total de la descarga.
     */

    @Override
    public void run() {

        long inicio = System.currentTimeMillis();

        for (int i = 1; i <= 10; i++) {
            try {
                Thread.sleep(tiempoBloque);
            } catch (InterruptedException e) {
                System.out.println("Error con: " + nombre);
            }

            System.out.println("[" + nombre + "] " + (i * 10) + "%");
        }

        tiempoTotal = System.currentTimeMillis() - inicio;

        System.out.println("[" + nombre + "] completada en " + tiempoTotal + " ms");
    }

    /**
     * Muestra el tiempo total de la descarga.
     * @return tiempo total en milisegundos.
     */

    public long getTiempoTotal() {
        return tiempoTotal;
    }
}

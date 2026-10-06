public class Instalador implements Runnable {

    private final Descarga meditacion;
    private final Descarga mantras;

    public Instalador(Descarga meditacion, Descarga mantras) {
        this.meditacion = meditacion;
        this.mantras = mantras;
    }

    @Override
    public void run() {

        try {
            meditacion.join();
            mantras.join();

            System.out.println("[Instalador] Meditación y mantras listos: instalando...");
            System.out.println("[Instalador] Instalación terminada");
        }
        catch (InterruptedException e) {
            System.out.println("Error.");
        }
    }
}

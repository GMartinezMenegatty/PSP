public class ExamenHilo {

    public static void main(String[] args) {
        Thread h1 = new Thread(new MiTarea(), "Hilo-A");
        Thread h2 = new Thread(new MiTarea(), "Hilo-B");

        h1.run();
        h2.run();

        System.out.println("Fin del main");
    }

    static class MiTarea implements Runnable {

        public void run() {
            System.out.println("Ejecutando: " + Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            }catch (InterruptedException e){}
        }
    }
}

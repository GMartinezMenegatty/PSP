public class Neumaticos extends Thread {

    @Override
    public void run() {
        System.out.println("Comenzando cambio de " + getName());
        System.out.println("Terminado cambio de " + getName());
    }
}

void main() {
    Neumaticos rueda1 = new Neumaticos();
    Neumaticos rueda2 = new Neumaticos();
    Neumaticos rueda3 = new Neumaticos();
    Neumaticos rueda4 = new Neumaticos();

    rueda1.setName("Rueda Delantera Derecha");
    rueda2.setName("Rueda Delantera Izquierda");
    rueda3.setName("Rueda Trasera Derecha");
    rueda4.setName("Rueda Trasera Izquierda");

    rueda1.start();
    rueda2.start();
    rueda3.start();
    rueda4.start();

    try {
        Thread.sleep(1000);

        rueda1.join();
        rueda2.join();
        rueda3.join();
        rueda4.join();

        System.out.println("¡Coche listo! ¡SAL, SAL, SAL!");
    }catch (Exception e){
        System.out.println("Error");
    }

}


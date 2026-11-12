import java.util.concurrent.Semaphore;

public class Coche extends Thread{
    private final Semaphore plazas;

    public Coche (String nombre, Semaphore plazas){
        super(nombre);
        this.plazas = plazas;
    }

    @Override
    public void run(){
        try {
            plazas.acquire();
            try {
                System.out.println(getName() + " aparca");
                Thread.sleep(1000);
            }finally {
                plazas.release();
            }
        } catch (InterruptedException e) { }
    }

    public static void main(String[] args){
        Semaphore plazas = new Semaphore(3);
    }
}

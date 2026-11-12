public class hilos extends Thread{

    @Override
    public void run (){
        for(int i=1; i < 9; i++) {
            System.out.println("Soy el " + getName() + " - iteracion: " + i);
        }
    }

}
public void main (String[] args) {

    hilos h1 = new hilos();
    hilos h2 = new hilos();
    hilos h3 = new hilos();

    h1.setName("Hilo 1");
    h2.setName("Hilo 2");
    h3.setName("Hilo 3");

    try {
        h3.start();
        h3.join();
        h2.start();
        h2.join();
        h1.start();
        h1.join();


    }catch (InterruptedException e){
        System.out.println("Error");
    }


}
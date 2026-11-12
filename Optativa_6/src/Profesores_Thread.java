public class Profesores_Thread extends Thread{

    public Profesores_Thread (String str, String limite) {
        super(str);
    }

    @Override
    public void run() {
        for (int i = 1; i < 6; i++) {
            System.out.println(getName() + " Cabreo Nivel: " + i);
        }
    }
    public static void main (String [] args) {
        new Profesores_Thread("[Manuel]", "¡He llegado a mi limite!").start();
        new Profesores_Thread("[Diego]", "¡He llegado a mi limite!").start();
        new Profesores_Thread("[Araujo]", "¡He llegado a mi limite!").start();
        new Profesores_Thread("[Damian]", "¡He llegado a mi limite!").start();
    }
}

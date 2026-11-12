public class ContarVocales extends Thread{
    private String texto;
    private int total;

    public ContarVocales (String texto, int total){
        this.texto = texto;
        this.total = total;
    }

    @Override
    public void run(){
        for (int i=0; i<texto.length(); i++) {

        }
    }
}

class Total extends Thread{
    private int total;

    public Total(){
        this.total = total;
    }

    public int getTotal(){
        return total;
    }
}

void main (String[] args) {

    System.out.println("Introduce un texto: ");
    Scanner cadena = new Scanner(System.in);
    cadena.nextLine();

    Total total = new Total();

//    ContarVocales vocal1 = new ContarVocales();
//    ContarVocales vocal2 = new ContarVocales();
//    ContarVocales vocal3 = new ContarVocales();
//    ContarVocales vocal4 = new ContarVocales();
//    ContarVocales vocal5 = new ContarVocales();

    System.out.println("Total de vocales encontradas: " + total.getTotal());
    System.out.println("Programa finalizado.");


}


public class Main {

    public static void main (String[] args){
        Barbeiro primeiroBarbeiro = new Barbeiro("Bruno", 3, 8); //nome do barbeiro, cadeira de espera e maximo de clientes aguardando

        Thread threadPrimeiroBarbeiro = new Thread(primeiroBarbeiro);

        threadPrimeiroBarbeiro.start();
    }

}

import java.util.Random;

public class Barbeiro implements Runnable {

    private int cadeiraEspera;  //define quantas cadeiras podem ser ocupadas por clientes aguardando para atendimento
    private int novosClientes;  //gera um random ate numero maximo de clientes
    private String nome;        //nome da thread
    boolean cadeiraOcupada = false;//true = ocupada e false = livre
    boolean barbeiroDorme;      //true = dorme e false = atende
    int[] clientes;             //numero de clientes
    int nClientes;              //inicializa a variavel total de clientes

   //Metodo que recebe parametros para inicializar o Barbeiro
   Barbeiro(String nome, int cadeiraEspera, int clientes) {
       novosClientes = clientes;//inicializa o maximo random de clientes
       this.nome = nome;//nome do barbeiro
       this.cadeiraEspera = cadeiraEspera;//inicializa o total de cadeira em espera]
       System.out.println("Barbeiro " +nome+ " chegou no salão");
   }

   //Metodo que gera clientes aleatoriamente e cria o vetor de clientes
    public void Clientes() {
       Random r = new Random(); //Gera um numero aleatorio de clientes
       nClientes = r.nextInt(novosClientes);// gera o total de clientes randomicos
       clientes = new int [nClientes];//define o tamando do vetor clientes

       for (int i = 0; nClientes < clientes.length; i++) {
           clientes[i] = i;
       }
   }

   //Metodo que se nao existe clientes, barbeiro espera
   public void BarbeiroDorme() throws InterruptedException {
       System.out.println("Não existe(m) cliente(s) no salão do Barbeiro " +nome+ ".");
       System.out.println("Barbeiro " +nome+ " está esperando clientes chegarem.");
       Thread.sleep(2000);
       System.out.println("A cadeira do Barbeiro " +nome+ " está livre.");
       //chama o metodo que cria clientes
       Clientes();
   }

   //Metodo que atende os clientes que estao na barbearia
    public void BarbeiroAtende() throws InterruptedException {
       if (nClientes !=0) {
           if(nClientes > 1 && cadeiraOcupada == false) {
               System.out.println("Entrou " +nClientes+ " cliente(s) no salão.");
           } else {
               System.out.println("Existe " +nClientes+ " cliente(s) esperando atendimento, " +nome);
           }
           System.out.println("Um cliente ocupou a cadeira do Barbeiro " +nome);
           nClientes --;
           System.out.println("Um cliente esta sendo atendido pelo Barbeiro " +nome);
           cadeiraOcupada = true;

           Thread.sleep(1000);

           if (nClientes > cadeiraEspera) {
               int cli = nClientes - cadeiraEspera;
               nClientes = nClientes - cli;

               for (int i = 0; i < clientes.length; i++) {
                   clientes[i] = 0;
               }

               for (int j = 0; j < nClientes; j++) {
                   clientes[j] = j + 1;
               }

               System.out.println(cli + " clientes foram embora");
               System.out.println(nClientes + "clientes estão esperando");
           }

           System.out.println("Um cliente já foi atendido pelo Barbeiro" +nome);
       } else if (nClientes == 1) {
           System.out.println("A cadeira do barbeiro esta livre");
           System.out.println("A cadeira do barbeiro esta ocupada, nao existem clientes esperando");

           Thread.sleep(1000);
           nClientes--;

           System.out.println("Um cliente ja foi atendido");
       } else {
           System.out.println("A cadeira do barbeiro esta livre");
            cadeiraOcupada = false;
       }
    }

    @Override
    public void run() {
       while (true) {
           if (nClientes <=0 ){
               try{
                   BarbeiroDorme();
               } catch (InterruptedException ex) {
                   System.out.println(ex);
               }
           } else {
               try{
                   BarbeiroAtende();
               } catch (InterruptedException ex) {
                   System.out.println(ex);
               }
           }
       }

    }
}
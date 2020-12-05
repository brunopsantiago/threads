public class MinhaThread extends Thread{

    private int id, valor, tempo;

    public MinhaThread(int id, int valor, int tempo) {
        this.id=id;
        this.valor=valor;
        this.tempo=tempo;
    }

    public void run(){
        try {
            for (int i=0; i<valor; i++){
                int cont = 0;

                System.out.println("Thread id: "+id+" valor: "+i);cont = i;
                System.out.println("Contador atualizado: "+cont);

            }
        }
        catch (Exception e){
            System.out.println("Erro encontrado método run: "+e.getMessage());
        }
    }
}

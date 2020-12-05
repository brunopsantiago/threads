public class MinhaThreadTest {
    public static void main(String args[]){

        try{
            MinhaThread t1, t2;

            t1 = new MinhaThread(1, 10, 100);
            t2 = new MinhaThread(2, 10, 400);

            t1.start();
            t2.start();

            System.out.println("Fim execução Threads");

        }catch (Exception e){
            System.out.println("Error encontrado método main: "+e.getMessage());
        }
    }
}

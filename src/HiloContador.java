import java.util.concurrent.Semaphore;

public class HiloImpar extends Thread {
    public static int cont;
    public static int contTotal = 0;
    private Semaphore semaphore;

    public HiloImpar(String name, Semaphore semaphore) {
        super(name);
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        try {
            semaphore.acquire();
            cont = 0;
            String impar = "impar";
            String par = "par";
            for (int n : Main.numeros) {
                if (n % 2 == 1 && this.getName().equalsIgnoreCase(impar)) {
                    cont++;
                    contTotal++;
                }
                if (n % 2 == 0 && this.getName().equalsIgnoreCase(par)) {
                    cont++;
                    contTotal++;
                }

            }
            System.out.println("Soy " + this.getName() + ", tengo " + cont + " números.");
            semaphore.release();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}

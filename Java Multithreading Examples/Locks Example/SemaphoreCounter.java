import java.util.concurrent.Semaphore;

public class SemaphoreCounter extends Counter {

    Semaphore mutex = new Semaphore(1);

    public void incrementCount() {
        try {
            mutex.acquire();
            count++;
        } catch (Exception e) {
            System.out.println(e.toString());
        } finally {
            mutex.release();
        }
    }
}
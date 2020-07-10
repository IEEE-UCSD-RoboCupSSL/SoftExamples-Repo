import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockCounter extends Counter {

    ReentrantLock mutex = new ReentrantLock();

    public void incrementCount() {
        try {
            mutex.lock();
            count++;
        } finally {
            mutex.unlock();
        }
    }
}
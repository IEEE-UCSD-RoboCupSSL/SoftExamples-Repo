public class SynchronizedCounter extends Counter {
    public synchronized void incrementCount() {
        count++;
    }
}
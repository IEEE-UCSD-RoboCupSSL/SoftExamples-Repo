public class Main {
    public static void main(String[] args) {
        UnsynchronizedCounter unsynchronizedCounter = new UnsynchronizedCounter();
        SynchronizedCounter synchronizedCounter = new SynchronizedCounter();
        ReentrantLockCounter reentrantLockCounter = new ReentrantLockCounter();
        SemaphoreCounter semaphoreCounter = new SemaphoreCounter();

        System.out.println("Unsynchronized Counter:");
        testCounter(unsynchronizedCounter);

        System.out.println("Synchronized Counter:");
        testCounter(synchronizedCounter);

        System.out.println("ReenrantLock Counter:");
        testCounter(reentrantLockCounter);

        System.out.println("Semaphore Counter:");
        testCounter(semaphoreCounter);
    }

    public static void testCounter(Counter counter) {
        int threads = 1000;
        int iterations = 1000;
        for (int i = 0; i < threads; i++) {
            Incrementor incrementor = new Incrementor(counter, iterations, "incrementor " + i);
            incrementor.start();
        }
        System.out.println("expected: " + threads * iterations);
        System.out.println("actual: " + counter.getCount());
        System.out.println("-----");
    }
}
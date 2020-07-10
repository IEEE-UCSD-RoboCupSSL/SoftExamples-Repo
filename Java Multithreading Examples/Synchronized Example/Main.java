public class Main {
    public static void main(String[] args) {
        int threads = 1000;
        int iterations = 1000;

        System.out.println("Unsynchronized Counter:");
        UnsynchronizedCounter unsynchronizedCounter = new UnsynchronizedCounter();
        for (int i = 0; i < threads; i++) {
            Incrementor incrementor = new Incrementor(unsynchronizedCounter, iterations, "incrementor " + i);
            incrementor.start();
        }
        System.out.println("expected: " + threads * iterations);
        System.out.println("actual: " + unsynchronizedCounter.getCount());

        System.out.println("-----");
        System.out.println("Synchronized Counter:");
        SynchronizedCounter synchronizedCounter = new SynchronizedCounter();
        for (int i = 0; i < threads; i++) {
            Incrementor incrementor = new Incrementor(synchronizedCounter, iterations, "incrementor " + i);
            incrementor.start();
        }
        System.out.println("expected: " + threads * iterations);
        System.out.println("actual: " + synchronizedCounter.getCount());
    }
}

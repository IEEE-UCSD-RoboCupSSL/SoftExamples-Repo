public class Incrementor extends Thread {
    Counter counter;
    int iterations;

    public Incrementor(Counter counter, int iterations, String name) {
        super(name);
        this.counter = counter;
        this.iterations = iterations;
    }

    public void run() {
        try {
            for (int i = 0; i < iterations; i++) {
                counter.incrementCount();
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

}
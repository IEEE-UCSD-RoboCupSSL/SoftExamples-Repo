public class MyRunnable implements Runnable {
    int time;

    public MyRunnable(int time) {
        this.time = time;
    }

    @Override
    public void run() {
        try {
            System.out.println("Thread " + Thread.currentThread().getId() + " runnning.");
            Thread.sleep(time);
            System.out.println("Thread " + Thread.currentThread().getId() + " finishing.");
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}
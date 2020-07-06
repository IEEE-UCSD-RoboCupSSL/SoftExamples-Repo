public class MyThread extends Thread {
    int time; 

    public MyThread(int time) {
        super();
        this.time = time;
    }

    public void run() {
        try {
            System.out.println("Thread " + currentThread().getId() + " runnning.");
            sleep(time);
            System.out.println("Thread " + currentThread().getId() + " finishing.");
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}
public class MyThread extends Thread {
    int time; 

    public MyThread(int time) {
        super(Integer.toString(time));
        this.time = time;
    }

    public void run() {
        try {
            System.out.println("Thread " + currentThread().getName() + " runnning.");
            sleep(time);
            System.out.println("Thread " + currentThread().getName() + " finishing.");
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}
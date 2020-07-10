import java.util.TimerTask;

public class CountingTask extends TimerTask {
    int count = 0;
    public void run() {
        System.out.println("Count: " + count);
        count++;
    }
}
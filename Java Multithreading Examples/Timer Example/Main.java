import java.util.Timer;

public class Main {
    public static void main(String[] args) {
        Timer timer = new Timer();
        CountingTask countingTask = new CountingTask();
        timer.schedule(countingTask, 0, 1000);
    }
}
/* Start 10 threads. Each thread runs for somewhere between 0 and 9 seconds.
*/

public class Main {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            MyThread thread = new MyThread(i * 1000);
            thread.start();
        }
    }
}
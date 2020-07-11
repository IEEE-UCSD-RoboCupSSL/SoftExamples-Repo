import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// https://baptiste-wicht.com/posts/2010/09/java-concurrency-part-5-monitors-locks-and-conditions.html

public class BoundedBuffer {
    private final String[] buffer;
    private final int capacity;

    private int front;
    private int rear;
    private int count;

    private final Lock lock = new ReentrantLock();

    private final Condition notFull = lock.newCondition();
    private final Condition notEmpty = lock.newCondition();

    public BoundedBuffer(int capacity) {
        super();

        this.capacity = capacity;

        buffer = new String[capacity];
    }

    public void deposit(String data) throws InterruptedException {
        // lock to ensure that multiple threads aren't running deposit at the same time
        lock.lock();

        try {
            // if the buffer is already full, we just wait until it's no longer full and continue
            while (count == capacity) {
                notFull.await();
            }

            // if the buffer is not full, add the data to the rear of the buffer
            buffer[rear] = data;
            rear = (rear + 1) % capacity;
            count++;

            // since there's data in the buffer, we notify threads that were waiting to fetch that there's data in the buffer
            notEmpty.signal();
        } finally {
            // unlock to allow other threads to deposit
            lock.unlock();
        }
    }

    public String fetch() throws InterruptedException {
        // lock to ensure that multiple threads aren't running fetch at the same time
        lock.lock();

        try {
            // if there's nothing in the buffer, wait until there's something in the buffer before continuing 
            while (count == 0) {
                notEmpty.await();
            }

            // if the buffer is  not empty, remove data from the front of the buffer
            String result = buffer[front];
            front = (front + 1) % capacity;
            count--;

            // since we just removed data from the buffer, it's no longer full. notify other threads that were trying to deposit that they can now get data
            notFull.signal();

            return result;
        } finally {
            // unlock to allow other threads to fetch
            lock.unlock();
        }
    }
}
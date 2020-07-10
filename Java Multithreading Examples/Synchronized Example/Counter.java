public abstract class Counter {
    int count = 0;

    public abstract void incrementCount();

    public int getCount() {
        return count;
    }
}
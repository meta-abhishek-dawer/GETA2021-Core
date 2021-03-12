package Assignment3;

public interface PriorityQueueInterface {
    public void insert(String job, int priority);
    public Bowler remove();
    public boolean isEmpty();
    public int size();
    public boolean isFull();
}

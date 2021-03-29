package Assignment3;

/**
 * Interface declaring methods of queue
 * @author abhishek.dawer_metac
 *
 */
public interface PriorityQueueInterface {
    public void insert(String job, int priority);
    public Bowler remove();
    public boolean isEmpty();
    public int size();
    public boolean isFull();
}

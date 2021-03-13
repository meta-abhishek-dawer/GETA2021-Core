package DSA_Assignment2;

/**
 * Interface of queue in which we declare different methods
 * @author abhishek.dawer_metac
 *
 */
public interface QueueInterface {
    public void enQueue(int value);
    public int deQueue();
    public boolean isEmpty();
    public boolean isFull();
}

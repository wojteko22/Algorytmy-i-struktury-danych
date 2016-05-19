package lista3;

/**
 * @author Wojciech Okoński
 *         created on 02.04.2016 r.
 */

public interface Queue {

    void enqueue(Object value);

    Object dequeue() throws EmptyQueueException;

    void clear();

    int size();

    boolean isEmpty();
}

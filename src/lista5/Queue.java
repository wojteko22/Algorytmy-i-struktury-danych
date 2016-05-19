package lista5;

import lista3.EmptyQueueException;

/**
 * @author Wojciech Okoński
 *         created on 02.04.2016 r.
 */

public interface Queue<T> {

    void enqueue(T value);

    T dequeue() throws EmptyQueueException;

    void clear();

    int size();

    boolean isEmpty();
}

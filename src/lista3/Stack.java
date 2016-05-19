package lista3;

public interface Stack extends Queue {

    void push(Object value);

    Object pop() throws EmptyStackException;

    Object peek() throws EmptyStackException;

    void clear();

    int size();

    boolean isEmpty();
}

package lista1;

public interface Iterator {
    void previous();

    void next();

    void first();

    void last();

    boolean isDone();

    Object current() throws IteratorOutOfBoundsException;
}

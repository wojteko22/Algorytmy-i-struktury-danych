package lista1;

/**
 * @author Wojciech Okoński
 *         created on 11.03.2016 r.
 */
public class ArrayIterator1 implements Iterator {
    private final int[] array;
    private final int first;
    private final int last;
    private int current = -1;

    public ArrayIterator1(int[] array) {
        assert array != null : "nie określono tablicy";
        this.array = array;
        first = 0;
        last = array.length - 1;
    }

    @Override
    public void previous() {
        current -= 20;
    }

    @Override
    public void next() {
        current += 20;
    }

    @Override
    public void first() {
        current = first;
    }

    @Override
    public void last() {
        current = last;
    }

    @Override
    public boolean isDone() {
        return current < first || current > last;
    }

    @Override
    public Object current() {
        if (isDone()) throw new IteratorOutOfBoundsException();
        return array[current];
    }
}

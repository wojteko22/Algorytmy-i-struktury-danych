package lista1;

public class FilterIterator2 implements Iterator {
    private final int[] array;
    private final int first;
    private final int last;
    private int current = -1;
    private final Predicate pred;

    public FilterIterator2(int[] array, Predicate pred) {
        assert array != null : "nie określono tablicy";
        assert pred != null : "nie określono predykatora";
        this.array = array;
        first = 0;
        last = array.length - 1;
        this.pred = pred;
    }

    public void filterForwards() {
        while (!isDone() && !pred.accept(current())) next();
    }

    public void filterBackwards() {
        while (!isDone() && !pred.accept(current())) previous();
    }

    public void first() {
        current = first;
        filterForwards();
    }

    public void last() {
        current = last;
        filterBackwards();
    }

    public void next() {
        ++current;
        filterForwards();
    }

    public void previous() {
        --current;
        filterBackwards();
    }

    public boolean isDone() {
        return current < first || current > last;
    }

    public Object current() throws IteratorOutOfBoundsException {
        if (isDone()) throw new IteratorOutOfBoundsException();
        return array[current];
    }
}

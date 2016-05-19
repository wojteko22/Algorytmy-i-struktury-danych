package lista1;

/**
 * @author Wojciech Okoński
 *         created on 11.03.2016 r.
 */
public class Iterator3 implements Iterator {
    private final int N;
    private final int first = 1;
    private int current = -1;

    public Iterator3(int N) {
        this.N = N;
    }

    @Override
    public void previous() {
        current--;
    }

    @Override
    public void next() {
        current++;
    }

    @Override
    public void first() {
        current = first;
    }

    @Override
    public void last() {
        first();
        while (calculate(current + 1) < N) next();
    }

    private int calculate(int number) {
        return (int) Math.pow(number, 2) - number + 41;
    }

    @Override
    public boolean isDone() {
        return current < first || calculate(current) >= N;
    }

    @Override
    public Object current() throws IteratorOutOfBoundsException {
        if (isDone()) throw new IteratorOutOfBoundsException();
        return calculate(current);
    }
}

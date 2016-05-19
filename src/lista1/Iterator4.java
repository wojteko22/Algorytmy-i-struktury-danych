package lista1;

/**
 * @author Wojciech Okoński
 *         created on 11.03.2016 r.
 */
public class Iterator4 implements Iterator {
    private final int N;
    private int current = -1, f, f1, f2;

    public Iterator4(int N) {
        this.N = N;
    }

    @Override
    public void previous() {
        f = f1;
        f1 = f2;
        f2 = f - f1;
        current--;
    }

    @Override
    public void next() {
        f2 = f1;
        f1 = f;
        f = f1 + f2;
        current++;
    }

    @Override
    public void first() {
        f = 1;
        f1 = 0;
        current = 0;
    }

    @Override
    public void last() {
        first();
        while (f + f1 < N) next();
    }

    @Override
    public boolean isDone() {
        return current < 0 || f >= N;
    }

    @Override
    public Object current() throws IteratorOutOfBoundsException {
        if (isDone()) throw new IteratorOutOfBoundsException();
        return f;
    }
}

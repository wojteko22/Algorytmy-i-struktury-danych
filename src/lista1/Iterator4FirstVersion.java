package lista1;/*
package lista1;

import java.util.ArrayList;

*/
/**
 * @author Wojciech Okoński
 *         created on 11.03.2016 r.
 *//*

public class Iterator4FirstVersion implements Iterator {
    private final ArrayList<Integer> list = new ArrayList<>();
    private final int N;
    private final int first = 0;
    private int current = -1;

    public Iterator4FirstVersion(int N) {
        list.add(1);
        list.add(1);
        this.N = N;
    }

    @Override
    public void previous() {
        --current;
    }

    @Override
    public void next() {
        ++current;
    }

    @Override
    public void first() {
        current = first;
    }

    @Override
    public void last() {
        System.out.println("Nie jest znana ostatnia liczba!");
    }

    @Override
    public boolean isDone() {
        return current < first || (int) current() >= N;
    }

    @Override
    public Object current() throws IteratorOutOfBoundsException {
        if (isDone()) throw new IteratorOutOfBoundsException();
        if (list.size() <= current) {
            int number = list.get(current - 2) + list.get(current - 1);
            list.add(number);
            return number;
        }
        return list.get(current);
    }
}
*/

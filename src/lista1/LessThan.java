package lista1;

/**
 * @author Wojciech Okoński
 *         created on 11.03.2016 r.
 */
public class LessThan implements Predicate {
    private int number;

    public LessThan(int number) {
        this.number = number;
    }

    @Override
    public boolean accept(Object ob) {
        return (int) ob < number;
    }
}

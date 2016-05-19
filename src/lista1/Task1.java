package lista1;

/**
 * @author Wojciech Okoński
 *         created on 11.03.2016 r.
 */
public class Task1 extends Array {

    public static void task1() {
        Iterator it = new ArrayIterator1(array);
        it.last();
        while (!it.isDone()) {
            System.out.println(it.current());
            it.previous();
        }
    }

    public static void task1Example() {
        createArray(41);
        printArray();
        task1();
    }

    public static void main(String[] args) {
        task1Example();
    }
}

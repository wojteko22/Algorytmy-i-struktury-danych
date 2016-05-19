package lista1;

/**
 * @author Wojciech Okoński
 *         created on 11.03.2016 r.
 */
public class Task2 extends Array {

    public static void task2(int number) {
        Iterator it = new FilterIterator2(array, new LessThan(number));
        it.first();
        while (!it.isDone()) {
            System.out.println(it.current());
            it.next();
        }
    }

    public static void task2Example() {
        createArray(20);
        printArray();
        task2(7);
    }

    public static void main(String[] args) {
        task2Example();
    }
}

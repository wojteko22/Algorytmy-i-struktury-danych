package lista1;

/**
 * @author Wojciech Okoński
 *         created on 11.03.2016 r.
 */
public class Task4 {
    public static void task4(int N) {
        Iterator it = new Iterator4(N);
        it.first();
        while (!it.isDone()) {
            System.out.println(it.current());
            it.next();
        }
    }

    public static void task4Example() {
        task4(250);
    }

    public static void main(String[] args) {
        task4Example();
    }
}

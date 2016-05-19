package lista1;

/**
 * @author Wojciech Okoński
 *         created on 11.03.2016 r.
 */
public class Task3 {
    public static void task3(int N) {
        Iterator it = new Iterator3(N);
        it.first();
        while (!it.isDone()) {
            System.out.println(it.current());
            it.next();
        }
    }

    public static void task3Example() {
        task3(200);
    }

    public static void main(String[] args) {
        task3Example();
    }
}

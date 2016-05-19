package lista2;

import lista1.Iterator;

/**
 * @author Wojciech Okoński
 *         created on 26.03.2016 r.
 */
public class Grupa {
    MyLinkedList list = new MyLinkedList();

    public void printListOfStudents() {
        System.out.println();
        Iterator it = list.iterator();
        it.first();
        while (!it.isDone()) {
            System.out.println(it.current());
            it.next();
        }
        System.out.println();
    }
}

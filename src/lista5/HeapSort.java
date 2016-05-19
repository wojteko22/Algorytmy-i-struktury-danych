/*
package lista5;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class HeapSort<T> {
    private final Comparator<T> comparator;

    public HeapSort(Comparator<T> comparator) {
        this.comparator = comparator.reversed();
    }

    public List<T> sort(List<T> list) {
        Queue<T> queue = createPriorityQueue(list);
        List<T> result = new ArrayList<T>(list.size());
        while (!queue.isEmpty()) {
            result.add(queue.dequeue());
        }
        return result;
    }

    private Queue<T> createPriorityQueue(List<T> list) {
        Queue<T> queue = new HeapPriorityQueue<T>(comparator);
        list.forEach(queue::enqueue);
        return queue;
    }
}
*/

package lista5;

import java.util.*;

/**
 * @author Wojciech Okoński
 *         created on 18.04.2016 r.
 */
public class Main {
    private static int heapSize = 12;

    static private void fillList(List<Character> list) {
        for (int i = 0; i < heapSize; i++) {
            list.add((char) ('a' + new Random().nextInt(26)));
        }
    }

    public static void main(String[] args) {
        List<Character> unsortedList = new ArrayList<>(heapSize);
        List<Character> sortedList = new ArrayList<>(heapSize);
        HeapPriorityQueue<Character> heapPriorityQueue = new HeapPriorityQueue<>(Collections.reverseOrder());

        fillList(unsortedList);
        unsortedList.forEach(heapPriorityQueue::enqueue);

        System.out.println("Nieposortowana lista: " + unsortedList + "\n");
        while (!heapPriorityQueue.isEmpty()) {
            heapPriorityQueue.print();
            sortedList.add(heapPriorityQueue.dequeue());
            System.out.println("Lista: " + sortedList + "\n");
        }
    }
}

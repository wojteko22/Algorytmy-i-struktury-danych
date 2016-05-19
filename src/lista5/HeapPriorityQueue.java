package lista5;

import lista3.EmptyQueueException;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


class HeapPriorityQueue<T> implements Queue<T> {
    private final List<T> list;
    private final Comparator<T> comparator;

    HeapPriorityQueue(Comparator<T> comparator) {
        this.comparator = comparator;
        list = new ArrayList<>();
    }

    public void enqueue(T value) {
        list.add(value);
        swim(list.size() - 1);
    }

    private void swim(int index) {
        int parent = (index - 1) / 2;
        if (index != 0 && comparator.compare(list.get(index), list.get(parent)) > 0) {
            swap(index, parent);
            swim(parent);
        }
    }

    private void swap(int index1, int index2) {
        T temp = list.get(index1);
        list.set(index1, list.get(index2));
        list.set(index2, temp);
    }

    public T dequeue() throws EmptyQueueException {
        if (isEmpty()) throw new EmptyQueueException();
        T result = list.get(0);
        if (list.size() > 1) {
            list.set(0, list.get(list.size() - 1));
            sink(0);
        }
        list.remove(list.size() - 1);
        return result;
    }

    private void sink(int index) {
        int left = index * 2 + 1;
        int right = index * 2 + 2;
        if (left < list.size()) {
            int largestChild = left;
            if (right < list.size()) {
                if (comparator.compare(list.get(left), list.get(right)) < 0) {
                    largestChild = right;
                }
            }
            if (comparator.compare(list.get(index), list.get(largestChild)) < 0) {
                swap(index, largestChild);
                sink(largestChild);
            }
        }
    }

    public void clear() {
        list.clear();
    }

    public int size() {
        return list.size();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    // additionally
    void print() {
        int length = calculateLength();
        int spaces = length;
        int index = 0;
        while (index < size()) {
            for (int position = 0; position < length && index < size(); position++) {
                if (position % (spaces + 1) == spaces / 2) System.out.print(list.get(index++));
                else System.out.print(" ");
            }
            spaces /= 2;
            System.out.println();
        }
        System.out.println();
    }

    private int calculateLength() {
        int result = 1;
        while (result <= size()) {
            result *= 2;
        }
        return result - 1;
    }
}

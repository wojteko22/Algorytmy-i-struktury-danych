package lista4;

import java.util.Comparator;
import java.util.List;

class QuickSortListSorter<T> implements Sorter<List<T>> {
    private final Comparator<T> comparator;

    QuickSortListSorter(Comparator<T> comparator) {
        this.comparator = comparator;
    }

    @Override
    public List<T> sort(List<T> list) {
        quicksort(list, 0, list.size() - 1);
        return list;
    }

    private void quicksort(List<T> list, int startIndex, int endIndex) {
        if (endIndex > startIndex) {
            int partition = partition(list, startIndex, endIndex);
            quicksort(list, startIndex, partition - 1);
            quicksort(list, partition + 1, endIndex);
        }
    }

    private int partition(List<T> list, int left, int right) {
        T value = list.get(right);
        int i = left, j = right;
        while (i < j) {
            while (comparator.compare(list.get(i), value) < 0) {
                i++;
            }
            while (true) {
                if (!((j > left) && comparator.compare(list.get(--j), value) > 0)) break;
            }
            if (i < j) swap(list, i, j);
        }
        swap(list, i, right);
        return i;
    }


    private void swap(List<T> list, int left, int right) {
        if (left != right) {
            T temp = list.get(left);
            list.set(left, list.get(right));
            list.set(right, temp);
        }
    }
}

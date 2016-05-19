package lista4;

import java.util.Comparator;
import java.util.List;

class BubbleSortListSorter<T> implements Sorter<List<T>> {
    private final Comparator<T> comparator;

    BubbleSortListSorter(Comparator<T> comparator) {
        this.comparator = comparator;
    }

    @Override
    public List<T> sort(List<T> list) {
        int size = list.size();

        for (int pass = 1; pass < size; ++pass) {
            for (int left = 0; left < (size - pass); ++left) {
                int right = left + 1;
                if (comparator.compare(list.get(left), list.get(right)) > 0) swap(list, left, right);
            }
        }
        return list;
    }

    private void swap(List<T> list, int left, int right) {
        T temp = list.get(left);
        list.set(left, list.get(right));
        list.set(right, temp);
    }
}

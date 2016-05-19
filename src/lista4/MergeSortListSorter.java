package lista4;

import java.util.*;

class MergeSortListSorter<T> implements Sorter<List<T>> {
    private final Comparator<T> comparator;

    MergeSortListSorter(Comparator<T> comparator) {
        this.comparator = comparator;
    }

    @Override
    public List<T> sort(List<T> list) {
        return mergesort(list, 0, list.size() - 1);
    }

    private List<T> mergesort(List<T> list, int startIndex, int endIndex) {
        if (startIndex == endIndex) {
            List<T> result = new ArrayList<>();
            result.add(list.get(startIndex));
            return result;
        }
        int splitIndex = startIndex + (endIndex - startIndex) / 2;
        return merge(mergesort(list, startIndex, splitIndex),
                mergesort(list, splitIndex + 1, endIndex));
    }

    private List<T> merge(List<T> left, List<T> right) {
        List<T> result = new ArrayList<>();
        ListIterator<T> l = left.listIterator();
        ListIterator<T> r = right.listIterator();
        T currentL, currentR;
        while (l.hasNext() && r.hasNext()) {
            currentL = l.next();
            currentR = r.next();
            if (comparator.compare(currentL, currentR) <= 0) {
                result.add(currentL);
                r.previous();
            } else {
                result.add(currentR);
                l.previous();
            }
        }
        while (l.hasNext()) {
            currentL = l.next();
            result.add(currentL);
        }
        while (r.hasNext()) {
            currentR = r.next();
            result.add(currentR);
        }
        return result;
    }
}


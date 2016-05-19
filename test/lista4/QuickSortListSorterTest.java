package lista4;

import java.util.Comparator;
import java.util.List;


/**
 * @author Wojciech Okoński
 *         created on 09.04.2016 r.
 */
public class QuickSortListSorterTest extends AbstractListSorterTest {

    @Override
    protected Sorter<List<String>> createListSorter(Comparator<String> comparator) {
        return new QuickSortListSorter<>(comparator);
    }
}
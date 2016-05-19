package lista4;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public abstract class AbstractListSorterTest {
    private List<String> unsortedList;
    private List<String> sortedList;

    @Before
    public void setUp() throws Exception {
        unsortedList = new LinkedList<>();

        unsortedList.add("test");
        unsortedList.add("driven");
        unsortedList.add("development");
        unsortedList.add("is");
        unsortedList.add("one");
        unsortedList.add("small");
        unsortedList.add("step");
        unsortedList.add("for");
        unsortedList.add("a");
        unsortedList.add("programmer");
        unsortedList.add("but");
        unsortedList.add("it's");
        unsortedList.add("one");
        unsortedList.add("giant");
        unsortedList.add("leap");
        unsortedList.add("for");
        unsortedList.add("programming");

        sortedList = new LinkedList<>();

        sortedList.add("a");
        sortedList.add("but");
        sortedList.add("development");
        sortedList.add("driven");
        sortedList.add("for");
        sortedList.add("for");
        sortedList.add("giant");
        sortedList.add("is");
        sortedList.add("it's");
        sortedList.add("leap");
        sortedList.add("one");
        sortedList.add("one");
        sortedList.add("programmer");
        sortedList.add("programming");
        sortedList.add("small");
        sortedList.add("step");
        sortedList.add("test");
    }

    @After
    public void tearDown() throws Exception {
        sortedList = null;
        unsortedList = null;
    }

    protected abstract Sorter<List<String>> createListSorter(Comparator<String> comparator);

    @Test
    public void testListSorterCanSortSampleList() {
        Sorter<List<String>> sorter = createListSorter(new NaturalComparator<>());
        assertThat(sorter.sort(unsortedList), is(sortedList));
    }
}
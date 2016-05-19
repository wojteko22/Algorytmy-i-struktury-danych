package lista1;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.sameInstance;
import static org.junit.Assert.*;

/**
 * @author Wojciech Okoński
 *         created on 15.03.2016 r.
 */
public class ArrayIterator1Test {

    @Test
    public void testFirstLast() throws Exception {
        int[] array = {1, 2, 3, 4, 5, 6, 7};
        ArrayIterator1 ai = new ArrayIterator1(array);
        assertThat(ai.isDone(), is(true));
        ai.first();
        assertThat(ai.isDone(), is(false));
        assertThat(ai.current(), sameInstance(array[0]));
        ai.last();
        assertThat(ai.isDone(), is(false));
        assertThat(ai.current(), sameInstance(array[array.length - 1]));
        ai.next();
        assertThat(ai.isDone(), is(true));
        try {
            ai.current();
            fail();
        } catch (IteratorOutOfBoundsException e) {
            //OK
        }
        ai.first();
        ai.previous();
        assertThat(ai.isDone(), is(true));
    }


}
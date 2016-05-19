package lista3;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;


/**
 * @author Wojciech Okoński
 *         created on 03.04.2016 r.
 */
public class DrowningStackTest extends AbstractStackTest {
    private static final Object VALUE_D = "D";
    private static final Object VALUE_E = "E";
    private static final Object VALUE_F = "F";

    @Override
    protected Stack createStack() {
        return new DrowningStack(5);
    }

    @Test
    public void testPushOverLimit() {
        Stack stack = createStack();

        stack.push(VALUE_A);
        stack.push(VALUE_B);
        stack.push(VALUE_C);
        stack.push(VALUE_D);
        stack.push(VALUE_E);

        assertThat(stack.size(), is(5));

        stack.push(VALUE_F);

        assertThat(stack.size(), is(5));

        assertThat(stack.pop(), sameInstance(VALUE_F));
        assertThat(stack.pop(), sameInstance(VALUE_E));
        assertThat(stack.pop(), sameInstance(VALUE_D));
        assertThat(stack.pop(), sameInstance(VALUE_C));
        assertThat(stack.pop(), sameInstance(VALUE_B));
        assertThat(stack.isEmpty(), is(true));
    }
}
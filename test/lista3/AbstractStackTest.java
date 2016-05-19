package lista3;

import junit.framework.TestCase;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public abstract class AbstractStackTest {
    static final Object VALUE_A = "A";
    static final Object VALUE_B = "B";
    static final Object VALUE_C = "C";

    protected abstract Stack createStack();

    @Test
    public void testPushAndPop() {
        Stack stack = createStack();

        stack.push(VALUE_B);
        stack.push(VALUE_A);
        stack.push(VALUE_C);

        assertThat(stack.size(), is(3));
        assertThat(stack.isEmpty(), is(false));

        assertThat(stack.pop(), sameInstance(VALUE_C));
        assertThat(stack.size(), is(2));
        assertThat(stack.isEmpty(), is(false));

        assertThat(stack.pop(), sameInstance(VALUE_A));
        assertThat(stack.size(), is(1));
        assertThat(stack.isEmpty(), is(false));

        assertThat(stack.pop(), sameInstance(VALUE_B));
        assertThat(stack.size(), is(0));
        assertThat(stack.isEmpty(), is(true));
    }

    @Test
    public void testCantPopFromAnEmptyStack() {
        Stack stack = createStack();

        assertThat(stack.size(), is(0));
        assertThat(stack.isEmpty(), is(true));

        try {
            stack.pop();
            fail();
        } catch (EmptyStackException e) {
            // expected
        }
    }

    @Test
    public void testPeek() {
        Stack stack = createStack();

        stack.push(VALUE_C);
        stack.push(VALUE_A);
        assertThat(stack.size(), is(2));

        assertThat(stack.peek(), sameInstance(VALUE_A));
        assertThat(stack.size(), is(2));
    }

    @Test
    public void testCantPeekIntoAnEmptyStack() {
        Stack stack = createStack();

        assertThat(stack.size(), is(0));
        assertThat(stack.isEmpty(), is(true));

        try {
            stack.peek();
            fail();
        } catch (EmptyStackException e) {
            // expected
        }
    }

    @Test
    public void testClear() {
        Stack stack = createStack();

        stack.push(VALUE_A);
        stack.push(VALUE_B);
        stack.push(VALUE_C);

        assertThat(stack.isEmpty(), is(false));

        stack.clear();

        assertThat(stack.isEmpty(), is(true));
        assertThat(stack.size(), is(0));

        try {
            stack.pop();
            fail();
        } catch (EmptyStackException e) {
            // expected
        }
    }
}

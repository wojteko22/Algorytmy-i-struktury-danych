package lista3;

/**
 * @author Wojciech Okoński
 *         created on 03.04.2016 r.
 */
public class MyStackTest extends AbstractStackTest {

    @Override
    protected Stack createStack() {
        return new MyStack();
    }
}
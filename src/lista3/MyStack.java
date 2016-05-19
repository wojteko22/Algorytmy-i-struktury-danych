package lista3;

/**
 * @author Wojciech Okoński
 *         created on 03.04.2016 r.
 */
class MyStack implements Stack {
    private final Element headAndTail = new Element(null);
    private int size;

    MyStack() {
        clear();
    }

    @Override
    public void push(Object value) {
        Element element = new Element(value);
        Element next = headAndTail.getNext();
        element.setNext(next);
        headAndTail.setNext(element);
        ++size;
    }

    @Override
    public Object pop() throws EmptyStackException {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        Element element = headAndTail.getNext();
        headAndTail.setNext(element.getNext());
        --size;
        return element.getValue();
    }

    @Override
    public Object peek() throws EmptyStackException {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return headAndTail.getNext().getValue();
    }

    @Override
    public void enqueue(Object value) {
        push(value);
    }

    @Override
    public Object dequeue() throws EmptyQueueException {
        try {
            return pop();
        } catch (EmptyStackException e) {
            throw new EmptyQueueException();
        }
    }

    @Override
    public void clear() {
        headAndTail.setNext(headAndTail);
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    private static final class Element {
        private Object value;
        private Element next;

        Element(Object value) {
            setValue(value);
        }

        public void setValue(Object value) {
            this.value = value;
        }

        public Object getValue() {
            return value;
        }

        public Element getNext() {
            return next;
        }

        public void setNext(Element next) {
            this.next = next;
        }
    }

    // To w sumie niepotrzebne
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append('[');
        if (!isEmpty()) {
            Element e = headAndTail.getNext();
            while (e != headAndTail) {
                string.append(e.getValue()).append(", ");
                e = e.getNext();
            }
            string.setLength(string.length() - 2);
        }
        string.append(']');
        return string.toString();
    }
}

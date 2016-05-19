package lista3;

/**
 * @author Wojciech Okoński
 *         created on 03.04.2016 r.
 */
class DrowningStack implements Stack {
    private final Element headAndTail = new Element(null);
    private int size;
    private final int maxSize;

    DrowningStack(int maxSize) {
        clear();
        this.maxSize = maxSize;
    }

    @Override
    public void push(Object value) {
        if (size == maxSize) {
            headAndTail.getNext().detach();
            --size;
        }
        Element element = new Element(value);
        Element last = headAndTail.getPrevious();
        element.setPrevious(last);
        last.setNext(element);
        headAndTail.setPrevious(element);
        element.setNext(headAndTail);
        ++size;
    }

    @Override
    public Object pop() throws EmptyStackException {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        Element element = headAndTail.getPrevious();
        element.detach();
        --size;
        return element.getValue();
    }

    @Override
    public Object peek() throws EmptyStackException {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return headAndTail.getPrevious().getValue();
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
        headAndTail.setPrevious(headAndTail);
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
        private Element previous;

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

        public void setPrevious(Element previous) {
            this.previous = previous;
        }

        public Element getPrevious() {
            return previous;
        }

        public void setNext(Element next) {
            this.next = next;
        }

        void detach() {
            previous.setNext(next);
            next.setPrevious(previous);
        }
    }
}

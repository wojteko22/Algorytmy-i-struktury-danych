package lista2;

import lista1.Iterator;

/**
 * @author Wojciech Okoński
 *         created on 26.03.2016 r.
 */
public class MyLinkedList {
    private final Element headAndTail = new Element(null);
    private int size;

    public MyLinkedList() {
        headAndTail.setPrevious(headAndTail);
        headAndTail.setNext(headAndTail);
        size = 0;
    }

    /**
     * dodanie elementu za element o wskazanym indeksie
     */
    public void insert(int index, Object value) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size && size != 0) throw new IndexOutOfBoundsException();
        Element element = new Element(value);
        element.attachAfter(getElement(index));
        ++size;
    }

    /**
     * usunięcie elementu na zadanej pozycji
     */
    public Object delete(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        Element element = getElement(index);
        element.detach();
        --size;
        return element.getValue();
    }

    /**
     * wyszukanie pozycji zadanego elementu
     */
    public int find(Object value) {
        int index = 0;
        Element e = headAndTail.getNext();
        while (e != headAndTail && !value.equals(e.getValue())) {
            e = e.getNext();
            ++index;
        }
        return e != headAndTail ? index : -1;
    }

    private Element getElement(int index) {
        return index < size / 2 ? getElementForwards(index) : getElementBackwards(index);
    }


    private Element getElementForwards(int index) {
        Element element = headAndTail.getNext();
        for (int i = index; i > 0; --i) element = element.getNext();
        return element;
    }

    private Element getElementBackwards(int index) {
        Element element = headAndTail;
        for (int i = size - index; i > 0; --i) element = element.getPrevious();
        return element;
    }

    private static final class Element {
        private Object value;
        private Element previous;
        private Element next;

        public Element(Object value) {
            setValue(value);
        }

        public void setValue(Object value) {
            this.value = value;
        }

        public Object getValue() {
            return value;
        }

        public Element getPrevious() {
            return previous;
        }

        public void setPrevious(Element previous) {
            this.previous = previous;
        }

        public Element getNext() {
            return next;
        }

        public void setNext(Element next) {
            this.next = next;
        }

        public void attachAfter(Element previous) {
            Element next = previous.getNext();
            setPrevious(previous);
            setNext(next);
            previous.setNext(this);
            next.setPrevious(this);
        }

        public void detach() {
            previous.setNext(next);
            next.setPrevious(previous);
        }
    }


    public Iterator iterator() {
        return new ValueIterator();
    }

    private final class ValueIterator implements Iterator {
        private Element current = headAndTail;

        public void first() {
            current = headAndTail.getNext();
        }

        public void last() {
            current = headAndTail.getPrevious();
        }

        public boolean isDone() {
            return current == headAndTail;
        }

        public void next() {
            current = current.getNext();
        }

        public void previous() {
            current = current.getPrevious();
        }

        public Object current() throws IndexOutOfBoundsException {
            if (isDone()) throw new IndexOutOfBoundsException();
            return current.getValue();
        }
    }
}

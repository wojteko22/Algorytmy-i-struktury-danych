package lista6i7;

class Node<T> {

    private T value;

    private Node<T> smaller;

    private Node<T> larger;

    Node(T value) {
        this(value, null, null);
    }

    private Node(T value, Node<T> smaller, Node<T> larger) {
        setValue(value);
        setSmaller(smaller);
        setLarger(larger);
        if (smaller != null) {
            smaller.setParent(this);
        }
        if (larger != null) {
            larger.setParent(this);
        }
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    Node<T> getSmaller() {
        return smaller;
    }

    void setSmaller(Node<T> smaller) {
        this.smaller = smaller;
    }

    Node<T> getLarger() {
        return larger;
    }

    void setLarger(Node<T> larger) {
        this.larger = larger;
    }

    public String toString() {
        return getValue().toString();
    }


    ////////////////////nowe////////////////////
    private Node<T> parent;

    Node<T> getParent() {
        return parent;
    }

    void setParent(Node<T> parent) {
        this.parent = parent;
    }

    private Node<T> minimum() {
        Node<T> node = this;

        while (node.getSmaller() != null) {
            node = node.getSmaller();
        }

        return node;
    }

    private boolean isLarger() {
        return getParent() != null && this == getParent().getLarger();
    }

    boolean isSmaller() {
        return getParent() != null && this == getParent().getSmaller();
    }

    Node<T> successor() {
        if (getLarger() != null) {
            return getLarger().minimum();
        }

        Node<T> node = this;

        while (node.isLarger()) {
            node = node.getParent();
        }

        return node.getParent();
    }
}

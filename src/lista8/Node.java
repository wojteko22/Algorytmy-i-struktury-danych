package lista8;

class Node<T> {

    private T value;

    private Node<T> leftSon;

    private Node<T> rightSon;

    Node(T value) {
        setValue(value);
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    Node<T> getLeftSon() {
        return leftSon;
    }

    void setLeftSon(Node<T> leftSon) {
        this.leftSon = leftSon;
    }

    Node<T> getRightSon() {
        return rightSon;
    }

    void setRightSon(Node<T> rightSon) {
        this.rightSon = rightSon;
    }

    public String toString() {
        return getValue().toString();
    }
}

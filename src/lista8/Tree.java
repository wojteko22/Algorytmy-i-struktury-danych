package lista8;

/**
 * @author Wojciech Okoński
 *         created on 10.05.2016 r.
 */
class Tree<T> {
    private Node<T> root;

    Tree(T value) {
        this.root = new Node<>(value);
    }

    Node<T> getRoot() {
        return root;
    }

    public String toString() {
        return toString(root, 4);
    }

    private String toString(Node<T> rootOfSubtree, int spaces) {
        if (rootOfSubtree != null) {
            return toString(rootOfSubtree.getRightSon(), spaces + 4) +
                    String.format("%" + spaces + "s", rootOfSubtree.toString()) +
                    toString(rootOfSubtree.getLeftSon(), spaces + 4);
        } else return "\n";
    }

}

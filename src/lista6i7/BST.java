package lista6i7;

import java.util.Comparator;

class BST<T> {
    private final Comparator<T> comparator;
    private Node<T> root;
    private int innerNodes;
    private int nodesWithOneChild;
    private int leafNodes;

    BST(Comparator<T> comparator) {
        this.comparator = comparator;
    }

    private Node<T> insert(T value) {
        Node<T> parent = null;
        Node<T> node = root;
        int cmp = 0;

        while (node != null) {
            parent = node;
            cmp = comparator.compare(value, node.getValue());
            node = cmp <= 0 ? node.getSmaller() : node.getLarger();
        }

        Node<T> inserted = new Node<>(value);
        inserted.setParent(parent); //nowe

        if (parent == null) {
            root = inserted;
        } else if (cmp < 0) {
            parent.setSmaller(inserted);
        } else {
            parent.setLarger(inserted);
        }

        return inserted;
    }

    @SafeVarargs
    final void insert(T... values) {
        for (T value : values) insert(value);

    }

    public String toString() {
        innerNodes = 0;
        nodesWithOneChild = 0;
        leafNodes = 0;
        countNodes(root);
        return toString(root, 4) + "\nWewnętrznych: " + innerNodes + "\nZ jednym potomkiem: " + nodesWithOneChild + "\nLiści: " + leafNodes + "\n-----------------------------------";
    }

    private String toString(Node<T> rootOfSubtree, int spaces) {
        if (rootOfSubtree != null) {
            return toString(rootOfSubtree.getLarger(), spaces + 4) + String.format("%" + spaces + "s", rootOfSubtree.toString()) + toString(rootOfSubtree.getSmaller(), spaces + 4);
        } else return "\n";
    }

    private void countNodes(Node<T> node) {
        boolean hasChild = false;
        if (node.getSmaller() != null) {
            innerNodes++;
            hasChild = true;
            countNodes(node.getSmaller());
            if (node.getLarger() == null) {
                nodesWithOneChild++;
            }
        }
        if (node.getLarger() != null) {
            if (!hasChild) {
                innerNodes++;
                nodesWithOneChild++;
            }
            hasChild = true;
            countNodes(node.getLarger());
        }
        if (!hasChild) leafNodes++;
    }

    ////////////////////nowe////////////////////
    Node<T> search(T value) {
        assert value != null : "value can't be null";

        Node<T> node = root;
        int cmp;
        while (node != null && (cmp = comparator.compare(value, node.getValue())) != 0)
            node = cmp < 0 ? node.getSmaller() : node.getLarger();
        return node;
    }

    Node<T> delete(T value) {
        Node<T> node = search(value);
        if (node == null) {
            return null;
        }

        Node<T> deleted = node.getSmaller() != null && node.getLarger() != null ? node.successor() : node;

        Node<T> replacement = deleted.getSmaller() != null ? deleted.getSmaller() : deleted.getLarger();
        if (replacement != null) {
            replacement.setParent(deleted.getParent());
        }

        if (deleted == root) {
            root = replacement;
        } else if (deleted.isSmaller()) {
            deleted.getParent().setSmaller(replacement);
        } else {
            deleted.getParent().setLarger(replacement);
        }

        if (deleted != node) {
            T deletedValue = node.getValue();
            node.setValue(deleted.getValue());
            deleted.setValue(deletedValue);
        }

        return deleted;
    }
}

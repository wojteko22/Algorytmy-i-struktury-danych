package lista9;

/**
 * @author Wojciech Okoński
 *         created on 16.05.2016 r.
 */
public class Node {
    private String name;
    private Node parent;

    public Node(String name) {
        this.name = name;
        makeSet(this);
    }

    public String toString() {
        return name;
    }

    static void makeSet(Node node) {
        node.parent = node;
    }

    static void unionSets(Node node1, Node node2) {
        link(findParent(node1), findParent(node2));
    }

    private static void link(Node parent1, Node parent2) {
        parent2.parent = parent1;
    }

    static Node findParent(Node node) {
        return node == node.parent ? node : findParent(node.parent);
    }

    //new
    private boolean visited;

    boolean isVisited() {
        return visited;
    }

    void setVisited(boolean visited) {
        this.visited = visited;
    }
}

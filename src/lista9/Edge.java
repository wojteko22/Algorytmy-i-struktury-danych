package lista9;

/**
 * @author Wojciech Okoński
 *         created on 16.05.2016 r.
 */
class Edge {
    private Node node1;
    private Node node2;
    private int weight;

    Edge(Node node1, Node node2, int weight) {
        this.node1 = node1;
        this.node2 = node2;
        this.weight = weight;
    }

    int getWeigh() {
        return weight;
    }

    Node getNode1() {
        return node1;
    }

    Node getNode2() {
        return node2;
    }

    public String toString() {
        return node1 + "-" + node2 + ": " + weight;
    }

    //new
    Node getOtherNode(Node node) {
        if (getNode1().equals(node)) return getNode2();
        if (getNode2().equals(node)) return getNode1();
        else return null;
    }
}

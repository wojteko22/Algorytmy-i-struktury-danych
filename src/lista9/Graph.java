package lista9;

import java.util.*;

/**
 * @author Wojciech Okoński
 *         created on 16.05.2016 r.
 */
class Graph {
    private List<Edge> edges = new LinkedList<>();

    void addEdge(Node node1, Node node2, int weight) {
        addEdge(new Edge(node1, node2, weight));
    }

    void addEdge(Edge edge) {
        edges.add(edge);
    }

    public String toString() {
        return edges.toString();
    }

    PriorityQueue<Edge> getSortedEdgesAndDisjoinNodes() {
        PriorityQueue<Edge> queue = new PriorityQueue<>((a, b) -> a.getWeigh() - b.getWeigh());
        for (Edge edge : edges) {
            Node.makeSet(edge.getNode1());
            Node.makeSet(edge.getNode2());
            queue.add(edge);
        }
        return queue;
    }
}

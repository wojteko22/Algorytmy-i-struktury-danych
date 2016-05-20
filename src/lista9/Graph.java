package lista9;

import java.util.*;

/**
 * @author Wojciech Okoński
 *         created on 16.05.2016 r.
 */
public class Graph {
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

    // new
    public Set<Node> getNodes() {
        Set<Node> nodesSet = new HashSet<>();
        for (Edge edge : edges) {
            nodesSet.add(edge.getNode1());
            nodesSet.add(edge.getNode2());
        }
        return nodesSet;
    }

    public Node findNode(String name) {
        for (Node node : getNodes()) {
            if (node.toString().equals(name)) return node;
        }
        return null;
    }

    private int biggestWeight;

    public int findBiggestWeight(Node startNode) {
        biggestWeight = 0;
        for (Node node : getNodes()) node.setVisited(false);
        visitNode(startNode);
        return biggestWeight;
    }

    private void visitNode(Node node) {
        node.setVisited(true);
        System.out.println("Visitting " + node);
        edges.stream()
                .filter(edge -> edge.getOtherNode(node) != null && !edge.getOtherNode(node).isVisited())
                .forEach(edge -> {
                    biggestWeight = Math.max(biggestWeight, edge.getWeigh());
                    visitNode(edge.getOtherNode(node));
                });
    }


}

package lista9;

import java.util.*;
import java.util.stream.Collectors;

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

    //////////////////////////////////////////////for list11//////////////////////////////////////////////////////////
    public int dijkstra(Node startNode, Node endNode) {
        Map<Node, Double> minimalDistance = new HashMap<>();
        Map<Node, Edge> precedingEdges = new HashMap<>();

        for (Node node : getNodes()) {
            minimalDistance.put(node, Double.POSITIVE_INFINITY);
        }
        minimalDistance.replace(startNode, 0.0);

        Set<Node> remainingNodes = new HashSet<>();
        remainingNodes.addAll(getNodes());

        Node currentNode = startNode;
        while (currentNode != endNode) {
            for (Edge neighboringEdge : getNeiboringEdges(currentNode)) {
                Node neighboringNode = neighboringEdge.getOtherNode(currentNode);
                if (minimalDistance.get(neighboringNode) > minimalDistance.get(currentNode) + neighboringEdge.getWeigh()) {
                    minimalDistance.replace(neighboringNode, minimalDistance.get(currentNode) + neighboringEdge.getWeigh());
                    precedingEdges.put(neighboringNode, neighboringEdge);
                }
            }
            currentNode = remainingNodes.stream()
                    .min((a, b) -> (int) (minimalDistance.get(a) - minimalDistance.get(b)))
                    .orElseThrow(() -> new NoSuchElementException("Cannot get node with minimal distance from startNode"));
            remainingNodes.remove(currentNode);
        }
        displayWay(startNode, endNode, precedingEdges);
        int result = (int) ((double) minimalDistance.get(endNode));
        System.out.println("Its length is " + result);
        return result;
    }

    private void displayWay(Node startNode, Node endNode, Map<Node, Edge> precedingEdges) {
        Node currentNode = endNode;
        StringBuilder str = new StringBuilder();

        while (currentNode != startNode) {
            str.append(currentNode).append("–").append(precedingEdges.get(currentNode).getWeigh()).append("–");
            currentNode = precedingEdges.get(currentNode).getOtherNode(currentNode);
        }

        str.append(currentNode);

        System.out.println("\nThe shortest path: " + str.reverse().toString());
    }

    private Set<Edge> getNeiboringEdges(Node node) {
        return edges.stream()
                .filter(edge -> edge.getOtherNode(node) != null)
                .collect(Collectors.toCollection(HashSet::new));
    }
}

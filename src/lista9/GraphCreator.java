package lista9;

/**
 * @author Wojciech Okoński
 *         created on 20.05.2016 r.
 */
public class GraphCreator {
    static Graph createGraph1() {
        Node a = new Node("a");
        Node b = new Node("b");
        Node c = new Node("c");
        Node d = new Node("d");
        Node e = new Node("e");
        Graph graph = new Graph();
        graph.addEdge(a, e, 1);
        graph.addEdge(c, d, 2);
        graph.addEdge(a, b, 3);
        graph.addEdge(b, e, 4);
        graph.addEdge(b, c, 5);
        graph.addEdge(e, c, 6);
        graph.addEdge(e, d, 7);
        return graph;
    }

    public static Graph createGraph2() {
        Node a = new Node("a");
        Node b = new Node("b");
        Node c = new Node("c");
        Node d = new Node("d");
        Node e = new Node("e");
        Node f = new Node("f");
        Node g = new Node("g");
        Graph graph = new Graph();
        graph.addEdge(a, b, 1);
        graph.addEdge(a, c, 2);
        graph.addEdge(a, e, 3);
        graph.addEdge(b, d, 9);
        graph.addEdge(b, f, 5);
        graph.addEdge(c, g, 8);
        graph.addEdge(f, e, 7);
        return graph;
    }
}

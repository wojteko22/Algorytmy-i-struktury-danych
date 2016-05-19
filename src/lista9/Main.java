package lista9;

/**
 * @author Wojciech Okoński
 *         created on 16.05.2016 r.
 */
public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
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
        System.out.println("full graph:\t" + graph);
        System.out.println("mst:\t\t"+ Kruskal.getMST(graph));
    }
}

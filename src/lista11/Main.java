package lista11;

import lista9.Graph;
import lista9.GraphCreator;
import lista9.Node;

import java.util.Scanner;

/**
 * @author Wojciech Okoński
 *         created on 03.06.2016 r.
 */
public class Main {
    public static void main(String[] args) {
        Graph graph = GraphCreator.createGraph3();
        System.out.println("Graph: " + graph);

        Node startNode = null, endNode = null;
        Scanner in = new Scanner(System.in);

        while (startNode == null) {
            System.out.print("Pass the start node " + graph.getNodes() + ": ");
            startNode = graph.findNode(in.next());
        }
        while (endNode == null) {
            System.out.print("Pass the end node " + graph.getNodes() + ": ");
            endNode = graph.findNode(in.next());
        }

        graph.dijkstra(startNode, endNode);
    }
}

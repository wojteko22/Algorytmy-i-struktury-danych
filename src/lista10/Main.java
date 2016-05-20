package lista10;

import lista9.Graph;
import lista9.GraphCreator;
import lista9.Node;

import java.util.Scanner;

/**
 * @author Wojciech Okoński
 *         created on 20.05.2016 r.
 */
public class Main {
    public static void main(String[] args) {
        Graph graph = GraphCreator.createGraph2();
        Node startNode = null;
        while (startNode == null) {
            System.out.print("Pass the node from which you want to start " + graph.getNodes() + ": ");
            Scanner in = new Scanner(System.in);
            startNode = graph.findNode(in.next());
        }
        System.out.println("The biggest weight: " + graph.findBiggestWeight(startNode));
    }


}

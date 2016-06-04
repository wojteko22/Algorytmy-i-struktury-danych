package lista9;

/**
 * @author Wojciech Okoński
 *         created on 16.05.2016 r.
 */
public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        Graph graph = GraphCreator.createGraph1();
        System.out.println("full graph:\t" + graph);
        System.out.println("mst:\t\t" + Kruskal.getMST(graph));
    }
}

package lista9;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * @author Wojciech Okoński
 *         created on 03.06.2016 r.
 */
public class GraphTest {

    @Test
    public void dijkstraTest() throws Exception {
        Node a = new Node("a");
        Node b = new Node("b");
        Node c = new Node("c");
        Node d = new Node("d");
        Node e = new Node("e");
        Node f = new Node("f");
        Graph graph = new Graph();
        graph.addEdge(a, b, 7);
        graph.addEdge(a, c, 9);
        graph.addEdge(a, f, 14);
        graph.addEdge(b, d, 15);
        graph.addEdge(b, c, 10);
        graph.addEdge(c, d, 11);
        graph.addEdge(c, f, 2);
        graph.addEdge(d, e, 6);
        graph.addEdge(e, f, 9);

        assertThat(graph.dijkstra(a, b), is(7));
        assertThat(graph.dijkstra(a, c), is(9));
        assertThat(graph.dijkstra(a, d), is(20));
        assertThat(graph.dijkstra(a, e), is(20));
        assertThat(graph.dijkstra(a, f), is(11));
    }
}
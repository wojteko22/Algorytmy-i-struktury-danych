package lista9;

import java.util.PriorityQueue;

/**
 * @author Wojciech Okoński
 *         created on 16.05.2016 r.
 */
class Kruskal {
    static Graph getMST(Graph graph) {
        Graph mst = new Graph();
        PriorityQueue<Edge> queue = graph.getSortedEdgesAndDisjoinNodes();

        while (!queue.isEmpty()) {
            Edge edge = queue.poll();

            if (Node.findParent(edge.getNode1()) != Node.findParent(edge.getNode2())) {
                mst.addEdge(edge);
                Node.unionSets(edge.getNode1(), edge.getNode2());
            }
        }

        return mst;
    }
}

package lista9;

import java.util.PriorityQueue;

/**
 * @author Wojciech Okoński
 *         created on 16.05.2016 r.
 */
public class ToTests {
    public static void main(String[] args) {
        Node node = new Node("a");
        PriorityQueue<Node> nodes = new PriorityQueue<>((a, b) -> a.hashCode() - b.hashCode());
        nodes.offer(node);
        nodes.offer(node);
        nodes.poll();
        nodes.poll();
        System.out.println(nodes.poll());
    }
}

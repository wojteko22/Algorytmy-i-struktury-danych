package lista9;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Wojciech Okoński
 *         created on 16.05.2016 r.
 */
public class ToTests {
    public static void main(String[] args) {
        Map<Node, Integer> map = new HashMap<>();
        Node node = new Node("a");
        map.put(node, 1);
        map.put(node, 2);
        System.out.println(map);
    }
}

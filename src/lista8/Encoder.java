package lista8;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author Wojciech Okoński
 *         created on 10.05.2016 r.
 */
class Encoder {
    static PriorityQueue<Tree<Pair>> createList(String sequence) {
        PriorityQueue<Tree<Pair>> result = new PriorityQueue<>(HuffManComparator.INSTANCE);

        while (!sequence.equals("")) {
            char value = sequence.charAt(0);
            int oldLength = sequence.length();
            sequence = sequence.replace("" + value, "");
            int incidence = oldLength - sequence.length();
            result.offer(new Tree<>(new Pair(value, incidence)));
        }

        return result;
    }

    static Tree<Pair> createTree(PriorityQueue<Tree<Pair>> queue) {
        while (queue.size() > 1) {
            Tree<Pair> left = queue.poll();
            Tree<Pair> right = queue.poll();
            Tree<Pair> newTree = new Tree<>(new Pair('*', left.getRoot().getValue().getIncidence() + right.getRoot().getValue().getIncidence()));
            newTree.getRoot().setLeftSon(left.getRoot());
            newTree.getRoot().setRightSon(right.getRoot());
            queue.offer(newTree);
        }

        return queue.poll();
    }

    static Map<Character, String> createCodeWords(Tree<Pair> tree) {
        Map<Character, String> map = new HashMap<>();
        StringBuilder currentCode = new StringBuilder();
        Node<Pair> root = tree.getRoot();
        encodeChilds(root, currentCode, map);
        return map;
    }

    private static void encodeChilds(Node<Pair> node, StringBuilder stringBuilder, Map<Character, String> map) {
        if (node.getValue().getValue() != '*') {
            map.put(node.getValue().getValue(), stringBuilder.toString());
        } else {
            if (node.getLeftSon() != null)
                encodeChilds(node.getLeftSon(), new StringBuilder(stringBuilder).append('0'), map);
            if (node.getRightSon() != null)
                encodeChilds(node.getRightSon(), new StringBuilder(stringBuilder).append('1'), map);
        }
    }

    static String encodeSequence(String sequence, Map<Character, String> map) {
        String result = "";
        for (int i = 0; i < sequence.length(); i++) {
            result += map.get(sequence.charAt(i));
        }
        return result;
    }


}

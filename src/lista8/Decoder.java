package lista8;

/**
 * @author Wojciech Okoński
 *         created on 10.05.2016 r.
 */
class Decoder {
    static String decode(String sequence, Tree<Pair> tree) {
        StringBuilder result = new StringBuilder();
        int index = 0;
        Node<Pair> node = tree.getRoot();

        while (index < sequence.length()) {
            if (node.getLeftSon() == null) {
                result.append(node.getValue().getValue());
                node = tree.getRoot();
            } else {
                if (sequence.charAt(index) == '0') node = node.getLeftSon();
                else node = node.getRightSon();
                index++;
            }
        }

        result.append(node.getValue().getValue());

        return result.toString();
    }


}

package lista8;

import java.util.Comparator;

/**
 * @author Wojciech Okoński
 *         created on 10.05.2016 r.
 */
class HuffManComparator implements Comparator<Tree<Pair>> {
    static HuffManComparator INSTANCE = new HuffManComparator();

    private HuffManComparator() {
    }

    @Override
    public int compare(Tree<Pair> o1, Tree<Pair> o2) {
        return o1.getRoot().getValue().getIncidence() - o2.getRoot().getValue().getIncidence();
    }
}

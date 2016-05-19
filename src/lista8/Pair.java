package lista8;

/**
 * @author Wojciech Okoński
 *         created on 10.05.2016 r.
 */
class Pair {
    private char value;

    private int incidence;

    Pair(char value, int incidence) {
        this.value = value;
        this.incidence = incidence;
    }

    public char getValue() {
        return value;
    }

    int getIncidence() {
        return incidence;
    }

    public String toString() {
        return value + " " + incidence;
    }
}

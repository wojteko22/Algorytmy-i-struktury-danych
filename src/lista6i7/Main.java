package lista6i7;

/**
 * @author Wojciech Okoński
 *         created on 24.04.2016 r.
 */
public class Main {
    public static void main(String[] args) {
        BST<Integer> bst = new BST<>(Integer::compare);

        bst.insert(5, 2, 7, 1, 3, 8, 4, 9);
        System.out.println(bst);

        bst.insert(6);
        System.out.println("Drzewo po dodaniu elementu 6:" + bst);

        bst.delete(5);
        System.out.println("Drzewo po usunięciu elementu 5:" + bst);

        System.out.println("Szukanie elementu 3: " + bst.search(3));
        System.out.println("Szukanie elementu 11: " + bst.search(11));

    }
}

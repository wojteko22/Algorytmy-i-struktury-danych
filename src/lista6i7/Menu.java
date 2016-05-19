package lista6i7;

import java.util.Scanner;

/**
 * @author Wojciech Okoński
 *         created on 01.05.2016 r.
 */
public class Menu {
    private static void printMenu() {
        System.out.print("1. Dodaj element.\n" +
                "2. Wyszukaj element.\n" +
                "3. Usuń element.\n" +
                "4. Zakończ program.\n" +
                "Co chcesz zrobić? Podaj cyfrę: ");
    }

    public static void main(String[] args) {
        BST<Integer> bst = new BST<>(Integer::compare);
        bst.insert(5, 2, 7, 1, 3, 8, 4, 9);
        Scanner in = new Scanner(System.in);
        int choice;

        do {
            System.out.println(bst);
            printMenu();
            choice = in.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Podaj element, który chcesz dodać: ");
                    bst.insert(in.nextInt());
                    break;
                case 2:
                    System.out.print("Podaj element, który chcesz wyrzukcać: ");
                    if (bst.search(in.nextInt()) != null) {
                        System.out.println("Jest");
                    } else {
                        System.out.println("Nie ma");
                    }
                    break;
                case 3:
                    System.out.print("Podaj element, który chcesz usunąć: ");
                    bst.delete(in.nextInt());
                    break;
            }
        } while (choice != 4);
    }
}

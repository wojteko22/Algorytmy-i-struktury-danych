package lista8;

import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Wojciech Okoński
 *         created on 10.05.2016 r.
 */
public class Main {
    private static void printMenu() {
        System.out.print("\n1. Pobierz i zakoduj ciąg.\n" +
                "2. Pobierz i zdekoduj ciąg, używając ostatnio utworzonego drzewa.\n" +
                "3. Zapisz wynik do pliku.\n" +
                "4. Zakończ program.\n" +
                "Co chcesz zrobić? Podaj cyfrę: ");
    }

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        String result = null;
        Tree<Pair> tree = null;
        int choice;
        do {
            printMenu();
            choice = in.nextInt();
            switch (choice) {
                case 1:
                    String sequence = LoaderAndSaver.load();
                    System.out.println("\nCiąg: " + sequence);
                    tree = Encoder.createTree(Encoder.createList(sequence));
                    System.out.println(tree);
                    Map<Character, String> map = Encoder.createCodeWords(tree);
                    System.out.println(map);
                    result = Encoder.encodeSequence(sequence, map);
                    System.out.println("\nZakodowany ciąg: " + result);
                    break;
                case 2:
                    if (tree == null) {
                        System.out.println("\nJeszcze nie tworzyłeś drzewa!");
                    } else {
                        String encodedSequence = LoaderAndSaver.load();
                        System.out.println("\nCiąg: " + encodedSequence);
                        result = Decoder.decode(encodedSequence, tree);
                        System.out.println("\nZdekodowany ciąg: " + result);
                    }
                    break;
                case 3:
                    if (result == null) {
                        System.out.println("\nNa razie nie ma żadnego wyniku!");
                    } else LoaderAndSaver.save(result);
                    break;
            }
        } while (choice != 4);
    }
}

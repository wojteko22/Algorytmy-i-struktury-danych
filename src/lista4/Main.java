package lista4;

import java.util.ArrayList;
import java.util.Random;

/**
 * @author Wojciech Okoński
 *         created on 09.04.2016 r.
 */
public class Main {
    public static void main(String[] args) {
        // długość listy
        int length = 20;

        // utworzenie listy
        ArrayList<Integer> list = new ArrayList<>(length);

        // wypełnienie listy losowymi liczbami dwucyfrowymi
        for (int i = 0; i < length; i++) {
            list.add(new Random().nextInt(90) + 10);
        }

        // wydruk nieuporządkowanej listy
        System.out.println("Nieuporządkowana:\t" + list.toString());

        // wydruk po sortowaniu bąbelkowym
        System.out.println("Bąbelkowe:\t\t\t" + new BubbleSortListSorter<Integer>(new NaturalComparator<>()).sort(new ArrayList<>(list)));

        // wydruk po sortowaniu przez scalanie
        System.out.println("Scalanie:\t\t\t" + new MergeSortListSorter<Integer>(new NaturalComparator<>()).sort(new ArrayList<>(list)));

        // wydruk po sortowaniu szybkim
        System.out.println("Szybkie:\t\t\t" + new QuickSortListSorter<Integer>(new NaturalComparator<>()).sort(new ArrayList<>(list)));

        // kontrolny wydruk nieuporządkowanej listy po wszystkich sortowaniach
        System.out.println("Nieuporządkowana:\t" + list.toString());

    }
}

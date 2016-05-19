package lista1;

import java.util.Random;

/**
 * @author Wojciech Okoński
 *         created on 11.03.2016 r.
 */
public class Array {
    protected static int[] array;

    public static void createArray(int size) {
        array = new int[size];
        for (int i = 0; i < array.length; i++) {
            array[i] = new Random().nextInt(9000) + 1000;
        }
    }

    public static void printArray() {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
        System.out.println();
    }
}

package lista8;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

/**
 * @author Wojciech Okoński
 *         created on 10.05.2016 r.
 */
class LoaderAndSaver {
    static String load() throws IOException {
        System.out.print("\nPodaj nazwę pliku: ");
        return new String(Files.readAllBytes(Paths.get(new Scanner(System.in).next())));
    }

    static void save(String content) throws IOException {
        System.out.print("\nPodaj nazwę pliku: ");
        Files.write(Paths.get(new Scanner(System.in).next()), content.getBytes(), StandardOpenOption.CREATE);


    }
}

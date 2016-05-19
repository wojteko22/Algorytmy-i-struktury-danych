package lista2;

/**
 * @author Wojciech Okoński
 *         created on 26.03.2016 r.
 */
public class Main {
    public static void main(String[] args) {
        Grupa g = new Grupa();
        Student s1 = new Student("Nowak", 4.5), s2 = new Student("Kowalski", 3.4), s3 = new Student("Wiśniewski", 5.0), s4 = new Student("Wójcik", 2.9);

        g.list.insert(0, s1);
        g.list.insert(0, s2);
        g.list.insert(1, s3);
        g.printListOfStudents();
        System.out.println("Wstawienie Wójcika za indeksem 1: ");
        g.list.insert(1,s4);
        g.printListOfStudents();
        System.out.println("indeks Kowalskiego: " + g.list.find(s2));
        System.out.println("usunięcie osoby o indeksie 1");
        g.list.delete(1);
        g.printListOfStudents();
        System.out.println("indeks Kowalskiego " + g.list.find(s2));


    }
}

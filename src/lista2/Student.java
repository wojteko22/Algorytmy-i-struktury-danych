package lista2;

/**
 * @author Wojciech Okoński
 *         created on 26.03.2016 r.
 */
public class Student {
    private String name;
    private double gradePointAverage;

    public Student(String name, double gradePointAverage) {
        this.name = name;
        this.gradePointAverage = gradePointAverage;
    }

    public String toString() {
        return name + " " + gradePointAverage;
    }
}

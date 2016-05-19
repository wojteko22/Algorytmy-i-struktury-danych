package lista3;

/**
 * @author Wojciech Okoński
 *         created on 03.04.2016 r.
 */

// To było tak tylko dla mnie, ale w sumie to nie potrzebne
public class Main {
    public static void main(String[] args) {
        MyStack m = new MyStack();
        m.push("kot");
        m.push("pies");
        m.push("szczur");
        System.out.println(m);
        System.out.println(m.pop());
        System.out.println(m);
        System.out.println(m.peek());
        System.out.println(m);
    }
}

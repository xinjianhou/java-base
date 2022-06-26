package chapter07;

/**
 * -XX:+UseStringDeduplication
 */
public class StringExr2 {
    public static void main(String[] args) {
        String s1 = new String("abc");
        String s2 = new String("abc");
        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());
    }
}

package chapter07;

public class StringExr1 {

    public static void main(String[] args) {
        //String s = new String("11");
        String s = new String("1") + new String("1");
        s.intern();
        String s1 = "11";
        System.out.println(s == s1);
    }
}

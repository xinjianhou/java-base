package chapter07;

public class StringIntern {
    public static void main(String[] args) {
        String s = new String("1");
        s.intern();
        String s1 = "1";

        System.out.println(s);
        String s2 = s + "ab";
        String s3 = "1ab";
        System.out.println(s2 == s3);


        String s4 = new String("1") + new String("1");//do not generate string pool world 11
        s4.intern();
        String s5 = "11";
        System.out.println(s4 == s5);
    }
}

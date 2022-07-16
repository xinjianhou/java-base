package chapter07;

public class StringTest2 {


    public static final String s1 = "javaEE";
    public static final String s2 = "hadoop";
    public static final String s3 = "javaEEhadoop";
    public static final String s4 = "javaEE" + "hadoop";
    public static final String s5 = s1 + "hadoop";
    public static final String s6;
    static{
        s6 = "javaEE" + s2;
    }
    public static final String s7 = s1 + s2;

    public static void main(String[] args) {

        System.out.println(s3 == s4); // true
        System.out.println(s3 == s5); // false
        System.out.println(s3 == s6); // false
        System.out.println(s3 == s7); // false
        System.out.println(s5 == s6); // false
        System.out.println(s5 == s7); // false
        System.out.println(s6 == s7); // false

        String s8 = s6.intern();
        System.out.println(s3 == s8); // true
    }

}

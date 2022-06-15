package string;

public class StringTest {

    public static void main(String[] args) {
        StringBuilder sb  = new StringBuilder("abc");
        StringBuilder sb2 = sb;

        sb.append("cde");
        System.out.println(sb2);
    }
}

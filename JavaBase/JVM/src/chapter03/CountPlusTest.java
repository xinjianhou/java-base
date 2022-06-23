package chapter03;

public class CountPlusTest {

    public static void main(String[] args) {
        int i = 10;
        i++;
//        int j = 10;
//        ++j;
        System.out.println(i);//11
//        System.out.println(j);//11

        int k = 10;
        int m = k++;

        int l = 10;
        int n = ++l;
        System.out.println(m);//10
        System.out.println(n);//11

        int x = 10;
        int y = x++ + ++x + 10;
        System.out.println(y);//32
    }
}

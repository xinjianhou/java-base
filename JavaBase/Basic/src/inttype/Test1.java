package inttype;

public class Test1 {

    public static void main(String[] args) {
        int i = 1; //i = 1;
        i = i++; // i = 1;
        System.out.println(i);//1
        int j = i++; //j =1; i = 2;
        System.out.println(i);//2
        int k = ++i; //k = 3
        int l = i+ ++i * i++;// 19 = 3 + 4 * 4


        System.out.println(i);//5
        System.out.println(j);//1
        System.out.println(k);//3
        System.out.println(l);//19

    }

}


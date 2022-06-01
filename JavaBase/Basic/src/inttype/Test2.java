package inttype;

public class Test2 {
    static int s;
    int i;
    int j;

    {
        int i = 1;
        i++;
        j++;
        s++;

    }

    public void test(int j) {
        j++;
        i++;
        s++;
    }
 
    public static void main(String[] args) {
        //s是static。。。
        Test2 t1 = new Test2();//0,1,1
        Test2 t2 = new Test2();//0,1,2
        System.out.println(t1.i + "," + t1.j + "," + t1.s);//0，1，2
        t1.test(10);//1,1,3
        t1.test(20);//2,1,4
        t2.test(30);//1,1,5
        System.out.println(t1.i + "," + t1.j + "," + t1.s);//2,1,5
        System.out.println(t2.i + "," + t2.j + "," + t2.s);//1,1,5
    }
}

package classload;

public class Test {
    //基本数据类型值传递，
    //引用类型传递地址
    public static void main(String[] args) {
        int i = 1;
        String s = "hello ";
        Integer j = 200;
        int[] nums = {1,2,3,4,5};
        MyData my = new MyData();
        change(i, s, j, nums, my);


        System.out.println(i); //1
        System.out.println(s); //hello
        System.out.println(j);//200 包装类和string不可变，形参指向了新地址
        System.out.println(nums[0]);//2
        System.out.println(my.a);//11

    }

    private static void change(int k, String s, Integer n, int[] a, MyData m) {
        k += 1;
        s += "world";
        n += 1;
        a[0] +=1;
        m.a += 1;;
        m = new MyData();

    }

}
class MyData{
    int a = 10;
}

package classload;

public class Son extends Father{


    private static int x = initMethod();

    static{
        System.out.println(12);
    }
    {
        System.out.println(14);
    }
    private String test = test();
    public Son(){
        //super()不管写没写都调用
        System.out.println(15);
    }

    private String test(){
        System.out.println(13);
        return "hello";
    }
    private static int initMethod() {
        System.out.println(11);
        return 10;
    }
    public static void main(String[] args) {
        Son s = new Son();
        System.out.println("----------");
        new Son();
    }
}



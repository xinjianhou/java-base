package classload;

public class Father {

    private String test = test();



    static{
        System.out.println(2);
    }
    private static int x = initMethod();
    public Father(){
        System.out.println(5);
    }
    {
        System.out.println(4);
    }


    private String test(){
        System.out.println(3);
        return "hello";
    }
    private static int initMethod() {
        System.out.println(1);
        return 10;
    }
}

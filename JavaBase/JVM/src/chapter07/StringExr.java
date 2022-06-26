package chapter07;

public class StringExr {

    String str = new String("good");
    char[] ch = {'t', 'e', 's', 't'};
    public void change(String str, char ch[]){
        str = "test ok";
        ch[0] = 'b';
    }

    public static void main(String[] args) {
        StringExr ex = new StringExr();
        ex.change(ex.str, ex.ch);
        System.out.println(ex.str);//test ok
        System.out.println(ex.ch);//best
    }
}

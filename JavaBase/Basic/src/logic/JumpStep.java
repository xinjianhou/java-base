package logic;

public class JumpStep {

    public static void main(String[] args) {

        System.out.println(count(5));

    }

    public static int count(int n){

        if(n==1 || n ==2){
            return n;
        }{
           return count(n - 1) + count(n - 2);
        }


    }
}

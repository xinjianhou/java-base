package logic;

public class JumStep2 {
    public static void main(String[] args) {
        System.out.println(count(5));


    }

    public static int count(int n) {

        if (n == 1 || n == 2) {
            return n;
        } else {
            int beforePre = 1;//初始化前一步的走法
            int pre = 2;//初始化上一步的走法
            int sum = 0;

            for (int i = 3; i <= n; i++) {
               sum = beforePre + pre;
                //重置上一步和前一步
               beforePre=pre;
               pre=sum;
            }
            return sum;
        }


    }
}

public class demo1 {
    public static void main(String[] args) {
        test(5);
        //阶乘
        //System.out.println(factorial(3));
    }

    public static void test(int n) {
        if (n > 2) {
            //test(4)->test(3)->test(2) 栈
            test(n - 1);
        }
        System.out.println("n:" + n);
    }
    public static int factorial(int n){
        if(n==1){
            return 1;
        }else{
            return factorial(n-1)*n;
        }
    }
}

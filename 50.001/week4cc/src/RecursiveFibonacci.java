public class RecursiveFibonacci {

    public static void main(String[] args) {
        System.out.println(fib(9));
    }

    public static int fib(int n) {
        if (n > 2) {
            return fib(n-1) + fib(n-2);
        } else if (n == 2)
            return 1;
        else if (n == 1)
            return 0;
        return 0;
    }
}

package session1;

import session1.Fibonacci;

public class Main {

    public static void main(String[] args) {

//        int n = 5;
//        n = Integer.parseInt(args[0]);
        String ans = "";

        Fibonacci fibo = new Fibonacci();
        ans = fibo.fibonacci(5);

        System.out.println(ans);
    }

}

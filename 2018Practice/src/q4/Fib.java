package q4;

//starting code
public class Fib {

    public static void main(String[] args) {
        System.out.println(recurFib(3));
        System.out.println(recurFib(5));
        System.out.println(recurFib(10));
    }

    public static int recurFib(int idx) {
        switch (idx) {
            case 0:
                return 0;
            case 1:
                return 1;
        }
        return (recurFib(idx-1) + recurFib(idx-2));
    }
}

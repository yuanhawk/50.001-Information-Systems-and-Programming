package homework1_1;

public class PrimeNumberChecker {

    public static void main(String[] args) {
        System.out.println(isPrime(11));
    }

    public static int isPrime(int num){
        int val = num;

        for (int i = 2; i < num; i++) {
            while (val % i == 0) {
                val /= i;
            }

            if (val == 1) {
                return 0;
            }
        }
        return 1;
    }
}
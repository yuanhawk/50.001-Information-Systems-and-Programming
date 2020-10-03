package homework1_1;

import java.util.ArrayList;

public class PrimeNumberCheckerSieve {

    public static void main(String[] args) {
        System.out.println(isPrime(7));
    }

    private static int isPrime(int N) {
        if (N <= 1) {
            return 0;
        }

        ArrayList<Integer> primeList = sieve(N);
        if (primeList.contains(N)) {
            return 1;
        }
        return 0;
    }

    private static ArrayList<Integer> sieve(int N) { // SieveOfEratosthenes algo
        ArrayList<Integer> primeList = new ArrayList<>();
        // init out numbers array, where true denotes primarlity
        boolean[] isPrime = new boolean[N];
        isPrime[0] = false;
        for (int c = 1; c < N; c++) {
            isPrime[c] = true;
        }

        // check every number >= 2 for primarlity
        for (int i = 2; i <= N; i++) {

            // i is prime if hasn't been "crossed off" yet
            if (isPrime[i - 1]) {
                // print out prime number
                primeList.add(i);

                // "cross off" all the subsequent multiples of i
                for (int j = i * i; j <= N; j += i) {
                    isPrime[j - 1] = false;
                }
            }
        }
        return primeList;
    }
}

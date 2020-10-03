package homework1_1;

import java.util.Scanner;

public class SieveOfEratosthenes {

    /**
     * Print all the prime numbers less than a given number N using the sieve of Eratosethenes
     * https://www.rookieslab.com/posts/fastest-way-to-check-if-a-number-is-prime-or-not
     */

    public static void main(String[] args) {

        // get the ceiling on our prime numbers
        int N;
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the prime number ceiling: ");
        N = sc.nextInt();
        sc.close();

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
                System.out.println(i);

                // "cross off" all the subsequent multiples of i
                for (int j = i * i; j <= N; j += i) {
                    isPrime[j - 1] = false;
                }
            }
        }
    }
}

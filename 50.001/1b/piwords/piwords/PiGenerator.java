package piwords;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PiGenerator {
    /**
     * Returns precision hexadecimal digits of the fractional part of pi.
     * Returns digits in most significant to least significant order.
     * 
     * If precision < 0, return null.
     * 
     * @param precision The number of digits after the decimal place to
     *                  retrieve.
     * @return precision digits of pi in hexadecimal.
     */

    public static int[] computePiInHex(int precision) {
        // TODO: Implement (Problem b)
        if (precision < 0) return null;

        int[] piArray = new int[precision];
        int count = 0;
        for (int i = 1; i < precision + 1; i++) {
            piArray[count] = PiGenerator.piDigit(i);
            count++;
        }

//        double pi = 0.0;
//        for (int i = 0; i < precision; i++) {
//            pi += PiGenerator.piDigit(i) * Math.pow(16, -i);
//        }
//
//        String piString = String.valueOf(pi);
//        System.out.println(piString);
//        int[] piArray = new int[precision];
//
//        int count = 0;
//        for (int j = 2; j < precision + 2; j++) {
//            piArray[count] = (int) piString.charAt(j) - '0';
//            count++;
//        }

        return piArray;
    }

    /**
     * Computes a^b mod m
     * 
     * If a < 0, b < 0, or m <= 0, return -1.
     * 
     * @param a
     * @param b
     * @param m
     * @return a^b mod m
     */
    public static int powerMod(int a, int b, int m) {
        // TODO: Implement (Problem a)

        if (a < 0 || b < 0 || m <= 0) return -1;

        BigInteger bi1, bi2, bi3;

        BigInteger exponent = new BigInteger(String.valueOf(b));
        bi1 = new BigInteger(String.valueOf(a));
        bi2 = new BigInteger(String.valueOf(m));

        // bi3 = a^b mod m
        bi3 = bi1.modPow(exponent, bi2);
        return bi3.intValue();
//        int res = 1;
//
//        if (a < 0 || b < 0 || m <= 0) return -1;
//
//        while (b > 0) {
//            if (b % 2 == 1)
//                res = (res * a) % m;
//
//            b = b >> 1;
//            a = (a * a) % m;
//        }
//        return res;
    }


    
    /**
     * Computes the nth digit of Pi in base-16.
     * 
     * If n < 0, return -1.
     * 
     * @param n The digit of Pi to retrieve in base-16.
     * @return The nth digit of Pi in base-16.
     */
    public static int piDigit(int n) {
        if (n < 0) return -1;
        
        n -= 1;
        double x = 4 * piTerm(1, n) - 2 * piTerm(4, n) -
                   piTerm(5, n) - piTerm(6, n);
        x = x - Math.floor(x);
        
        return (int)(x * 16);
    }
    
    private static double piTerm(int j, int n) {
        // Calculate the left sum
        double s = 0;
        for (int k = 0; k <= n; ++k) {
            int r = 8 * k + j;
            s += powerMod(16, n-k, r) / (double) r;
            s = s - Math.floor(s);
        }
        
        // Calculate the right sum
        double t = 0;
        int k = n+1;
        // Keep iterating until t converges (stops changing)
        while (true) {
            int r = 8 * k + j;
            double newt = t + Math.pow(16, n-k) / r;
            if (t == newt) {
                break;
            } else {
                t = newt;
            }
            ++k;
        }
        
        return s+t;
    }
}

package piwords;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

public class BaseTranslator {
    /**
     * Converts an array where the ith digit corresponds to (1 / baseA)^(i + 1)
     * digits[i], return an array output of size precisionB where the ith digit
     * corresponds to (1 / baseB)^(i + 1) * output[i].
     * 
     * Stated in another way, digits is the fractional part of a number
     * expressed in baseA with the most significant digit first. The output is
     * the same number expressed in baseB with the most significant digit first.
     * 
     * To implement, logically, you're repeatedly multiplying the number by
     * baseB and chopping off the most significant digit at each iteration:
     * 
     * for (i < precisionB) {
     *   1. Keep a carry, initialize to 0.
     *   2. From RIGHT to LEFT
     *   	a. x = multiply the jth digit by baseB and add the carry
     *          b. the new jth digit is x % baseA
     *          c. carry = x / baseA
     *   3. output[i] = carry
     * }
     * If digits[j] < 0 or digits[j] >= baseA for any j, return null
     * If baseA < 2, baseB < 2, or precisionB < 1, return null
     * 
     * @param digits The input array to translate. This array is not mutated.
     * @param baseA The base that the input array is expressed in.
     * @param baseB The base to translate into.
     * @param precisionB The number of digits of precision the output should
     *                   have.
     * @return An array of size precisionB expressing digits in baseB.
     */

    // piHexDigits (base 16), 16, 26, PI_PRECISION
    public static int[] convertBase(int[] digits, int baseA,
                                    int baseB, int precisionB) {
        // TODO: Implement (Problem c)

        if (baseA < 2 || baseB < 2 || precisionB < 1) return null;

        int[] input = digits;
        int[] output = new int[precisionB];
        for (int i = 0; i < precisionB; i++) {
            // int carry = 0
            BigInteger carry = new BigInteger("0");
            for (int j = digits.length - 1; j > -1; j--) {
                if (digits[j] < 0 || digits[j] >= baseA)
                    return null;

                BigInteger biA = new BigInteger(String.valueOf(baseA));
                // x = digits[j] * baseB + carry
                BigInteger x = new BigInteger(String.valueOf(digits[j] * baseB)).add(carry);
                // x % baseA
                input[j] = x.mod(biA).intValue();
                // carry = x / baseA
                carry = x.divide(biA);
            }
            output[i] = carry.intValue();
        }

//        BigDecimal pi = new BigDecimal("0.0");
//        int count = 0;
//        for (int i = 1; i < precisionB; i++) {
//            pi = pi.add(new BigDecimal(String.valueOf(digits[count] * Math.pow(baseA, -i))));
//            count++;
//        }
//
//        int[] output = new int[precisionB];
//        BigDecimal val = pi;
//
//        BigDecimal out = val.setScale(0, RoundingMode.FLOOR);
//        BigDecimal decimals = val.subtract(out);
//        for (int j = 0; j < precisionB; j++) {
//            val = decimals.multiply(new BigDecimal(String.valueOf(baseB)));
//            out = val.setScale(0, RoundingMode.FLOOR);;
//
//            output[j] = out.intValue();
//            decimals = val.subtract(out);
//        }
        return output;
    }
}

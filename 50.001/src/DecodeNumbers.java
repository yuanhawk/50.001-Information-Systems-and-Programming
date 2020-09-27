public class DecodeNumbers {

    public static void main(String[] args) {
        checkNumber("1234");
    }

    private static void checkNumber(String line) {
        int i = 0;
        try {
            i = Integer.parseInt(line);
        } catch (NumberFormatException e) {

        }

        int count = 0;
        while (i > 0) {
            i /= 10;
            count++;
        }
        System.out.println(count);
    }
}

//    Print out the different number of ways it can be decoded. Note: 12 could be decoded as AB(1 2) or L(12). Hence the number of ways to decode 12 is 2.
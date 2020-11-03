package homework3_5;

public class Palindrome {

    public static boolean isPalindrome (char[] S) {
        switch (S.length) {
            case 0:
            case 1:
                return true;
        }

        char[] s = new char[S.length - 2];
        if (S[0] == S[S.length - 1]) {
            int j = 0;
            for (int i = 1; i < S.length - 1; i++) {
                s[j] = S[i];
                j++;
            }
            return isPalindrome(s);
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(Palindrome.isPalindrome(new char[]{'1', '2', '3', '4', '2', '1'}));
    }

}

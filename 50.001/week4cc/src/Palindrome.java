public class Palindrome {

    public static void main(String[] args) {
        char[] s = {'a', 'b', 'b', 'a'};
        System.out.println(isPalindrome(s));
    }

    public static boolean isPalindrome(char[] s) {

//        if (s[0] != s[s.length - 1])
//            return false;
//        else
//            return isPalindrome(s);

        if (s.length > 1) {
            if (s[0] == s[s.length - 1]) {
                char[] str = new char[s.length - 2];
                int count = 0;
                for (int i = 1; i < s.length - 1; i++) {
                    str[count] = s[i];
                    count++;
                }
                isPalindrome(str);
            } else {
                return false;
            }
        } else if (s.length == 1)
            return true;
        else
            return true;

        return false;
    }
}


import java.lang.reflect.Array;
import java.util.*;
import java.util.Arrays;
//import ArrayUtil
public class Palindrome {
    public static boolean isPalindrome(char[] S) {
        //do a divide and conquer strategy using recursion
        if (S.length == 1||S.length==0) {
            return true;
        }

        //check the first and last characters
        if (S[0] != S[S.length - 1]) {
            return false;
        }
        else {
            //remove the last character from the string
            //S.shiftChar();
            //S.pop();
            char[] newArray = Arrays.copyOfRange(S, 2, S.length-2);
            return isPalindrome(newArray);
        }
    }

    public static void main(String[] args){
        Palindrome a = new Palindrome();
        System.out.println(Palindrome.isPalindrome(new char[]{'a', 'b', 'b', 'a'}));
        System.out.println(Palindrome.isPalindrome(new char[]{'a', 'd', 'b', 'c','b','a'}));
        System.out.println(Palindrome.isPalindrome(new char[]{'Z', 'Z', 'a', 'Z','Z'}));
        System.out.println(Palindrome.isPalindrome(new char[]{'1', '2', '3', '4','2','1'}));
    }
}


/* ATTENTION
The method isPalindrome() returns true if the input string is a palindrome, and false otherwise.
It is NOT NECESSARY to do any System.out.println() of "abba is a palindrome" etc.
*/

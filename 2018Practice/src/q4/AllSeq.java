package q4;

import java.util.ArrayList;
import java.util.Arrays;


//starting code


public class AllSeq {

    public static void main(String[] args) {
        String[] s = {"p", "q"};
        System.out.println(compAllSeq(s, 3));

        String[] s2 = {"1", "2", "3", "4"};
        System.out.println(compAllSeq(s2, 1));


    }


    public static ArrayList<String> compAllSeq(String[] s, int k) {
        if (k == 1)
            return new ArrayList<>(Arrays.asList(s));
        else {
            ArrayList<String> l = compAllSeq(s, k - 1);
            ArrayList<String> l1 = new ArrayList<>();

            for (String str : l) {
                for (String ch : s) {
                    String str1 = ch + str;
                    l1.add(str1);
                }
            }
            return l1;
        }
    }
}


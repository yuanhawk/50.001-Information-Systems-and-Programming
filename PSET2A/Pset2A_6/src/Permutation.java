import java.util.ArrayList;

public class Permutation {
    private String in;
    private ArrayList<String> a = new ArrayList<String>();
    // additional attribute if needed
    private char[] char_arr;
    private int current_index;

    Permutation(final String str){
        in = str;
        // additional initialization if needed
        char_arr = in.toCharArray();
        current_index = 0;

    }

    public void permute(){
        // produce the permuted sequence of 'in' and store in 'a', recursively
        //create the base case: do until the whole length of the string

        if(current_index== char_arr.length-1){
            a.add(String.valueOf(char_arr));
        }
        else {
            for (int i = current_index; i < char_arr.length; i++) {
                swap(char_arr, current_index , i);
                current_index++;
                //System.out.println(char_arr);
                permute();
                //error is here
                //System.out.println(char_arr);
                current_index--;
                swap(char_arr, current_index, i);
            }
        }

    }
    private static char[] swap(char[] char_arr, int i, int j){

        char temp = char_arr[i];
        char_arr[i] = char_arr[j];
        char_arr[j] = temp;
        return char_arr;

    }

    public ArrayList<String> getA(){
        return a;
    }



    public static void main(String[]args){
        ArrayList<String> v;
        Permutation P =new Permutation("hat");
        P.permute();
        v = P.getA();
        System.out.println(v);
    }
}
//[hat, hta, aht, ath, tah, tha]

/*import java.util.*;

public class Permutation {
    private final String in;
    private ArrayList<String> a = new ArrayList<String>();
    // additional attribute if needed
    private static int left = 0;
    private final int right;
    private static char[] output;


    Permutation(final String str){
        in = str;
        // additional initialization if needed
        right = str.length() - 1;
        output = in.toCharArray();

    }

    public void permute(){
        // produce the permuted sequence of 'in' and store in 'a', recursively
        if (left == right){
            a.add(String.valueOf(output));
        }
        else {
            for (int i = left; i <= right; i++){
                output = swap(output,left,i);
                left++;
                permute();
                left--;
                output = swap(output,left,i);
            }
        }
    }


    private static char[] swap(char[] chars, int i, int j){

        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
        return chars;

    }

    public ArrayList<String> getA(){
        return a;
    }
    public static void main(String[]args){
        ArrayList<String> v;
        Permutation P =new Permutation("hat");
        P.permute();
        v = P.getA();
        System.out.println(v);
    }
}*/






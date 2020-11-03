package homework3_6;

import java.util.ArrayList;

public class Permutation {
    private final String in;
    private ArrayList<String> a = new ArrayList<>();
    // additional attribute if needed



    public Permutation(final String str) {
        // additional initialization if needed
        in = str;
    }

    public void permute() { // find midpt
        // produce the permuted sequence of 'in' and store in 'a', recursively
        permute("", in);
    }

    public void permute(String perm, String in) {
        if (in.isEmpty())
            a.add(perm + in);
        else {
            for (int i = 0; i < in.length(); i++) {
                permute(perm + in.charAt(i), in.substring(0, i) + in.substring(i + 1));
            }
        }
    }

    public ArrayList<String> getA(){
        return a;
    }

    public static void main(String[] args) {
        ArrayList<String> v;

        Permutation p = new Permutation("hat");
        p.permute();
        v = p.getA();
        System.out.println(v);
    }
}
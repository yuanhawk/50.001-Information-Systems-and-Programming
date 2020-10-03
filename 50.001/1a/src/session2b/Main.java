package session2b;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args)
    {
        String test = args[0];
        String answerFileName = args[1];

////****
        String ans="";

        if(test.equals("1")){
            System.out.println("Test case 1");
            IteratingExamples iteratingexamples = new IteratingExamples();
            List<Integer> integers = new ArrayList<Integer>();
            integers.add(1);
            integers.add(2);
            integers.add(3);
            integers.add(4);
            integers.add(5);
            integers.add(6);
            integers.add(7);
            integers.add(8);
            integers.add(9);
            integers.add(10);
            String ans1 = "" + iteratingexamples.Act2ForEach(integers);
            ans = "ForEach Sum = " + ans1;
        }
////****
        System.out.println("!LOGOUTPUT");//must be the last print
        System.out.println(ans);

    }
}

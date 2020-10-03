package session2b;

import java.util.List;

public class IteratingExamples {

    public String Act2ForEach(List<Integer> integers) {
        int sum = 0;
        for (int i: integers) {
            sum += i;
        }
        return String.valueOf(sum);
    }
}

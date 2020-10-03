package session1;

import java.util.ArrayList;

public class Fibonacci {
    public String fibonacci(int n) {
        String overall = "";
        switch (n) {
            case 1:
                return overall += String.valueOf(0);
            case 2:
                return overall += String.valueOf(0) + ", " + String.valueOf(1);
        }

        int previous = 0, result = 0, next = 1;
        if (n > 2) {
            overall += String.valueOf(0) + ", " + String.valueOf(1);
            for (int i = 2; i < n; i++) {
                result = previous + next;
                previous = next;
                next = result;
                overall = overall + ", " + String.valueOf(result);
            }
        }
        return overall;
    }
}

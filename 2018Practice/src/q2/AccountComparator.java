package q2;

import java.util.Comparator;
//starting code
public class AccountComparator implements Comparator<Account> {

    @Override
    public int compare(Account a1, Account a2) {
        char[] a1Char = a1.getId().toCharArray();
        char[] a2Char = a2.getId().toCharArray();

        for (int i = 0; i < a1Char.length; i++) {
            if (a1Char[i] < a2Char[i])
                return -1;
            else if (a1Char[i] > a2Char[i])
                return 1;
        }
        return 0;
    }
}


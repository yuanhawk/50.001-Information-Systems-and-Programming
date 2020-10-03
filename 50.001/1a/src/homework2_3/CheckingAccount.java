package homework2_3;

import session3.Account;

public class CheckingAccount extends Account {

    private double overdraft = 5000.0;

    public CheckingAccount() {
    }

    public CheckingAccount(int id, double balance) {
        super(id, balance);
    }

    @Override
    public void withdraw(double amount) {
        super.withdraw(amount);

        if (super.getBalance() < -5000) {
            super.setBalance(-5000);
            System.out.println("over limit");
        }
    }
}

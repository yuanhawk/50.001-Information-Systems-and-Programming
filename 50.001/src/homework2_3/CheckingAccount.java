package homework2_3;

import session3.Account;

public class CheckingAccount extends Account {

    private int id = 0;
    private double balance = 0.0;

    public CheckingAccount() {
    }

    public CheckingAccount(int id, double balance) {
        super(id, balance);
        this.id = id;
        this.balance = balance;
    }

    @Override
    public void deposit(double amount) {
        super.deposit(amount);
        balance += amount;
    }

    @Override
    public void withdraw(double amount) {
        super.withdraw(amount);
        balance -= amount;

        if (balance < -5000) {
            deposit(amount);
            System.out.println("over limit");
        }
    }
}

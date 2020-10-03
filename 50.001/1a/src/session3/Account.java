package session3;

import java.util.Date;

public class Account {

    private int id = 0;
    private double balance = 0.0;
    private static double annualInterestRate = 0.0;

    private Date dateCreated;

    public Account() {
        this.annualInterestRate = annualInterestRate;
    }

    public Account(int id, double balance) {
        this.id = id;
        this.balance = balance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getAnnualInterestRate() {
        return Account.annualInterestRate;
    }

    public static void setAnnualInterestRate(double amount) {
        annualInterestRate = amount;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public double getMonthlyInterestRate() {
        return annualInterestRate / 12;
    }

    public double getMonthlyInterest() {
        return balance * (getMonthlyInterestRate() / 100);
    }

    public void withdraw(double amount) {
        balance -= amount;
    }

    public void deposit(double amount) {
        balance += amount;
    }
}

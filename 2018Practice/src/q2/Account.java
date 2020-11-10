package q2;

import java.util.Date;

//starting code
public class Account implements Comparable<Account> {

    private String id;
    private double balance;
    private Date dateCreated;

    public Account(String id, double balance) {
        this.id = id;
        this.balance = balance;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    @Override
    public String toString() {
        return "Account:" + id;
    }

    @Override
    public int compareTo(Account account) {
        if (this.balance > account.balance)
            return 1;
        else if (this.balance == account.balance)
            return 0;
        else
            return -1;
    }
}


package RaceCondition;

public class BankAccount {
    public final int accountNumber = 5349;
    public double balance = 10000.00;

    public int getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void deposit(double amount) {
        double newBalance = balance += amount;
        setBalance(newBalance);
    }

    public void withdraw(double amount) {
        double newBalance = balance -= amount;
        setBalance(newBalance);
    }
}

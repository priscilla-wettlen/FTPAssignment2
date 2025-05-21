package RaceCondition;

import java.util.Random;

public class Client1 implements Runnable {
    private final int clientID = 1;
    private int nbrOfTransactions;
    private BankAccount bankAccount;
    private boolean running;
    private Random random = new Random();
    private double newBalance;
    private double updatedBalance;
    private double transactionsTotal;

    public Client1(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    public double getUpdatedBalance() {
        return updatedBalance;
    }

    public void setUpdatedBalance(double updatedBalance) {
        this.updatedBalance = updatedBalance;
    }

    public double getNewBalance() {
        return newBalance;
    }

    public void setNewBalance(double newBalance) {
        this.newBalance = newBalance;
    }

    public double getTransactionsTotal() {
        return transactionsTotal;
    }

    public void performTransaction() {
        double amount = random.nextDouble(1000.00);
        boolean isDeposit = random.nextBoolean();

        if (isDeposit) {
            bankAccount.deposit(amount);
            transactionsTotal += amount;
            nbrOfTransactions++;
            updatedBalance = bankAccount.getBalance();
        } else {
                if (bankAccount.getBalance() >= amount) {
                    bankAccount.withdraw(amount);
                    transactionsTotal -= amount;
                    nbrOfTransactions++;
                }
            updatedBalance = bankAccount.getBalance();
        }

    }



    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            performTransaction();
        }

    }


}

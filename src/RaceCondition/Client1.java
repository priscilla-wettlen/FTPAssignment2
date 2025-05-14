package RaceCondition;

import java.util.Random;

public class Client1 implements Runnable {
    private final int clientID = 1;
    private int totalTransactions;
    private BankAccount bankAccount;
    private boolean running;
    private Random random = new Random();
    private double newBalance;

    public Client1(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    public int getClientID() {
        return clientID;
    }

    public int getTotalTransactions() {
        return totalTransactions;
    }

    public void setTotalTransactions(int totalTransactions) {
        this.totalTransactions = totalTransactions;
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    public void performTransaction() {
        double balance = bankAccount.getBalance();
        double amount = 1000.00;
        boolean isDeposit = random.nextBoolean();

        if (isDeposit) {
            bankAccount.deposit(amount);
            newBalance = balance + amount;
            bankAccount.setBalance(newBalance);
            totalTransactions++;
            System.out.println("Client " + clientID + " transaction deposited: " + amount + " to " + newBalance);
            System.out.println("New balance: " + balance);
            System.out.println("Total transactions of Client 1: " + totalTransactions);
        } else {
            if (balance >= amount) {
                bankAccount.withdraw(amount);
                newBalance = balance - amount;
                totalTransactions++;
                System.out.println("Client " + clientID + " transaction withdrew: " + amount + " to " + newBalance);
                System.out.println("New balance: " + balance);
                System.out.println("Total transactions of Client 1: " + totalTransactions);
            }
        }
    }


    @Override
    public void run() {
        running = true;
        while (running) {
            performTransaction();
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }


}

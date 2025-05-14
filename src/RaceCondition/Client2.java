package RaceCondition;

import java.util.Random;

public class Client2 implements Runnable {
    private final int clientID = 2;
    private int totalTransactions;
    private BankAccount bankAccount;
    private boolean running;
    private Random random = new Random();
    private double newBalance;

    public Client2(BankAccount bankAccount) {
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
            System.out.println("New balance: " + newBalance);
            System.out.println("Total transactions of Client 2: "+ totalTransactions);
        } else {
            if (balance >= amount) {
                bankAccount.withdraw(amount);
                newBalance = balance - amount;
                totalTransactions++;
                System.out.println("Client " + clientID + " transaction withdrew: " + amount + " to " + newBalance);
                System.out.println("New balance: " + newBalance);
                System.out.println("Total transactions of Client 2: " + totalTransactions);
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

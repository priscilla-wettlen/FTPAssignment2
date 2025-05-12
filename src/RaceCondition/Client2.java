package RaceCondition;

public class Client2 implements Runnable {
    private final String name = "Client2";
    private final int accountNum = 5349;
    private BankAccount bankAccount;
    private boolean sufficientFunds = true;

    public Client2(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    public String getName() {
        return name;
    }

    public int getAccountNum() {
        return accountNum;
    }

    public synchronized void withdraw2(double amount) {
        System.out.println(bankAccount.getBalance());
        double newBalance = bankAccount.getBalance();
        while (sufficientFunds) {
            newBalance = bankAccount.getBalance() - amount;
            bankAccount.setBalance(newBalance);
            System.out.println(newBalance + " client 2 withdraw");
            if(bankAccount.getBalance() < amount) {
                sufficientFunds = false;
                System.out.println(newBalance + " client 2 end");
            }
        }


    }

    @Override
    public void run() {
        withdraw2(4532.32);

        try{
            Thread.sleep(1000);
        }catch(InterruptedException e){
            Thread.currentThread().interrupt();
        }
    }
}

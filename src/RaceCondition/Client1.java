package RaceCondition;

public class Client1 implements Runnable {
    private final String name = "Client1";
    private final int accountNum = 5349;
    private BankAccount bankAccount;
    private boolean sufficientFunds = true;

    public Client1(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    public String getName() {
        return name;
    }

    public int getAccountNum() {
        return accountNum;
    }

    //TODO Add sleep?
    public synchronized void withdraw1(double amount) {
        System.out.println(bankAccount.getBalance());
        double newBalance = bankAccount.getBalance();
        while (sufficientFunds) {
            newBalance = bankAccount.getBalance() - amount;
            bankAccount.setBalance(newBalance);
            System.out.println(newBalance + " client 1 withdraw");
            if(bankAccount.getBalance() < amount) {
                sufficientFunds = false;
                System.out.println(newBalance + " client 1 end");
            }
        }


    }

    @Override
    public void run() {
        withdraw1(2345.55);

        try{
            Thread.sleep(1);
        }catch(InterruptedException e){
            Thread.currentThread().interrupt();
        }
    }
}

package RaceCondition;

public class Bankomat {
    private Client1 client1;
    private Client2 client2;
    private BankAccount bankAccount;
    private Thread c1Thread;
    private Thread c2Thread;

    public Bankomat(Client1 client1, Client2 client2, BankAccount bankAccount) {
        this.client1 =  client1;
        this.client2 = client2;
        this.bankAccount = bankAccount;

    }

    public void createTransaction(){
        c1Thread = new Thread(client1);
        c2Thread = new Thread(client2);

        c1Thread.start();
        c2Thread.start();
    }




}

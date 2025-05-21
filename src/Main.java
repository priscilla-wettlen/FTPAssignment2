import RaceCondition.BankAccount;
import RaceCondition.Bankomat;
import RaceCondition.Client1;
import RaceCondition.Client2;

public class Main {
    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount(1000);
        Client1 client1 = new Client1(bankAccount);
        Client2 client2 = new Client2(bankAccount);

        Bankomat bankomat = new Bankomat(client1, client2, bankAccount);
        double initialBalance = bankAccount.getBalance();

        bankomat.createTransaction();

        double totalTransactions = client1.getTransactionsTotal() + client2.getTransactionsTotal();
        double expectedBalance = initialBalance + totalTransactions;

        System.out.println("Initial Balance: " + initialBalance);
        System.out.println("Sum of All Client Transactions: " + totalTransactions);
        System.out.println("Expected Balance: " + expectedBalance);
        System.out.println("Actual Balance: " + bankAccount.getBalance());

    }
}

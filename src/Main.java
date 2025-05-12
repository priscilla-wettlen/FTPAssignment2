import RaceCondition.BankAccount;
import RaceCondition.Bankomat;
import RaceCondition.Client1;
import RaceCondition.Client2;

public class Main {
    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount();
        Client1 client1 = new Client1(bankAccount);
        Client2 client2 = new Client2(bankAccount);

        Bankomat bankomat = new Bankomat(client1, client2, bankAccount);
        bankomat.createTransaction();

    }
}

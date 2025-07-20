import java.util.Scanner;

public class BankAccount {

    private String IBAN;
    private double balance = 0;

    Scanner scanner = new Scanner(System.in);

    BankAccount(String IBAN) {
        this.IBAN = IBAN;
    }

    public void deposit() {
        System.out.println("Please enter deposit");
        var  amount = scanner.nextDouble();
        balance += amount;
    }

    public void withdraw() {
        System.out.println("Please enter deposit");
        var  amount = scanner.nextDouble();
        if (balance < amount) {
            System.out.println("Insufficient funds");
        }
        else balance -= amount;
    }
    public double getBalance() {
        return balance;
    }
}

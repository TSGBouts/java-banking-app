import java.util.Scanner;

public class Account {

    private final short accountNumber;
    private double balance = 0;

    Scanner scanner = new Scanner(System.in);

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

    public Account(short accountNumber) {
        this.accountNumber = accountNumber;
    }

    public short getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }
}
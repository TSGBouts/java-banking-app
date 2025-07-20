import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Account {

    private final short accountNumber;
    private double balance = 0;
    private BankAccount bankAccount;
    private SavingsAccount savingsAccount;

    private final Map<String,String> ibanMap = new HashMap<>();

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

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public SavingsAccount getSavingsAccount() {
        return savingsAccount;
    }

    public void setBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
        ibanMap.put(bankAccount.getClass().getSimpleName(), bankAccount.getIBAN());
        System.out.println(getBankAccount().getIBAN());
    }

    public void setSavingsAccount(SavingsAccount savingsAccount) {
        this.savingsAccount = savingsAccount;
        ibanMap.put(savingsAccount.getClass().getSimpleName(), savingsAccount.getIBAN());
        System.out.println(getSavingsAccount().getIBAN());
    }

    public Map<String,String> getIbanMap() {
        return ibanMap;
    }
}
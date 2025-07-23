import java.util.*;

public class Account {

    private final int accountNumber;
    private double balance = 0;
    private CheckingAccount checkingAccount;
    private SavingsAccount savingsAccount;
    private final List<TransactionHistory>  transactionHistoryList =  new ArrayList<>();

    private final Map<String,String> ibanMap = new HashMap<>();

    Scanner scanner = new Scanner(System.in);

    public void deposit() {
        System.out.print("Please enter deposit: ");
        var  amount = Double.parseDouble(scanner.nextLine());
        balance += amount;
    }

    public void withdraw() {
        System.out.print("Please enter withdrawal amount: ");
        var  amount = Double.parseDouble(scanner.nextLine());
        if (balance < amount) {
            System.out.println("Insufficient funds.");
        }
        else balance -= amount;
    }

    public Account(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public CheckingAccount getCheckingAccount() {
        return checkingAccount;
    }

    public SavingsAccount getSavingsAccount() {
        return savingsAccount;
    }

    public void setCheckingAccount(CheckingAccount checkingAccount) {
        this.checkingAccount = checkingAccount;
        ibanMap.put(checkingAccount.getClass().getSimpleName(), checkingAccount.getIBAN());
    }

    public void setSavingsAccount(SavingsAccount savingsAccount) {
        this.savingsAccount = savingsAccount;
        ibanMap.put(savingsAccount.getClass().getSimpleName(), savingsAccount.getIBAN());
    }

    public Map<String,String> getIbanMap() {
        return ibanMap;
    }

    public List<TransactionHistory> getTransactionHistoryList() {
        return transactionHistoryList;
    }

    public void deposit(double amount) { balance += amount; }

    public void withdraw(double amount) { balance -= amount; }
}
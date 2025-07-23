import java.util.*;

public class Account {

    private final int accountNumber;
    private double balance = 0;
    private CheckingAccount checkingAccount;
    private SavingsAccount savingsAccount;
    private final List<TransactionHistory>  transactionHistoryList =  new ArrayList<>();

    private final Map<String,String> ibanMap = new HashMap<>();

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

    public void withdraw(double amount) {
        balance -= amount;
    }

    public void closeSavingsAccount(Account wrapper) {
        wrapper.getIbanMap().remove("SavingsAccount", wrapper.getSavingsAccount().getIBAN());
    }

    public void closeCheckingAccount(Account wrapper) {
        wrapper.getIbanMap().remove("CheckingAccount", wrapper.getCheckingAccount().getIBAN());
    }
}
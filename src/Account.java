import java.util.*;

public class Account {

    private final int accountNumber;
    private double balance = 0;
    private CheckingAccount checkingAccount;
    private SavingsAccount savingsAccount;
    private final List<CheckingAccount> checkingAccountList = new ArrayList<>();
    private final List<SavingsAccount> savingsAccountList = new ArrayList<>();
    private final static List<TransactionHistory>  transactionHistoryList =  new ArrayList<>();
    private final static Map<String,String> ibanMap = new HashMap<>();

    int i = 1;
    int j = 1;

    public List<CheckingAccount> getCheckingAccountList() {
        return checkingAccountList;
    }

    public List<SavingsAccount> getSavingsAccountList() {
        return savingsAccountList;
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
        ibanMap.put(checkingAccount.getClass().getSimpleName() + i++, checkingAccount.getIBAN());
    }

    public void setSavingsAccount(SavingsAccount savingsAccount) {
        this.savingsAccount = savingsAccount;
        ibanMap.put(savingsAccount.getClass().getSimpleName() + j++, savingsAccount.getIBAN());
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
        for (SavingsAccount savingsAccount : savingsAccountList) {
            if (savingsAccount.getIBAN().equals(wrapper.getSavingsAccount().getIBAN())) {
                String trimmedIban = savingsAccount.getIBAN().replaceAll("\\s+", "");  // remove all whitespace
                String type = ibanMap.entrySet().stream()
                        .filter(e -> e.getValue().equalsIgnoreCase(trimmedIban))
                        .map(Map.Entry::getKey)
                        .findFirst()
                        .orElse("Invalid");
                wrapper.getIbanMap().remove(type, wrapper.getSavingsAccount().getIBAN());
                wrapper.getSavingsAccountList().remove(wrapper.getSavingsAccount());
                return;
            }
        }
    }

    public void closeCheckingAccount(Account wrapper) {
        for (CheckingAccount checkingAccount : checkingAccountList) {
            if (checkingAccount.getIBAN().equals(wrapper.getCheckingAccount().getIBAN())) {
                String trimmedIban = checkingAccount.getIBAN().replaceAll("\\s+", "");  // remove all whitespace
                String type = ibanMap.entrySet().stream()
                        .filter(e -> e.getValue().equalsIgnoreCase(trimmedIban))
                        .map(Map.Entry::getKey)
                        .findFirst()
                        .orElse("Invalid");
                wrapper.getIbanMap().remove(type, wrapper.getCheckingAccount().getIBAN());
                wrapper.getCheckingAccountList().remove(wrapper.getCheckingAccount());
                return;
            }
        }
    }
}
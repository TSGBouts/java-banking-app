import java.util.ArrayList;
import java.util.List;

public class Account {
    private final String accountNumber;
    List<BankAccount> bankAccounts = new ArrayList<>();

    public Account(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountNumber() {
        return accountNumber;
    }
}
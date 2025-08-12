package bankapp.terminalService;

public class Customer {
    private String username;
    private final Account account;

    public Customer(String name, Account account) {
        this.username = name;
        this.account = account;
    }

    public String getUsername() {
        return username;
    }

    public Account getAccount() {
        return account;
    }
}
import java.util.Map;
import java.util.Scanner;

public class BankService {
    private final Customer customer;

    public BankService(Customer customer) {
        this.customer = customer;
    }

    public void createSubAccount(Scanner scanner) {
        System.out.println("1. Bank Account" + "\n" + "2. Savings Account");
        short newAccount = scanner.nextShort();
        switch (newAccount) {
            case 1:
                var bankAccount = new BankAccount(customer.getAccount().getAccountNumber(), IBANGenerator());
                customer.getAccount().setBankAccount(bankAccount);
                break;
            case 2:
                var savingsAccount = new SavingsAccount(customer.getAccount().getAccountNumber(), IBANGenerator());
                customer.getAccount().setSavingsAccount(savingsAccount);
                break;
        }
    }

    private String IBANGenerator(){
        return "GR" + Integer.toString((int) (Math.random() * 1_000_000));
    }


}

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

    public void IBANDeposit(Scanner scanner) {
        System.out.println("Enter the IBAN of wanted account");
        String iban = scanner.next();

        Map<String, String> ibanMap = customer.getAccount().getIbanMap();

        if (ibanMap.containsValue(iban)) {
            String type = ibanMap.entrySet().stream()
                    .filter(e -> e.getValue().equals(iban))
                    .map(Map.Entry::getKey)
                    .findFirst()
                    .orElse("Unknown");
            switch (type) {
                case "BankAccount":
                    customer.getAccount().getBankAccount().deposit();
                    System.out.println("Your new balance is " + customer.getAccount().getBankAccount().getBalance() + "$");
                    break;
                case "SavingsAccount":
                    customer.getAccount().getSavingsAccount().deposit();
                    System.out.println("Your new balance is " + customer.getAccount().getSavingsAccount().getBalance() + "$");
                    break;
            }
        }
    }

    private String IBANGenerator(){
        return "GR" + Integer.toString((int) (Math.random() * 1_000_000));
    }

}

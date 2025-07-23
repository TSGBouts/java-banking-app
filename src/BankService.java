import java.util.Scanner;

public class BankService {
    private final Customer customer;
    private final IbanGeneratable ibanGen;

    public BankService(Customer customer, IbanGeneratable ibanGenerator) {
        this.customer = customer;
        this.ibanGen = ibanGenerator;
    }

    public void createSubAccount(Scanner scanner) {
        System.out.println("1. Bank Account" + "\n" + "2. Savings Account");
        short newAccount = Short.parseShort(scanner.nextLine());
        String iban = ibanGen.generateGreekIban();
        switch (newAccount) {
            case 1:
                var bankAccount = new CheckingAccount(customer.getAccount().getAccountNumber(), iban);
                customer.getAccount().setBankAccount(bankAccount);
                break;
            case 2:
                var savingsAccount = new SavingsAccount(customer.getAccount().getAccountNumber(), iban);
                customer.getAccount().setSavingsAccount(savingsAccount);
                break;
        }
    }
}

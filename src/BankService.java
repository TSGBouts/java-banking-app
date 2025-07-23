import java.util.Scanner;

public class BankService {
    private final Customer customer;
    private final IbanGeneratable ibanGen;

    public BankService(Customer customer, IbanGeneratable ibanGenerator) {
        this.customer = customer;
        this.ibanGen = ibanGenerator;
    }

    public void createSubAccount(Scanner scanner) {
        var accountUI = new BankConsoleUI();
        accountUI.subAccountList();
        short newAccount = Short.parseShort(scanner.nextLine());
        String iban = ibanGen.generateGreekIban();
        switch (newAccount) {
            case 1:
                var checkingAccount = new CheckingAccount(customer.getAccount().getAccountNumber(), iban);
                accountUI.setCheckingAccountController(customer, checkingAccount);
                break;
            case 2:
                var savingsAccount = new SavingsAccount(customer.getAccount().getAccountNumber(), iban);
                accountUI.setSavingsAccountController(customer, savingsAccount);
                break;
        }
    }
}

import java.util.Scanner;

public class BankService {
    private final Customer customer;
    private final IbanGeneratable ibanGen;

    public BankService(Customer customer, IbanGeneratable ibanGenerator) {
        this.customer = customer;
        this.ibanGen = ibanGenerator;
    }

    public Accountable createSubAccount(short newAccount) {
        String iban = ibanGen.generateGreekIban();
        switch (newAccount) {
            case 1:
                CheckingAccount checking = new CheckingAccount(customer.getAccount().getAccountNumber(), iban);
                customer.getAccount().setCheckingAccount(checking);
                return checking;
            case 2:
                SavingsAccount saving = new SavingsAccount(customer.getAccount().getAccountNumber(), iban);
                customer.getAccount().setSavingsAccount(saving);
                return saving;
            default:
                throw new IllegalArgumentException("Invalid account type");
        }
    }
}

import java.util.Scanner;

public class BankAccount extends Account {

    private final String IBAN;

    BankAccount(int accountNumber, String IBAN) {
        super(accountNumber);
        this.IBAN = IBAN;
    }

    public String getIBAN() {
        return IBAN;
    }

}

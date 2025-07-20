import java.util.Scanner;

public class BankAccount extends Account {

    private String IBAN;

    BankAccount(short accountNumber, String IBAN) {
        super(accountNumber);
        this.IBAN = IBAN;
    }

    public String getIBAN() {
        return IBAN;
    }

}

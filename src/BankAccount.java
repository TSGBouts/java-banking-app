import java.util.Scanner;

public class BankAccount {

    private String IBAN;
    private double balance = 0;

    Scanner scanner = new Scanner(System.in);

    BankAccount(String IBAN) {
        super();
        this.IBAN = IBAN;
    }

}

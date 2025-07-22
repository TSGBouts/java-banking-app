import java.sql.SQLOutput;
import java.util.Scanner;

public class Transfer {

    private final Scanner scanner;

    public Transfer(Scanner scanner) {
        this.scanner = scanner;
    }

    public void transfer(Account account, Customer customer) {
        System.out.print("Enter the IBAN of the account you want to transfer to: ");
        String transfer = scanner.nextLine();
        Account target = new IbanFinder(customer).getAccountByIban(transfer);
        if (target == null) {
            System.out.println("Account does not exist. Please enter a valid IBAN.");
            return;
        }
        System.out.print("Enter transfer amount: ");
        double amount = Double.parseDouble(scanner.nextLine());
        account.transferTo(target, amount);
    }
}
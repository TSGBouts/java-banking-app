import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class Transfer {

    private final Scanner scanner;

    public Transfer(Scanner scanner) {
        this.scanner = scanner;
    }
    /**
     * Performs a transfer between any two sub-accounts and logs it centrally in the wrapper Account.
     */
    public void transfer(Customer customer) {
        Account wrapper = customer.getAccount();

        // Show available IBANs
        System.out.println("Available Sub-Accounts and IBANs:");
        wrapper.getIbanMap().forEach((type, iban) ->
                System.out.printf("%s: %s%n", type, iban.replaceAll("(.{4})(?=.)", "$1 "))
        );

        // Choose source IBAN
        System.out.print("Enter source IBAN (or type Exit): ");
        String sourceIban = scanner.nextLine().replaceAll("\\s+", "");
        if (sourceIban.equalsIgnoreCase("Exit")) return;
        Accountable sourceAcc = new IbanFinder(customer).getAccountByIban(sourceIban);
        if (sourceAcc == null) {
            System.out.println("Source account not found.");
            return;
        }

        // Choose target IBAN
        System.out.print("Enter target IBAN: ");
        String targetIban = scanner.nextLine().replaceAll("\\s+", "");
        Accountable targetAcc = new IbanFinder(customer).getAccountByIban(targetIban);
        if (targetAcc == null) {
            System.out.println("Target account not found.");
            return;
        }

        // Enter and validate amount
        System.out.print("Enter transfer amount: ");
        double amount;
        try {
            amount = Double.parseDouble(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid amount. Please enter a numeric value.");
            return;
        }

        // Perform withdrawal from source
        if (sourceAcc.getBalance() < amount || amount <= 0) {
            System.out.println("Invalid amount or insufficient funds.");
            return;
        }
        sourceAcc.withdraw(amount);

        // Perform deposit into target
        targetAcc.deposit(amount);

        // Centralized history logging on wrapper
        wrapper.getTransactionHistoryList().add(
                new TransactionHistory(
                        LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")),
                        "- TRANSFER - ",
                        amount,
                        "- FROM " + sourceIban.replaceAll("(.{4})(?=.)", "$1 ") + " - TO "
                                + targetIban.replaceAll("(.{4})(?=.)", "$1 ")
                )
        );
        System.out.println("Transfer successful.");
    }
}
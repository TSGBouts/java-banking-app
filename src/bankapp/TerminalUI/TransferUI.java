package bankapp.terminalUI;

import java.util.Scanner;

import bankapp.terminalService.*;

public class TransferUI {
    public void performTransferPrompt(Customer customer) {

        Account wrapper = customer.getAccount();
        Scanner scanner = new Scanner(System.in);

        if (wrapper.getIbanMap().size() < 2) {
            System.out.println("Must have 2 or more accounts to transfer.");
            return;
        }

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
        try {
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
            if (!new Transfer().transfer(customer, wrapper, sourceAcc, targetAcc, amount))
                System.out.println("Invalid amount or insufficient funds.");
            else System.out.println("Transfer successful.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
package bankapp.terminalUI;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

import bankapp.*;

public class SearchIbanToSavingsUI {
    public static void searchIbanToSavings(Customer customer) throws PositiveValueException {
        double amount;
        short answer;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("""
                            1. Check Balance
                            2. Deposit
                            3. Withdraw
                            4. Check Savings
                            5. Exit Savings Account
                            6. Close Savings Account""");
            answer = Short.parseShort(scanner.nextLine());
            if (answer == 1) System.out.println("Your balance is: " + customer.getAccount().getSavingsAccount().getBalance() + "$");
            else if (answer == 2) {
                System.out.println("Enter deposit amount: ");
                amount = Double.parseDouble(scanner.nextLine());
                customer.getAccount().getSavingsAccount().deposit(amount);
                customer.getAccount().getTransactionHistoryList().add(
                        new TransactionHistory(
                                LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")),
                                "- DEPOSIT - ",
                                amount,
                                "- TO " + customer.getAccount().getSavingsAccount().getIBAN().replaceAll("(.{4})(?=.)", "$1 ") + " - TO ")
                );
                System.out.println("Deposit successful. Your new balance is: " + customer.getAccount().getSavingsAccount().getBalance() + "$");
            }
            else if (answer == 3) {
                System.out.println("Enter withdraw amount: ");
                amount = Double.parseDouble(scanner.nextLine());
                if (amount > customer.getAccount().getSavingsAccount().getBalance() || amount < 0)
                    throw new PositiveValueException("Withdraw amount must me between 0 and " + customer.getAccount().getSavingsAccount().getBalance() + "$");

                else customer.getAccount().getSavingsAccount().withdraw(amount);
                customer.getAccount().getTransactionHistoryList().add(
                        new TransactionHistory(
                                LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")),
                                "- WITHDRAW - ",
                                amount,
                                "- FROM " + customer.getAccount().getSavingsAccount().getIBAN().replaceAll("(.{4})(?=.)", "$1 ")));
                System.out.println("Withdrawal successful. Your new balance is: " + customer.getAccount().getSavingsAccount().getBalance() + "$");
            }
            else if (answer == 4) new SavingsAccountUI().savingsCalculatorUI(customer);
            else if (answer == 5) break;
            else if  (answer == 6) {
                if (customer.getAccount().getSavingsAccount().getBalance() != 0)
                    System.out.println("Account balance has to be 0 in order to close. Please withdraw: " + customer.getAccount().getSavingsAccount().getBalance() + "$");
                else {
                    customer.getAccount().closeSavingsAccount(customer.getAccount());
                    System.out.println("Deleting account...");
                    break;
                }
            }
            else System.out.println("Enter a valid option");
        }
        while (answer != 5);
    }
}

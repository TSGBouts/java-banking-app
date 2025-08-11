package bankapp.terminalUI;

import java.util.List;
import java.util.Scanner;

import bankapp.*;

public class BankConsoleUI {

    Scanner scanner = new Scanner(System.in);

    public void createAccountController(Customer customer, IbanGeneratable iban, SearchIbanToAccountable searchIbanToAccountable) {

        Bank bank = new Bank(customer, iban, searchIbanToAccountable);

        while (true) {
            System.out.println("""
                    1. Create a Sub-Account
                    2. Open Sub-Account
                    3. Transfer
                    4. Open Transaction History
                    5. Exit""");
            try {
                short answer = Short.parseShort(scanner.nextLine());
                bank.Loop(answer);
            } catch (IllegalArgumentException e) {
                System.out.println("Please enter a valid option.");
            }
        }
    }

    public void invalid(){
        System.out.println("Please enter a valid option");
    }

    public void printHistory(Customer customer, List<TransactionHistory> transactionHistoryList) {
        if (transactionHistoryList.isEmpty()) System.out.println("There is no transaction history.");
        else for (TransactionHistory tx : customer.getAccount().getTransactionHistoryList())
            System.out.println(tx.timestamp() + " " + tx.type() + " " + tx.amount() + "$ " + tx.description());
    }
    public void showSubAccount(Customer customer, IbanGeneratable ibanGeneratable){
        System.out.println("1. Bank Account" + "\n" + "2. Savings Account");
        short choice = Short.parseShort(scanner.nextLine());
        try {
            Accountable newAcc = new BankService(customer, ibanGeneratable).createSubAccount(choice);
            if (newAcc instanceof CheckingAccount) {
                System.out.println("New Checking: " + newAcc.getIBAN().replaceAll("(.{4})(?=.)", "$1 "));
            } else {
                System.out.println("New Savings: " + newAcc.getIBAN().replaceAll("(.{4})(?=.)", "$1 "));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
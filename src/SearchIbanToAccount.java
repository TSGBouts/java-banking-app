import java.util.Map;
import java.util.Scanner;

public class SearchIbanToAccount implements SearchIbanToAccountable {
    Scanner scanner = new Scanner(System.in);

    @Override
    public void searchIbanToAccount(Customer customer) {
        System.out.print("Enter the IBAN of the sub-account to open: ");
        String input = scanner.nextLine();  // read full line, including spaces
        String trimmedIban = input.replaceAll("\\s+", "");  // remove all whitespace

        Map<String, String> ibanMap = customer.getAccount().getIbanMap();
        // find account type by matching the trimmed IBAN
        String type = ibanMap.entrySet().stream()
                .filter(e -> e.getValue().equalsIgnoreCase(trimmedIban))
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(null);

        if (type == null) {
            System.out.println("No sub-account found for IBAN: " + input);
            return;
        }

        switch (type) {
            case "BankAccount":
                short answer;
                do {
                    System.out.println("1. Check Balance" + "\n" + "2. Deposit" + "\n" + "3. Withdraw" + "\n" + "4. Exit Bank Account");
                    answer = scanner.nextShort();
                    if (answer == 1) System.out.println("Your balance is: " + customer.getAccount().getBankAccount().getBalance() + "$");
                    else if (answer == 2) customer.getAccount().getBankAccount().deposit();
                    else if (answer == 3) customer.getAccount().getBankAccount().withdraw();
                    else if (answer == 4) break;
                    else System.out.println("Enter a valid option");
                }
                while (answer != 4);
                break;

            case "SavingsAccount":
                short answer2;
                do {
                    System.out.println("1. Check Balance" + "\n" + "2. Deposit" + "\n" + "3. Withdraw" + "\n" + "4. Check Savings" + "\n" + "5. Exit Savings Account");
                    answer2 = scanner.nextShort();
                    if (answer2 == 1) System.out.println("Your balance is: " + customer.getAccount().getSavingsAccount().getBalance() + "$");
                    else if (answer2 == 2) customer.getAccount().getSavingsAccount().deposit();
                    else if (answer2 == 3) customer.getAccount().getSavingsAccount().withdraw();
                    else if (answer2 == 4) customer.getAccount().getSavingsAccount().savingsCalculator(scanner);
                    else if (answer2 == 5) break;
                    else System.out.println("Enter a valid option");
                }
                while (answer2 != 5);
                break;

        }

    }
}
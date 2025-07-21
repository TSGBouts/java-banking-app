import java.util.Map;
import java.util.Scanner;

public class SearchIbanToAccount {
    Scanner scanner = new Scanner(System.in);

    public void searchIbanToAccount(Customer customer) {
        System.out.println("Enter the IBAN of wanted account");
        String iban = scanner.next();

        Map<String, String> ibanMap = customer.getAccount().getIbanMap();

        String type = ibanMap.entrySet().stream()
                    .filter(e -> e.getValue().equals(iban))
                    .map(Map.Entry::getKey)
                    .findFirst()
                    .orElse("Unknown");

        switch (type) {
            case "BankAccount":
                short answer;
                do {
                    System.out.println("1. Deposit" + "\n" + "2. Withdraw" + "\n" + "Exit Bank Account");
                    answer = scanner.nextShort();
                    if (answer == 1) customer.getAccount().getBankAccount().deposit();
                    else if (answer == 2) customer.getAccount().getBankAccount().withdraw();
                    else if (answer == 3) break;
                    else System.out.println("Enter a valid option");
                }
                while (answer != 3);
                break;

            case "SavingsAccount":
                short answer2;
                do {
                    System.out.println("1. Deposit" + "\n" + "2. Withdraw" + "\n" + "3. Check Savings" + "\n" + "Exit Savings Account");
                    answer2 = scanner.nextShort();
                    if (answer2 == 1) customer.getAccount().getSavingsAccount().deposit();
                    else if (answer2 == 2) customer.getAccount().getSavingsAccount().withdraw();
                    else if (answer2 == 3) customer.getAccount().getSavingsAccount().savingsCalculator(scanner);
                    else if (answer2 == 4) break;
                    else System.out.println("Enter a valid option");
                }
                while (answer2 != 4);
                break;

        }

    }
}

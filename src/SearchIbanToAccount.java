import java.util.Scanner;

public class SearchIbanToAccount implements SearchIbanToAccountable {
    Scanner scanner = new Scanner(System.in);

    @Override
    public void SubAccountManager(Customer customer) {

        System.out.print("Enter the IBAN of the sub-account to open (or type Exit): ");
        String ibanInput = scanner.nextLine();

        if (ibanInput.equalsIgnoreCase("Exit")) return;

        IbanFinder ibanFinder = new IbanFinder(customer);
        String type = ibanFinder.findAccountTypeByIban(ibanInput);

        if (type.equalsIgnoreCase("Invalid")){
            System.out.println("No account with this IBAN.");
            return;
        }

        switch (type) {
            case "BankAccount":
                short answer;
                do {
                    System.out.println("""
                            1. Check Balance
                            2. Deposit
                            3. Withdraw
                            4. Exit Bank Account""");
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
                    System.out.println("""
                            1. Check Balance
                            2. Deposit
                            3. Withdraw
                            4. Check Savings
                            5. Exit Savings Account""");
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
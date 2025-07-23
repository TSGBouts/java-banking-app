import java.util.Scanner;

public class SearchIbanToChecking {

    public static void searchIbanToChecking(Customer customer) throws PositiveValueException {
        double amount;
        short answer;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("""
                            1. Check Balance
                            2. Deposit
                            3. Withdraw
                            4. Exit Bank Account""");
            answer = Short.parseShort(scanner.nextLine());
            if (answer == 1) System.out.println("Your balance is: " + customer.getAccount().getCheckingAccount().getBalance() + "$");
            else if (answer == 2) {
                System.out.println("Enter deposit amount: ");
                amount = Double.parseDouble(scanner.nextLine());
                customer.getAccount().getCheckingAccount().deposit(amount);
                System.out.println("Deposit successful. Your new balance is: " + customer.getAccount().getCheckingAccount().getBalance() + "$");
            }
            else if (answer == 3) {
                System.out.println("Enter withdraw amount: ");
                amount = Double.parseDouble(scanner.nextLine());
                if (amount > customer.getAccount().getCheckingAccount().getBalance() || amount < 0)
                    throw new PositiveValueException("Withdraw amount must me between 0 and " + customer.getAccount().getCheckingAccount().getBalance() + "$");

                else customer.getAccount().getCheckingAccount().withdraw(amount);
                System.out.println("Withdrawal successful. Your new balance is: " + customer.getAccount().getCheckingAccount().getBalance() + "$");
            }
            else if (answer == 4) break;
            else System.out.println("Enter a valid option");
        }
        while (answer != 4);
    }
}


import java.util.Scanner;

public class FirstLogin {

    static Scanner scanner = new Scanner(System.in);

    public static Customer customer() {
        System.out.print("New customer detected. Create new account? (Y/N): ");
        Customer customer = null;

        while (true) {
            String answer1 = scanner.nextLine();
            if (answer1.equals("Y")) {
                customer = createAccount();
                break;
            }
            else if (answer1.equals("N")) System.exit(0);
            else System.out.println("Invalid input. Please try again.");
        }
        return customer;
    }

        public static Customer createAccount(){
            System.out.print("Please enter a username: ");
            String username = scanner.nextLine();
            if (!username.isEmpty() && username.matches("^[A-Za-z0-9]+$") ) {
                int accountNumber = (int) (Math.random() * 1000);
                var account = new Account(accountNumber);
                System.out.println("Your new account code is " + account.getAccountNumber() + ".");
                return new Customer(username, account);
            }
            else System.out.println("Invalid input. Please try again.");
            createAccount();
            return null;
        }
}

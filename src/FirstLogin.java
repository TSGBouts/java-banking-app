import java.util.Scanner;

public class FirstLogin {

    static Scanner scanner = new Scanner(System.in);

    public static Customer customer() {
        System.out.println("New customer detected. Create new account? (Y/N)");
        Customer customer = null;

        while (true) {
            String answer1 = scanner.nextLine();
            if (answer1.equals("Y")) {
                customer = createAccount();
                break;
            } else System.out.println("Invalid input. Please try again.");
        }
        return customer;
    }

        public static Customer createAccount(){
            System.out.println("Please enter a username");
            String username = scanner.nextLine();
            short accountNumber = (short) (Math.random() * 10);
            var account = new Account(accountNumber);
            return new Customer(username, account);
        }
}

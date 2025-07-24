import java.util.Scanner;

public class ConsoleLoginUI {
    private final Scanner scanner = new Scanner(System.in);
    private final FirstLoginService firstLoginService = new FirstLoginService();

    public Customer promptFirstLogin() {
        System.out.print("1. Sign up \n2. Login \n3. Exit \n");
        while (true) {
            short input = Short.parseShort(scanner.nextLine());
            switch (input) {
                case 1:
                    return handleAccountCreation();
                case 2:
                    return handleAccountLogin();
                case 3:
                    System.out.println("Exiting application...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid input. Please try again.");
            }
        }
    }

    public Customer handleAccountCreation() {
        while (true) {
            System.out.print("Please enter a username: ");
            String username = scanner.nextLine();
            try {
                Customer customer = firstLoginService.registerNewCustomer(username);
                System.out.println("Your account has been created. Your new account number is " + customer.getAccount().getAccountNumber());
                return customer;
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " +  e.getMessage());
            }
        }
    }

    public Customer handleAccountLogin(){
        while (true) {

            try {
                System.out.print("Please enter your username: ");
                String username = scanner.nextLine();

                System.out.print("Please enter your account number: ");
                int password = Integer.parseInt(scanner.nextLine());

                Customer customer = firstLoginService.loginCustomer(username, password);
                if (customer == null) {
                    System.out.println("Login failed. Username or account number is incorrect. Please try again.");
                }
                else return customer;
            } catch (IllegalArgumentException e) {
                System.out.println("Error: Please enter a number.");
            }
        }
    }
}
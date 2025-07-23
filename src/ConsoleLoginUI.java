import java.util.Scanner;

public class ConsoleLoginUI {
    private final Scanner scanner = new Scanner(System.in);
    private final FirstLoginService firstLoginService = new FirstLoginService();

    public Customer promptFirstLogin() {
        System.out.print("New customer detected. Create new account? (Y/N): ");
        while (true) {
            String input = scanner.nextLine().toUpperCase();
            switch (input) {
                case "Y":
                    return  handleAccountCreation();
                case "N":
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
                System.out.println("Your account has been created.");
                return customer;
            }
            catch (IllegalArgumentException e){
                System.out.println("Error: " +  e.getMessage());
            }
        }
    }
}

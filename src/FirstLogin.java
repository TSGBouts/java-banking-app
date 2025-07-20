import java.util.Scanner;

public class FirstLogin {

    static Scanner scanner = new Scanner(System.in);

    public static void firstLogin(){
        System.out.println("New customer detected. Create new account? (Y/N)");
        String answer1 = scanner.nextLine();
        if (answer1.equals("Y")) createAccount();
        else if (answer1.equals("N")) return;
        else System.out.println("Invalid input. Please try again.");

        System.out.println("No bank account detected. Create new one? (Y/N)");
        String answer2 = scanner.nextLine();
        if (answer2.equals("Y")) {
            String IBAN = "GR" + "Math.random() * 1000000000";
            var primaryBankAccount = new BankAccount(IBAN);
        }
        else if (answer2.equals("N")) return;
        else System.out.println("Invalid input. Please try again.");
    }

    public static void createAccount(){
        System.out.println("Please enter a username");
        String username = scanner.nextLine();
        String accountNumber = "Math.random() * 10";
        var account = new Account(accountNumber);
        var customer = new Customer(username, account);
    }
}

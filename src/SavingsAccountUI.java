import java.util.Scanner;

public class SavingsAccountUI {

    private final Scanner scanner = new Scanner(System.in);

    public void savingsCalculatorUI(Customer customer) {

        float interestRate = 0;
        float period = 0;

        System.out.print("Enter interest rate: ");
        try {
            interestRate = Float.parseFloat(scanner.nextLine());
            System.out.print("Enter period in years: ");
            period = Float.parseFloat(scanner.nextLine());
        }
        catch (IllegalArgumentException e){
            System.out.println("Error: " + e.getMessage());
        }
        double savings = customer.getAccount().getSavingsAccount().savingsCalculator(interestRate, period);
        System.out.println(("Your savings in" + " " + period + " years will be " + savings));
    }

}
package bankapp.terminalUI;

import java.util.Scanner;

import bankapp.*;

public class SavingsAccountUI {

    private final Scanner scanner = new Scanner(System.in);

    public void savingsCalculatorUI(Customer customer) {

        float interestRate = 0;
        float period = 0;

        while (true) {
            try {
                interestRate = ReadInterestRate();
                break;
            } catch (IllegalArgumentException | PositiveValueException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        while (true) {
            try {
                period = ReadPeriod();
                break;
            } catch (IllegalArgumentException | PositiveValueException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        double savings = customer.getAccount().getSavingsAccount().savingsCalculator(interestRate, period);
        System.out.printf("In %.1f years at %.2f%%, you’ll have %.2f%n$", period, interestRate, savings);
    }

    public float ReadInterestRate() throws PositiveValueException{
        System.out.print("Enter interest rate: ");
        float interestRate = Float.parseFloat(scanner.nextLine());
        if (interestRate < 0 ||  interestRate > 100) throw new PositiveValueException("Interest rate must be between 0 and 100");
        return interestRate;
    }

    public float ReadPeriod() throws PositiveValueException{
        System.out.print("Enter period: ");
        float period = Float.parseFloat(scanner.nextLine());
        if (period <= 0)  throw new PositiveValueException("Period must positive");
        return period;
    }
}

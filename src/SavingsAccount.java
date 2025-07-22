import java.util.Scanner;

public class SavingsAccount extends Account implements Accountable{

    final short MONTHS_IN_YEAR = 12;
    final short PERCENT = 100;
    private final String IBAN;

    public SavingsAccount(int accountNumber, String IBAN) {
        super(accountNumber);
        this.IBAN = IBAN;
    }

    public String getIBAN() {
        return IBAN;
    }

    public void savingsCalculator(Scanner scanner){
        System.out.print("Enter interest rate: ");
        float interrestRate = scanner.nextFloat();
        System.out.print("Enter period in years: ");
        float period = scanner.nextFloat();
        float intRate = interrestRate / PERCENT;
        float per = period + MONTHS_IN_YEAR;
        double savings = getBalance() * Math.pow((1 + intRate / MONTHS_IN_YEAR), MONTHS_IN_YEAR * per);
        System.out.println(("Your savings in" + " " + period + "years will be " + savings));
    }
}

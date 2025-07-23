import java.sql.SQLOutput;
import java.util.Scanner;

public class SavingsAccount extends Account implements Accountable{

    final short MONTHS_IN_YEAR = 12;
    final short PERCENT = 100;
    private String IBAN = null;

    public SavingsAccount(int accountNumber, String IBAN) {
        super(accountNumber);
        this.IBAN = IBAN;
    }

    public SavingsAccount(){
        super(0);
    }

    public String getIBAN() {
        return IBAN;
    }
    public double savingsCalculator(float interrestRate, float period){
        float intRate = interrestRate / PERCENT;
        float per = period + MONTHS_IN_YEAR;
        System.out.println(getBalance());
        return getBalance() * Math.pow((1 + intRate / MONTHS_IN_YEAR), MONTHS_IN_YEAR * per);
    }
}

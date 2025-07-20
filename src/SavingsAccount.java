public class SavingsAccount extends Account{

    private String IBAN;

    public SavingsAccount(short accountNumber, String IBAN) {
        super(accountNumber);
        this.IBAN = IBAN;
    }

    public String getIBAN() {
        return IBAN;
    }
}

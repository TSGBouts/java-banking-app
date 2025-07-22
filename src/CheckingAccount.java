public class CheckingAccount extends Account implements Accountable {

    private final String IBAN;

    CheckingAccount(int accountNumber, String IBAN) {
        super(accountNumber);
        this.IBAN = IBAN;
    }

    public String getIBAN() {
        return IBAN;
    }
}

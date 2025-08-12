package bankapp.terminalService;

import java.util.Map;

public class IbanFinder {

    private final Customer customer;

    public IbanFinder(Customer customer) {
        this.customer = customer;
    }

    public String findAccountTypeByIban(String ibanInput) {
        String trimmedIban = ibanInput.replaceAll("\\s+", "");  // remove all whitespace

        Map<String, String> ibanMap = customer.getAccount().getIbanMap();


        return ibanMap.entrySet().stream()
                .filter(e -> e.getValue().equalsIgnoreCase(trimmedIban))
                .map(e -> e.getKey().replaceAll("\\d+$", ""))  // strip trailing digits
                .findFirst()
                .orElse("Invalid");  // return "Invalid" as default
    }

    public Accountable getAccountByIban(String ibanInput) {
        ibanInput = ibanInput.replaceAll("\\s+","");

        for (CheckingAccount checkingAccount : customer.getAccount().getCheckingAccountList()) {
            if (checkingAccount.getIBAN().equalsIgnoreCase(ibanInput))
                return customer.getAccount().getCheckingAccount();
        }
        for (SavingsAccount savingsAccount : customer.getAccount().getSavingsAccountList()) {
            if (savingsAccount.getIBAN().equalsIgnoreCase(ibanInput))
                return customer.getAccount().getSavingsAccount();
        }
             return null;
    }
}
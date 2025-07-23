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
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse("Invalid");  // return "Invalid" as default
    }

    public Accountable getAccountByIban(String ibanInput) {
        ibanInput = ibanInput.replaceAll("\\s+","");

            if (customer.getAccount().getCheckingAccount().getIBAN().equalsIgnoreCase(ibanInput))
                return customer.getAccount().getCheckingAccount();
            if (customer.getAccount().getSavingsAccount().getIBAN().equalsIgnoreCase(ibanInput))
                return customer.getAccount().getSavingsAccount();
             return null;
    }
}
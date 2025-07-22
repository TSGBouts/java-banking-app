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

    public Account getAccountByIban(String ibanInput) {
        String trimmedIban = ibanInput.replaceAll("\\s+", "");
        String type = findAccountTypeByIban(trimmedIban);

        return switch (type) {
            case "BankAccount" -> customer.getAccount().getBankAccount();
            case "SavingsAccount" -> customer.getAccount().getSavingsAccount();
            default -> null;
        };
    }
}
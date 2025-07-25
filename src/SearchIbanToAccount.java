import java.util.Scanner;

public class SearchIbanToAccount implements SearchIbanToAccountable {
    Scanner scanner = new Scanner(System.in);

    @Override
    public void SubAccountManager(Customer customer) throws PositiveValueException {

        System.out.println("Enter the IBAN of the sub-account to open (or type Exit): ");
        String ibanInput = scanner.nextLine();

        if (ibanInput.equalsIgnoreCase("Exit")) return;

        IbanFinder ibanFinder = new IbanFinder(customer);
        String type = ibanFinder.findAccountTypeByIban(ibanInput);

        if (type.equalsIgnoreCase("Invalid")){
            System.out.println("No account with this IBAN.");
            return;
        }

        switch (type) {
            case "CheckingAccount":
                SearchIbanToCheckingUI.searchIbanToChecking(customer);
                break;

            case "SavingsAccount":
                SearchIbanToSavingsUI.searchIbanToSavings(customer);
                break;
        }
    }
}
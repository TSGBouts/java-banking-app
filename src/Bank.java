import java.util.Scanner;

public class Bank {

    private final Customer customer;
    private final SearchIbanToAccountable ibanSearcher;
    IbanGeneratable generator;
    Scanner scanner = new Scanner(System.in);

    public Bank(Customer customer, IbanGeneratable generator, SearchIbanToAccountable ibanSearcher) {
        this.customer = customer;
        this.generator = generator;
        this.ibanSearcher = ibanSearcher;
    }

        public void Loop() {
            BankService bankService = new BankService(customer, generator);
            SearchIbanToAccount searchIbanToAccount = new SearchIbanToAccount();
            while(true) {
                System.out.println("""
                        1. Create a Sub-Account
                        2. Open Sub-Account
                        3. Exit""");
                Short answer = scanner.nextShort();
                switch (answer) {
                    case 1:
                        bankService.createSubAccount(scanner);
                        break;
                    case 2:
                        searchIbanToAccount.SubAccountManager(customer);
                        break;
                    case 3:
                        System.exit(0);
                        break;
                        default:
                            System.out.println("Please enter a valid option");
                }
                }
        }
    }

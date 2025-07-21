import java.util.Map;
import java.util.Scanner;
import java.util.Random;

public class Bank {

    private final Customer customer;
    Scanner scanner = new Scanner(System.in);

    public Bank(Customer customer) {
        this.customer = customer;
    }

        public void Loop() {
            BankService bankService = new BankService(customer);
            SearchIbanToAccount searchIbanToAccount = new SearchIbanToAccount();
            while(true) {
                System.out.println("1. Create a Sub-Account" + "\n" + "2. Open Sub-Account" + "\n" + "3. Exit");
                Short answer = scanner.nextShort();
                switch (answer) {
                    case 1:
                        bankService.createSubAccount(scanner);
                        break;
                    case 2:
                        searchIbanToAccount.searchIbanToAccount(customer);
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

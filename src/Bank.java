import java.util.Scanner;

public class Bank {

    private final Customer customer;
    IbanGeneratable generator;
    Scanner scanner = new Scanner(System.in);

    public Bank(Customer customer, IbanGeneratable generator, SearchIbanToAccountable ibanSearcher) {
        this.customer = customer;
        this.generator = generator;
    }

        public void Loop() {
            while(true) {
                System.out.println("""
                        1. Create a Sub-Account
                        2. Open Sub-Account
                        3. Transfer
                        4. Open Transaction History
                        5. Exit""");
                short answer = Short.parseShort(scanner.nextLine());
                switch (answer) {
                    case 1:
                        new BankService(customer, generator).createSubAccount(scanner);
                        break;
                    case 2:
                        new SearchIbanToAccount().SubAccountManager(customer);
                        break;
                    case 3:
                        new Transfer(scanner).transfer(customer);
                        break;
                    case 4:
                        for (TransactionHistory tx : customer.getAccount().getTransactionHistoryList())
                            System.out.println(tx.getTimestamp() + " " + tx.getType() + " " + tx.getAmount() + "$ " + tx.getDescription());
                    break;
                    case 5:
                        System.exit(0);
                        break;
                        default:
                            System.out.println("Please enter a valid option");
                }
                }
        }
    }

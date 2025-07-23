import java.util.Scanner;

public class Bank {

    private final Customer customer;
    IbanGeneratable generator;
    Scanner scanner = new Scanner(System.in);
    BankConsoleUI bankConsoleUI = new BankConsoleUI();

    public Bank(Customer customer, IbanGeneratable generator, SearchIbanToAccountable ibanSearcher) {
        this.customer = customer;
        this.generator = generator;
    }

        public void Loop() {
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
                            System.out.println(tx.timestamp() + " " + tx.type() + " " + tx.amount() + "$ " + tx.description());
                    break;
                    case 5:
                        bankConsoleUI.exiting();
                        System.exit(0);
                        break;
                        default:
                            bankConsoleUI.invalid();
                }
                }
        }
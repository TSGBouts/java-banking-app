public class Bank {

    private final Customer customer;
    IbanGeneratable generator;
    BankConsoleUI bankConsoleUI = new BankConsoleUI();
    TransferUI transferUI = new TransferUI();

    public Bank(Customer customer, IbanGeneratable generator, SearchIbanToAccountable ibanSearcher) {
        this.customer = customer;
        this.generator = generator;
    }

        public void Loop(short answer) {
                switch (answer) {
                    case 1:
                        bankConsoleUI.showSubAccount(customer, generator);
                        break;
                    case 2:
                        try {
                            new SearchIbanToAccount().SubAccountManager(customer);
                        } catch (PositiveValueException e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 3:
                        transferUI.performTransferPrompt(customer);
                        break;
                    case 4:
                        bankConsoleUI.printHistory(customer, customer.getAccount().getTransactionHistoryList());
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

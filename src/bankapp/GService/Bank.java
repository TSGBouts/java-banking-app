package bankapp.GService;

import bankapp.terminalUI.*;

public class Bank {

    private final Customer customer;
    IbanGeneratable generator;
    BankConsoleUI bankConsoleUI = new BankConsoleUI();
    TransferUI transferUI = new TransferUI();
    ConsoleLoginUI consoleLoginUI = new ConsoleLoginUI();

    public Bank(Customer customer, IbanGeneratable generator, SearchIbanToAccountable ibanSearcher) {
        this.customer = customer;
        this.generator = generator;
    }

//        public void Loop(short answer) {
//                switch (answer) {
//                    case 1:
////                        bankConsoleUI.showSubAccount(customer, generator);
//                        break;
//                    case 2:
//                        try {
////                            new SearchIbanToAccountUI().SubAccountManager(customer);
//                        } catch (PositiveValueException e) {
//                            System.out.println(e.getMessage());
//                        }
//                        break;
//                    case 3:
////                        transferUI.performTransferPrompt(customer);
//                        break;
//                    case 4:
////                        bankConsoleUI.printHistory(customer, customer.getAccount().getTransactionHistoryList());
//                        break;
//                    case 5:
//                        consoleLoginUI.promptFirstLogin();
//                        break;
//                        default:
//                            bankConsoleUI.invalid();
//                }
//                }
        }

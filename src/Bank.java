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
            while(true) {
                System.out.println("1. Create a Sub-Account" + "\n" + "2. Deposit" + "\n" + "3. Withdraw" +  "\n" + "4. Exit");
                Short answer = scanner.nextShort();
                switch (answer) {
                    case 1:
                        System.out.println("1. Bank Account" + "\n" + "2. Savings Account");
                        short newAccount = scanner.nextShort();
                        switch (newAccount) {
                            case 1:
                                var bankAccount = new BankAccount(customer.getAccount().getAccountNumber(), IBANGenerator());
                                customer.getAccount().setBankAccount(bankAccount);
                                break;
                            case 2:
                                var savingsAccount = new SavingsAccount(customer.getAccount().getAccountNumber(), IBANGenerator());
                                customer.getAccount().setSavingsAccount(savingsAccount);
                                break;
                        }
                        break;
                    case 2:
                        System.out.println("Enter the IBAN of wanted account");
                        String iban = scanner.next();

                        Map<String, String> ibanMap = customer.getAccount().getIbanMap();

                        if (ibanMap.containsValue(iban)) {
                            String type = ibanMap.entrySet().stream()
                                    .filter(e -> e.getValue().equals(iban))
                                    .map(Map.Entry::getKey)
                                    .findFirst()
                                    .orElse("Unknown");
                            switch (type) {
                                case "BankAccount":
                                    customer.getAccount().getBankAccount().deposit();
                                    System.out.println("Your new balance is " + customer.getAccount().getBankAccount().getBalance() + "$");
                                    break;
                                case "SavingsAccount":
                                    customer.getAccount().getSavingsAccount().deposit();
                                    System.out.println("Your new balance is " + customer.getAccount().getSavingsAccount().getBalance() + "$");
                                    break;
                            }
                        }
                        break;
                }
                }
        }

        private String IBANGenerator(){
                return "GR" + Integer.toString((int) (Math.random() * 1_000_000));
        }
    }

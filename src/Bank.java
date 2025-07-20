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
            while(true) {
                System.out.println("1. Create a Sub-Account" + "\n" + "2. Deposit" + "\n" + "3. Withdraw" +  "\n" + "4. Exit");
                Short answer = scanner.nextShort();
                switch (answer) {
                    case 1:
                        bankService.createSubAccount(scanner);
                        break;
                    case 2:
                        bankService.IBANDeposit(scanner);
                        break;
                    case 3:
                }
                }
        }
    }

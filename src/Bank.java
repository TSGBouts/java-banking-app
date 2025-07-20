import java.util.Scanner;

public class Bank {

    Scanner scanner = new Scanner(System.in);

    while(true){
        System.out.println("1. Deposit /n 2. Withdraw /n 3. Exit");
        short answer = scanner.nextShort();
        switch (answer){
            case 1: primaryBankAccount.deposit(); break;
        }
        break;
    }

}

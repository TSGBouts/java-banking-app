package bankapp.GService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Transfer {
    /**
     * Performs a transfer between any two sub-accounts and logs it centrally in the wrapper Account.
     */
    public boolean transfer(Customer customer, Account wrapper, Accountable sourceAcc, Accountable targetAcc, double amount) {

        // Perform withdrawal from source
        if (sourceAcc.getBalance() < amount || amount <= 0) {
            return  false;
        }
        sourceAcc.withdraw(amount);

        // Perform deposit into target
        targetAcc.deposit(amount);

        // Centralized history logging on wrapper
        wrapper.getTransactionHistoryList().add(
                new TransactionHistory(
                        LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")),
                        "- TRANSFER - ",
                        amount,
                        "- FROM " + sourceAcc.getIBAN().replaceAll("(.{4})(?=.)", "$1 ") + " - TO "
                                + targetAcc.getIBAN().replaceAll("(.{4})(?=.)", "$1 ")
                )
        );
    return true;
    }
}
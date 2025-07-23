import java.util.concurrent.ThreadLocalRandom;

public class FirstLoginService {
        /**
         * Creates a new Customer given a valid username.
         * @param username must be alphanumeric and non-empty
         * @return new Customer
         * @throws IllegalArgumentException if username invalid
         */
        public Customer registerNewCustomer(String username) {
            if (username == null || !username.matches("^[A-Za-z0-9]+$")) {
                throw new IllegalArgumentException("Username must be alphanumeric and non-empty.");
            }
            int accountNumber = ThreadLocalRandom.current().nextInt(1000, 10000);
            return new Customer(username, new Account(accountNumber));
        }
    }

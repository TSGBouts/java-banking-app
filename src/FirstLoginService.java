import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class FirstLoginService {
        /**
         * Creates a new Customer given a valid username.
         * @param username must be alphanumeric and non-empty
         * @return new Customer
         * @throws IllegalArgumentException if username invalid
         */
        private static final List<Customer> customers = new ArrayList<>();

        public Customer registerNewCustomer(String username) {
            if (username == null || !username.matches("^[A-Za-z0-9]+$")) {
                throw new IllegalArgumentException("Username must be alphanumeric and non-empty.");
            }
            int accountNumber = ThreadLocalRandom.current().nextInt(1000, 10000);
            var NewAccount = new Account(accountNumber);
            var NewCustomer = new Customer(username, NewAccount);
            customers.add(NewCustomer);
            return NewCustomer;
        }

    public Customer loginCustomer(String username, int password) {
        for (Customer customer : customers) {
            if (customer.getUsername().equals(username) && customer.getAccount().getAccountNumber() == password) {
                System.out.println("Logged in successfully.");
                return customer;
            }
        }
        return null;
    }
}

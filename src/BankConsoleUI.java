public class BankConsoleUI {

    public void createAccountController(Customer customer, IbanGeneratable iban, SearchIbanToAccountable searchIbanToAccountable) {

        Bank bank = new Bank(customer, iban, searchIbanToAccountable);

        while (true) {
            System.out.println("""
                    1. Create a Sub-Account
                    2. Open Sub-Account
                    3. Transfer
                    4. Open Transaction History
                    5. Exit""");
            bank.Loop();
        }
    }

    public void setSavingsAccountController(Customer customer,SavingsAccount savingsAccount) {
        customer.getAccount().setSavingsAccount(savingsAccount);
        System.out.println("The IBAN of this account is " + customer.getAccount().getSavingsAccount().getIBAN().replaceAll("(.{4})(?=.)", "$1 "));
    }

    public void setCheckingAccountController(Customer customer,CheckingAccount checkingAccount) {
        customer.getAccount().setCheckingAccount(checkingAccount);
        System.out.println("The IBAN of this account is " + customer.getAccount().getCheckingAccount().getIBAN().replaceAll("(.{4})(?=.)", "$1 "));
    }
    public void invalid(){
        System.out.println("Please enter a valid option");
    }

    public void exiting(){
        System.out.println("Exiting...");
    }

    public void subAccountList(){
        System.out.println("1. Bank Account" + "\n" + "2. Savings Account");
    }
}
public interface Accountable {
    double   getBalance();
    void     deposit(double amt);
    void     withdraw(double amt);
    String   getIBAN();
}
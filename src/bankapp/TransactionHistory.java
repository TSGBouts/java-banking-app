package bankapp;

public record TransactionHistory(String timestamp, String type, double amount, String description) {
}

package bankapp.terminalService;

public record TransactionHistory(String timestamp, String type, double amount, String description) {
}

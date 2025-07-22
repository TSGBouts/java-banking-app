import java.time.LocalDateTime;

public class TransactionHistory {
    private final String timestamp;
    private final String type;
    private final double amount;
    private final String description;

    public TransactionHistory(String timestamp, String type, double amount, String description) {
        this.timestamp = timestamp;
        this.type = type;
        this.amount = amount;
        this.description = description;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public String getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }
}

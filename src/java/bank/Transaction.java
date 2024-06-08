package bank;

import java.math.BigDecimal;

public class Transaction {

    private TransactionType type;
    private BigDecimal amount;
    private String accountNumber;

    public Transaction(TransactionType type, BigDecimal amount, int accountNumber) {
        this.type = type;
        this.amount = amount;
        this.accountNumber = String.valueOf(accountNumber);
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public TransactionType getType() {
        return type;
    }

    public String getAccountNumber() {
        return accountNumber;
    }
}
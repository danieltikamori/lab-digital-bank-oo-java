package bank;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Transactions {

    private List<Transaction> transactionsList;

    public Transactions() {
        this.transactionsList = new ArrayList<>();
    }

    public void addTransaction(Transaction transaction) {
        transactionsList.add(transaction);
    }

    public List<Transaction> getTransactions() {
        return transactionsList;
    }

    public BigDecimal getTotalBalance() {
        BigDecimal total = BigDecimal.ZERO;
        for (Transaction transaction : transactionsList) {
            total = total.add(transaction.getAmount());
        }
        return total;
    }

    public List<Transaction> getTransactionsByType(TransactionType type) {
        List<Transaction> filteredTransactions = new ArrayList<>();
        for (Transaction transaction : transactionsList) {
            if (transaction.getType() == type) {
                filteredTransactions.add(transaction);
            }
        }
        return filteredTransactions;
    }

    public List<Transaction> getTransactionsByAccount(String accountNumber) {
        List<Transaction> filteredTransactions = new ArrayList<>();
        for (Transaction transaction : transactionsList) {
            if (transaction.getAccountNumber().equals(accountNumber)) {
                filteredTransactions.add(transaction);
            }
        }
        return filteredTransactions;
    }

    // Other methods for filtering or analyzing transactionsList can be added here
}

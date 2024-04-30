package Mutex;

import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class BankTransaction implements Runnable {
    private BankAccount account;
    private TransactionType transactionType;
    private double amount;
    private DateTimeFormatter dateTimeFormatter;
    private Lock lock;

    public BankTransaction(BankAccount account, TransactionType transactionType, double amount) {
        this.account = account;
        this.transactionType = transactionType;
        this.amount = amount;
        this.dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        this.lock = new ReentrantLock();
    }

    @Override
    public void run() {
        lock.lock(); // Acquire the lock

        try {
            switch (transactionType) {
                case DEPOSIT:
                    account.deposit(amount);
                    System.out.println(LocalDateTime.now().format(dateTimeFormatter) + " - Deposited: " + formatCurrency(amount));
                    break;
                case WITHDRAWAL:
                    if (account.withdraw(amount)) {
                        System.out.println(LocalDateTime.now().format(dateTimeFormatter) + " - Withdrawn: " + formatCurrency(amount));
                    } else {
                        System.out.println(LocalDateTime.now().format(dateTimeFormatter) + " - Failed to withdraw: Insufficient funds for " + formatCurrency(amount));
                    }
                    break;
            }
        } finally {
            lock.unlock(); // Release the lock
        }
    }

    private String formatCurrency(double amount) {
        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(new Locale("en", "IN"));
        return currencyFormat.format(amount);
    }
}

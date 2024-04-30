package Mutex;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
class BankAccount {
    private double balance;
    private List<String> transactionHistory;
    private Lock lock;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
        this.transactionHistory = new ArrayList<>();
        this.lock = new ReentrantLock();
    }

    public void deposit(double amount) {
        lock.lock();//Mutex lock
        try {
            balance += amount;
            transactionHistory.add("Deposit of " + formatCurrency(amount));
        } finally {
            lock.unlock();
        }
    }

    public boolean withdraw(double amount) {
        lock.lock();
        try {
            if (balance >= amount) {
                balance -= amount;
                transactionHistory.add("Withdrawal of " + formatCurrency(amount));
                return true;
            } else {
                return false; 
            }
        } finally {
            lock.unlock();//Unlock
        }
    }

    public double getBalance() {
        return balance;
    }

    public void printTransactionHistory() {
        System.out.println("Transaction History:");
        for (String transaction : transactionHistory) {
            System.out.println(transaction);
        }
    }

    private String formatCurrency(double amount) {
    	NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(new Locale("en", "IN"));
        return currencyFormat.format(amount);
    }
}

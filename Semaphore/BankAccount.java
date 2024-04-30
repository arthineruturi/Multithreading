package Semaphore;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

import java.text.SimpleDateFormat;
import java.util.Date;
class BankAccount {
    private double balance;
    private List<String> transactionHistory;
    private Semaphore semaphore; 

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
        this.transactionHistory = new ArrayList<>();
        this.semaphore = new Semaphore(1);//One permit

    }

    public void deposit(double amount) {
        try {
            semaphore.acquire();// Acquire a permit
            System.out.println("Acquired Semphore for deposit");
            balance += amount;
            transactionHistory.add("Deposit of " + formatCurrency(amount) + " at " + getCurrentTime());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
        	 System.out.println("Released Semphore for deposit");
            semaphore.release(); // Release the permit
        }
    }

    public boolean withdraw(double amount) {
        try {
            semaphore.acquire(); // Acquire a permit
            System.out.println("Acquired Semphore for withdraw");
            if (balance >= amount) {
                balance -= amount;
                transactionHistory.add("Withdrawal of " + formatCurrency(amount) + " at " + getCurrentTime());
                return true;
            } else {
                return false; 
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            return false;
        } finally {
            semaphore.release();
            System.out.println("Released Semphore for withdraw");
            // Release the permit
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
        
        return String.valueOf(amount);
    }

    private String getCurrentTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return dateFormat.format(new Date());
    }
}
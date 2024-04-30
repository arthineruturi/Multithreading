package Semaphore;

class BankTransaction implements Runnable {
    private BankAccount account;
    private TransactionType transactionType;
    private double amount;

    public BankTransaction(BankAccount account, TransactionType transactionType, double amount) {
        this.account = account;
        this.transactionType = transactionType;
        this.amount = amount;
    }

    @Override
    public void run() {
        switch (transactionType) {
            case DEPOSIT:
                account.deposit(amount);
                break;
            case WITHDRAWAL:
                account.withdraw(amount);
                break;
        }
    }
}
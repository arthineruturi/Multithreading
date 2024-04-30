package Semaphore;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class BankSimulation {
    public static void main(String[] args) throws InterruptedException {
        BankAccount account = new BankAccount(1000);
        List<Thread> threads = new ArrayList<>();
        int numThreads = 5;
        Random random = new Random();

        for (int i = 0; i < numThreads; i++) {
            double depositAmount = random.nextDouble() * 500; 
            double withdrawalAmount = random.nextDouble() * 200;
            Thread depositThread = new Thread(new BankTransaction(account, TransactionType.DEPOSIT, depositAmount));
            Thread withdrawalThread = new Thread(new BankTransaction(account, TransactionType.WITHDRAWAL, withdrawalAmount));
            threads.add(depositThread);
            threads.add(withdrawalThread);
            depositThread.start();
            withdrawalThread.start();

            //Thread.sleep(random.nextInt(1000)); 
        }

        for (Thread thread : threads) {
            thread.join();
        }

       
        account.printTransactionHistory();
        System.out.println("Final account balance: $" + account.getBalance());
    }
}
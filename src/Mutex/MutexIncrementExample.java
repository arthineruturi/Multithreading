package Mutex;

public class MutexIncrementExample {
	
	    public static void main(String[] args) throws InterruptedException {
	      
	        int numThreads = 500;  
	        Thread[] threads = new Thread[numThreads];
	        for (int i = 0; i < numThreads; i++) {
	            threads[i] = new IncrementerThread((char) ('A' + i));
	            threads[i].start();
	        }

	        for (Thread thread : threads) {
	            thread.join();
	        }

	        System.out.println("Final counter value: " + IncrementerThread.getCounter());
	    }
	
}
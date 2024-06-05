	package MutexExample;
	
	public class MutexIncrementExample {
	    public static void main(String[] args) throws InterruptedException {
//	        
	        Mutex mutex = new Mutex();
	        int numThreads = 500;
	        Thread threadA = new IncrementerThread(mutex, 'A');
	        Thread threadB = new IncrementerThread(mutex, 'B');
	
	        threadA.start();
	        threadB.start();
	
	        try {
	            threadA.join();
	            threadB.join();
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	
//	        Thread[] threads = new Thread[numThreads];
//	        for (int i = 0; i < numThreads; i++) {
//	            threads[i] = new IncrementerThread(mutex, 'A');
//	            threads[i].start();
//	        }
//	        for (Thread thread : threads) {
//	            thread.join();
//	        }

	        System.out.println("Final counter value " + IncrementerThread.getCounter());
	    }
	}
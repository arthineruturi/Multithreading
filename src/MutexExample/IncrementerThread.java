package MutexExample;

class IncrementerThread extends Thread {
    private Mutex mutex;
    private static int counter = 5;
    private char threadIdentifier;

    public IncrementerThread(Mutex mutex, char threadIdentifier) {
        this.mutex = mutex;
        this.threadIdentifier = threadIdentifier;
    }

    public void run() {
        try {
            mutex.lock("Thread " + threadIdentifier);
            System.out.println("Thread " + threadIdentifier + " entered the critical section.");
            counter++;
            System.out.println("Thread " + threadIdentifier + " incremented counter to " + counter);

//            for(int i=0;i<100;i++) {
//                counter++;
//                System.out.println("Thread " + threadIdentifier + " incremented counter to " + counter);
//            }
//           
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            mutex.unlock("Thread " + threadIdentifier);
           
        }


    }

    public static int getCounter() {
        return counter;
    }
}

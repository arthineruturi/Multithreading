package Mutex;
class IncrementerThread extends Thread {
    private static int counter = 5;
    private char threadIdentifier;

    public IncrementerThread(char threadIdentifier) {
        this.threadIdentifier = threadIdentifier;
    }

    public void run() {
        System.out.println("Thread " + threadIdentifier + " entered the critical section.");
        for(int i=0;i<100;i++) {
            counter++;
            System.out.println("Thread " + threadIdentifier + " incremented counter to " + counter);
        }


//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        System.out.println("Thread " + threadIdentifier + " exited the critical section.");

//        try {
//            Thread.sleep(500);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }

    public static int getCounter() {
        return counter;
    }
}

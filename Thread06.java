// Java: A Beginner's Guide. Sixth Edition
// Chapter 11 Multithreaded Programming
// Thread Priorities (p.387)

class Priority implements Runnable {
    int count;
    Thread thrd;

    static int switches = 0;
    static boolean stop = false;
    static String currentName;

    Priority(String name) {
        thrd = new Thread(this, name);
        count = 0;
        currentName = name;
    }

    public void run() {
        System.out.println(thrd.getName() + " starting.");
        do {
            count++;

            if (currentName.compareTo(thrd.getName()) != 0) {
                switches++;
                currentName = thrd.getName();
                System.out.println("In " + currentName);
            }
        } while  (stop == false && count < 10000000);
        stop = true;

        System.out.println("\n" + thrd.getName() + " terminating.");
    }
}

class Thread06 {
    public static void main(String args[]) {
        Priority mt1 = new Priority("High priority");
        Priority mt2 = new Priority("Low priority");
        
        mt1.thrd.setPriority(Thread.NORM_PRIORITY + 2);
        mt2.thrd.setPriority(Thread.NORM_PRIORITY - 2);

        mt1.thrd.start();
        mt2.thrd.start();

        try {
            mt1.thrd.join();
            mt2.thrd.join();
        }
        catch(InterruptedException exc) {
            System.out.println("Main thread interrupted.");
        }

        System.out.println(mt1.thrd.getName() + " thread counted to " + mt1.count);
        System.out.println(mt2.thrd.getName() + " thread counted to " + mt2.count);
        System.out.println("Switches detected " + Priority.switches);
    }
}
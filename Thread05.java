// Java: A Beginner's Guide. Sixth Edition
// Chapter 11 Multithreaded Programming
// Determing When a Thread Ends (p.385), using join()

class MyThread05 extends Thread {

    MyThread05(String name) {
        super(name);
        start();
    }

    public void run() {
        System.out.println(getName() + " starting.");
        try {
            for(int count=0; count < 10; count++) {
                Thread.sleep(400);
                System.out.println("In " + getName() + ", count is " + count);
            }
        }
        catch(InterruptedException exc) {
            System.out.println(getName() + " interrrupted.");        
        }
        System.out.println(getName() + " terminating.");        
    }
}

class Thread05 {
    public static void main(String args[]) {
        System.out.println("Main thread starting.");       

        MyThread05 mt1 = new MyThread05("Child #1");
        MyThread05 mt2 = new MyThread05("Child #2");
        MyThread05 mt3 = new MyThread05("Child #3");

        try {
            mt1.join();
            System.out.println(mt1.getName() + " joined.");
            mt2.join();
            System.out.println(mt2.getName() + " joined.");
            mt3.join();
            System.out.println(mt3.getName() + " joined.");
        }
        catch(InterruptedException exc) {
            System.out.println("Main thread interrupted.");
        }
        
        System.out.println("Main thread ending.");
    }
}
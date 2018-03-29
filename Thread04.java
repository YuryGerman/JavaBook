// Java: A Beginner's Guide. Sixth Edition
// Chapter 11 Multithreaded Programming
// Determing When a Thread Ends (p.384)

class MyThread04 extends Thread {

    MyThread04(String name) {
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

class Thread04 {
    public static void main(String args[]) {
        System.out.println("Main thread starting.");       

        MyThread04 mt1 = new MyThread04("Child #1");
        MyThread04 mt2 = new MyThread04("Child #2");
        MyThread04 mt3 = new MyThread04("Child #3");

        do {
            System.out.print(".");
            try {
                Thread.sleep(100);
            }
            catch(InterruptedException exc) {
                System.out.println("Main thread interrupted.");
            }
        } while (mt1.isAlive() || mt2.isAlive() || mt3.isAlive());

        System.out.println("Main thread ending.");
    }
}
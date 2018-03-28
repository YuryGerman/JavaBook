// Java: A Beginner's Guide. Sixth Edition
// Chapter 11 Multithreaded Programming
// Extending Thread (p.379)

class MyThread03 extends Thread {

    MyThread03(String name) {
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

class Thread03 {
    public static void main(String args[]) {
        System.out.println("Main thread starting.");       

        MyThread03 mt = new MyThread03("Child #1");

        for(int i=0; i<50; i++) {
            System.out.print("[" + i + "]");
            try {
                Thread.sleep(100);
            }
            catch(InterruptedException exc) {
                System.out.println("Main thread interrupted.");
            }
        }

        System.out.println("Main thread ending.");
    }
}
// Java: A Beginner's Guide. Sixth Edition
// Chapter 11 Multithreaded Programming
// Creating a Thread (p.374)

class MyThread01 implements Runnable {
    String thrdName;

    MyThread01(String name) {
        thrdName = name;
    }

    public void run() {
        System.out.println(thrdName + " starting.");
        try {
            for(int count=0; count < 10; count++) {
                Thread.sleep(400);
                System.out.println("In " + thrdName + ", count is " + count);
            }
        }
        catch(InterruptedException exc) {
            System.out.println(thrdName + " interrrupted.");        
        }
        System.out.println(thrdName + " terminating.");        
    }
}

class Thread01 {
    public static void main(String args[]) {
        System.out.println("Main thread starting.");       

        MyThread01 mt = new MyThread01("Child #1");

        Thread newThrd = new Thread(mt);

        newThrd.start();

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
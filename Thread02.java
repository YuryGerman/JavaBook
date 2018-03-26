// Java: A Beginner's Guide. Sixth Edition
// Chapter 11 Multithreaded Programming
// Some Simple Improvements (p.378)

class MyThread02 implements Runnable {
    Thread thrd;

    MyThread02(String name) {
        thrd = new Thread(this, name);
        thrd.start();
    }

    public void run() {
        System.out.println(thrd.getName() + " starting.");
        try {
            for(int count=0; count < 10; count++) {
                Thread.sleep(400);
                System.out.println("In " + thrd.getName() + ", count is " + count);
            }
        }
        catch(InterruptedException exc) {
            System.out.println(thrd.getName() + " interrrupted.");        
        }
        System.out.println(thrd.getName() + " terminating.");        
    }
}

class Thread02 {
    public static void main(String args[]) {
        System.out.println("Main thread starting.");       

        MyThread02 mt = new MyThread02("Child #1");

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
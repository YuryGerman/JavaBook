// Java: A Beginner's Guide. Sixth Edition
// Chapter 11 Multithreaded Programming
// Using Synchronized Methods (p.390)

class SumArray {
    
    private int sum;

    // Do the second run without synchronized keyword
    // int sumArray(int nums[]) {
    synchronized int sumArray(int nums[]) {
        sum = 0;

        for(int i=0; i<nums.length; i++) {
            sum += nums[i];
            System.out.println("Running total for " + 
                Thread.currentThread().getName() + " is " + sum);
            try {
                Thread.sleep(10);
            }    
            catch(InterruptedException exc) {
                System.out.println("Thread interrupted.");
            }
        }
        return sum;
    }
}

class MyThread07 implements Runnable {
    Thread thrd;
    static SumArray sa = new SumArray();
    int a[];
    int answer;

    MyThread07(String name, int nums[]) {
        thrd = new Thread(this, name);
        a = nums;
        thrd.start();
    }

    public void run() {
        int sum;

        System.out.println(thrd.getName() + " starting.");

        answer = sa.sumArray(a);

        System.out.println("Sum for " + thrd.getName() + " is " + answer);

        System.out.println(thrd.getName() + " terminating.");
    }
}

class Thread07 {
    public static void main(String args[]) {
        int a[] = {1, 2, 3, 4, 5};

        MyThread07 mt1 = new MyThread07("Child #1", a);
        MyThread07 mt2 = new MyThread07("Child #2", a);
        
        try {
            mt1.thrd.join();
            mt2.thrd.join();
        }
        catch(InterruptedException exc) {
            System.out.println("Main thread interrupted.");
        }

    }
}
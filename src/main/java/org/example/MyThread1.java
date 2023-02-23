package org.example;

public class MyThread1 extends Thread {
    int n;
    int start;
    int end;
    public MyThread1 (int n, int start, int end) {
        this.n = n;
        this.start = start;
        this.end = end;
    }

    private boolean isSimplestNumber(int number)
    {
        for (int i = 2; i<=Math.sqrt(number); i++) {
            if(number % i ==0)
            {
                return false;
            }
        }
        return true;
    }
    public int counter = 0;
    public void run() {
        System.out.println(String.format("Thread started in: %d:%d", start,end));
        for (int i = start; i <= end; i++) {
           // System.out.print(i);
            if (isSimplestNumber(i) && i != 1) {
                counter++;
            }
        }
    }
}

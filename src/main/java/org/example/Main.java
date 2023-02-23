package org.example;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Task1();
        Task2();
    }

    public static void Task1() throws InterruptedException {
        long startTime = System.currentTimeMillis();
        final int numberOfThreads = 3;
        final int n = 20;

        System.out.println("Задание 1");
        int numberOfElementsInThread = n / numberOfThreads;
        MyThread1[] threads = new MyThread1[numberOfThreads];
        for (int i = 0; i < numberOfThreads; i++) {
            int start = i * numberOfElementsInThread + 1;
            int end = (i+1) * numberOfElementsInThread;

            if (i == numberOfThreads-1) {
                end = n;
            }
            threads[i] = new MyThread1(n, start, end);
            threads[i].start();
        }

        for (int i = 0; i < numberOfThreads; i++) {
            threads[i].join();
        }

        int count = 0;

        for (int i = 0; i < numberOfThreads; i++) {
            count += threads[i].counter;
        }
        System.out.println(String.format("Количество простых чисел: %d", count));
        long endTime = System.currentTimeMillis();
        System.out.println(String.format("Затраченное время: %d", endTime - startTime));
    }

    public static void Task2() throws InterruptedException {
        long startTime = System.currentTimeMillis();
        final int numberOfThreads = 4;
        final int size = 30;
        int[] array = new int[size];

        for (int i = 0; i < size; i++) {
            array[i] = i;
        }

        System.out.println("Задание 2");
        int numberOfElementsInThread = array.length / numberOfThreads;
        MyThread2[] threads = new MyThread2[numberOfThreads];
        for (int i = 0; i < numberOfThreads; i++) {
            int start = i * numberOfElementsInThread;
            int end = (i+1) * numberOfElementsInThread - 1;
            if (i == numberOfThreads-1) {
                end = array.length - 1;
            }
            threads[i] = new MyThread2(array, start, end);
            threads[i].start();
        }

        for (int i = 0; i < numberOfThreads; i++) {
            threads[i].join();
        }

        int sum = 0;

        for (int i = 0; i < numberOfThreads; i++) {
            sum += threads[i].sum;
        }

        System.out.println(String.format("Сумма элементов чисел: %d", sum));
        long endTime = System.currentTimeMillis();
        System.out.println(String.format("Затраченное время: %d", endTime - startTime));
    }
}
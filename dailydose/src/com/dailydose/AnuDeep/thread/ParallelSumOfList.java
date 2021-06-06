package com.dailydose.AnuDeep.thread;

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;


public class ParallelSumOfList extends RecursiveTask<Double> {

    private static final int LIMIT = 10000;

    private int lowerIndex, higherIndex;

    private double[] list;

    public ParallelSumOfList(double [] list, int lowerIndex, int higherIndex) {
        this.list = list; // set list
        // set range
        this.lowerIndex = lowerIndex;
        this.higherIndex = higherIndex;
    }

    // compute method
    protected Double compute() {
        // check current range
        if ((higherIndex - lowerIndex) <= LIMIT) {
            // sum
            double sum = 0.0;
            for (int i = lowerIndex; i < higherIndex; i++) {
                sum += list[i];
            }
            return sum; // return sum
        } else {
            // split in half
            int mid = lowerIndex + (lowerIndex + higherIndex) / 2;

            ParallelSumOfList lowerIndexer = new ParallelSumOfList(list, lowerIndex, mid);
            ParallelSumOfList upper = new ParallelSumOfList(list, mid, higherIndex);
          
            // compute both
            lowerIndexer.fork();
            upper.fork();

            // sum result
            double sum = lowerIndexer.join() + upper.join();
            return sum;
        }
    }

    // parallelSum Method
    public static double parallelSum(double[] list) {
        ForkJoinPool forkJoinPool = new ForkJoinPool(4);
        // invoke a new object and return result
        ParallelSumOfList obj = new ParallelSumOfList(list, 0, list.length);
        return forkJoinPool.invoke(obj); // calculate and return result
    }

    public static double sequentialSum(double[] numList) {
        // method to calculate sequential sum
        double sumSequetial = 0;
        for (int i = 0; i < numList.length; i++) {
        	sumSequetial += numList[i];
        }

        // return sum
        return sumSequetial;
    }

    // helper method to generate a list of doubles
    public static double[] generateRandValList(int length) {
        Random random = new Random();
        double res[] = new double[length];
        // generate
        for (int i = 0; i < length; i++) {
            res[i] = random.nextDouble();
        }
        return res;
    }

    // main method
    public static void main(String[] args) {
        // get list
        double[] list = generateRandValList(9000000);
        // record time
        long start = System.currentTimeMillis();
        // display Result
        System.out.println("Parallel Sum");
        double parallelResult = parallelSum(list);
        System.out.println("Sum = " + parallelResult);
        double parallelTime = System.currentTimeMillis() - start;
        System.out.println("Time taken = " + parallelTime + " m.sec");

        // use sequential
        start = System.currentTimeMillis();
        System.out.println("Sequential Sum");

        double sequentialResult = sequentialSum(list);
        // display Result
        System.out.println("Sum = " + sequentialResult);
        double sequentialTime = System.currentTimeMillis() - start;

        System.out.println("Time taken = " + sequentialTime + " m.sec");

    }
}
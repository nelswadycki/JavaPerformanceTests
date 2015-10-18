package com.nelswadycki.java.tests;

/**
 * Description: Compare how long it takes to call different time functions.
 *
 * @author <a href="mailto:nels.wadycki@gmail.com">Nels Wadycki</a>
 */

public class CompareTimeFunctions {

    private static final int TEST_NUMBER = 10_000_000;

    /**
     * Please note: This class takes a while (a few minutes) to run.
     *
     * @param args Not used
     */
    public static void main(String args[]) {
        systemNanoTimeTestWithMillis();
        systemCurrentTimeMillisTestWithMillis();
        systemNanoTimeTestWithNano();
        systemCurrentTimeMillisTestWithNano();

        long count = 0;
        for (int i = 0; i < 10; i++) {
            count += compareTimesWithMillis();
        }
        System.out.println("Number of times nanoTime was slower than currentTimeMillis: " + count);

        long nCount = 0;
        for (int i = 0; i < 10; i++) {
            nCount += compareTimeWithNano();
        }
        System.out.println("Number of times nanoTime was slower than currentTimeMillis: " + nCount);

        // http://sharmaak.blogspot.com/2012/08/systemnanotime-vs-systemcurrenttimemill.html
        System.out.println("\nRunning Sharmaak test: ");
        sharmaakTest();
    }

    private static void sharmaakTest() {
        int count = 10 * 1000 * 1000;
        long[] times = new long[count];

        long t1 = System.nanoTime();
        for (int i = 0; i < count; i++) {
            times[i] = System.nanoTime();
        }
        long t2 = System.nanoTime();
        for (int i = 0; i < count; i++) {
            times[i] = System.currentTimeMillis();
        }
        long t3 = System.nanoTime();

        System.out.println("Total time nano : " + ((t2 - t1) / (1000 * 1000)) + "ms");
        System.out.println("Total time millis: " + ((t3 - t2) / (1000 * 1000)) + "ms");
        System.out.println("");
        System.out.println("Avg time nano : " + ((t2 - t1) / count) + "ns");
        System.out.println("Avg time millis: " + ((t3 - t2) / count) + "ns");
    }

    private static void systemNanoTimeTestWithMillis() {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < TEST_NUMBER; i++) {
            long nanoTime = System.nanoTime();
        }
        System.out.println("Time to run using nanoTime: " + (System.currentTimeMillis() - startTime));
    }

    private static void systemCurrentTimeMillisTestWithMillis() {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < TEST_NUMBER; i++) {
            long currentTime = System.currentTimeMillis();
        }
        System.out.println("Time to run using currentTimeMillis: " + (System.currentTimeMillis() - startTime));
    }

    private static void systemNanoTimeTestWithNano() {
        long startTime = System.nanoTime();
        for (int i = 0; i < TEST_NUMBER; i++) {
            long nanoTime = System.nanoTime();
        }
        System.out.println("Time to run using nanoTime: " + (System.nanoTime() - startTime) / 1000000);
    }

    private static void systemCurrentTimeMillisTestWithNano() {
        long startTime = System.nanoTime();
        for (int i = 0; i < TEST_NUMBER; i++) {
            long currentTime = System.currentTimeMillis();
        }
        System.out.println("Time to run using currentTimeMillis: " + (System.nanoTime() - startTime) / 1000000);
    }

    private static long compareTimesWithMillis() {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < TEST_NUMBER; i++) {
            long currentTime = System.currentTimeMillis();
        }
        long millis = System.currentTimeMillis() - startTime;

        startTime = System.currentTimeMillis();
        for (int i = 0; i < TEST_NUMBER; i++) {
            long currentTime = System.nanoTime();
        }
        long nanos = System.currentTimeMillis() - startTime;

        //String result = nanos - millis > 0 ? "nanos > millis" : "millis > nanos";
        //System.out.println("Time to run using currentTimeMillis: " + result);
        return nanos - millis > 0 ? 1 : 0;
    }

    private static long compareTimeWithNano() {
        long startTime = System.nanoTime();
        for (int i = 0; i < TEST_NUMBER; i++) {
            long currentTime = System.currentTimeMillis();
        }
        long millis = System.nanoTime() - startTime;

        startTime = System.nanoTime();
        for (int i = 0; i < TEST_NUMBER; i++) {
            long currentTime = System.nanoTime();
        }
        long nanos = System.nanoTime() - startTime;

        //String result = nanos - millis > 0 ? "nanos > millis" : "millis > nanos";
        //System.out.println("Time to run using currentTimeMillis: " + result);
        return nanos - millis > 0 ? 1 : 0;
    }
}

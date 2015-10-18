package com.nelswadycki.java.tests;

import java.util.concurrent.TimeUnit;

/**
 * Description: Speed/performance tests for Autoboxing of Integers.
 *
 * @author <a href="mailto:nwadycki@gohealth.com">Nels Wadycki</a>
 */

public class IntegerAutoboxingTest {

    public static void main(String args[]) {
        integerSumTest();
        objectCreationTest();
    }

    private static void integerSumTest() {
        Integer sum_object = Integer.valueOf(0);

        long start = System.nanoTime();

        for (int i = 0; i < 100000; i++) {
            sum_object += Integer.valueOf(i);
        }

        long sum_object_time = System.nanoTime() - start;
        System.out.println(sum_object_time + " ns for Integer valueOf() sum; end sum = " + sum_object);

        // setup
        Integer sum_object_auto = Integer.valueOf(0);
        start = System.nanoTime();

        for (int i = 0; i < 100000; i++) {
            sum_object_auto += i;
        }
        long sum_autobox_time = System.nanoTime() - start;
        System.out.println(sum_autobox_time + " ns for Integer sum with autoboxing; autobox time - object time = " + (sum_autobox_time - sum_object_time) + "; end sum = " + sum_object_auto);

        // setup
        int sum_primitive = 0;
        start = System.nanoTime();

        for (int i = 0; i < 100000; i++) {
            sum_primitive += i;
        }

        long sum_primitive_time = System.nanoTime() - start;
        System.out.println(sum_primitive_time + " ns for long primitive creation; end sum = " + sum_primitive);
    }

    private static void objectCreationTest() {
        System.out.println();

        long start = System.nanoTime();
        Integer create_object = Integer.valueOf(0);

        for (int i = 0; i < 100000; i++) {
            create_object = Integer.valueOf(i);
        }

        long create_value_of_time = System.nanoTime() - start;
        System.out.println(create_value_of_time + " ns for Integer creation wtih valueOf(); Integer value = " + create_object);

        // setup
        start = System.nanoTime();
        Integer create_object_auto = 0;

        for (int i = 0; i < 100000; i++) {
            create_object_auto = i;
        }
        long create_autobox_time = System.nanoTime() - start;
        System.out.println(create_autobox_time + " ns for Long creation with autoboxing; autobox time - object time = " + (create_autobox_time - create_value_of_time) + "; Integer value = " + create_object_auto);

        // setup
        start = System.nanoTime();
        int create_primitive = 0;

        for (int i = 0; i < 100000; i++) {
            create_primitive = i;
        }

        long create_primitive_time = System.nanoTime() - start;
        System.out.println(create_primitive_time + " ns for long creation; int value = " + create_primitive);
    }
}

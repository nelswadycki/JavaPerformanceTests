package com.nelswadycki.java.tests;

public class StringConcatTest {

    public static void main(String[] args) {
        final int ITERATION = 100_000;
        String s = "";

        // String Concatenation using + operator
        long startTime = System.nanoTime();

        for (int i = 0; i < ITERATION; i++) {
            s = s + Integer.toString(i);
        }

        long duration = (System.nanoTime() - startTime) / 1000;
        System.out.println("Time taken to concatenate 100000 Strings using + operator (in micro) : " + duration);

        // Using String concat() method
        startTime = System.nanoTime();

        for (int i = 0; i < ITERATION; i++) {
            s.concat(Integer.toString(i));
        }
        duration = (System.nanoTime() - startTime) / 1000;
        System.out.println("Time taken to concatenate 100000 Strings using concat method (in micro) : " + duration);

        // StringBuilder example to concate two String in Java
        StringBuilder builder = new StringBuilder();

        //default size for worst case
        startTime = System.nanoTime();
        for (int i = 0; i < ITERATION; i++) {
            builder.append(i);
        }
        duration = (System.nanoTime() - startTime) / 1000;
        System.out.println("Time taken to concatenate 100000 Strings using StringBuilder append (in micro) : " + duration);

        // Using the String join() method
        s = "";

        startTime = System.nanoTime();
        for (int i = 0; i < ITERATION; i++) {
            s.join("", Integer.toString(i));
        }
        duration = (System.nanoTime() - startTime) / 1000;
        System.out.println("Time taken to concatenate 100000 Strings using join method (in micro) : " + duration);

        // "/consent/phone/" + criteria.getPhoneNumber() + "/type/" + criteria.getConsentType() + "/company/" + criteria.getCompanyId()
        String s2 = "";
        String phoneNumber = "3125551212";
        String consentType = "1";
        String company = "1";

        // String Concatenation using + operator
        startTime = System.nanoTime();

        s2 = "/consent/phone/" + phoneNumber + "/type/" + consentType + "/company/" + company;

        duration = (System.nanoTime() - startTime) / 1000;
        System.out.println("Time taken to concatenate REST API Strings using + operator (in micro) : " + duration);

        // Using String concat() method
        s2 = "";
        startTime = System.nanoTime();

        s2.concat("/consent/phone/").concat(phoneNumber).concat("/type/").concat(consentType).concat("/company/").concat(company);

        duration = (System.nanoTime() - startTime) / 1000;
        System.out.println("Time taken to concatenate REST API Strings using concat method (in micro) : " + duration);

        // StringBuilder example to concate two String in Java
        StringBuilder builder2 = new StringBuilder();

        //default size for worst case
        startTime = System.nanoTime();

        builder2.append("/consent/phone/").append(phoneNumber).append("/type/").append(consentType).append("/company/").append(company);

        duration = (System.nanoTime() - startTime) / 1000;
        System.out.println("Time taken to concatenate REST API Strings using StringBuilder append in micro) : " + duration);

        // Using String join() method
        s2 = "";
        startTime = System.nanoTime();

        s2.join("", "/consent/phone/", phoneNumber, "/type", consentType, "/company/", company);

        duration = (System.nanoTime() - startTime) / 1000;
        System.out.println("Time taken to concatenate REST API String using join method (in micro) : " + duration);
    }

}

/**
 * Results
 *
 * Run 1:
 * Time taken to concatenate 100000 Strings using + operator (in micro) : 23164522
 * Time taken to concatenate 100000 Strings using concat method (in micro) : 13142365
 * Time taken to concatenate 100000 Strings using StringBuilder append (in micro) : 7201
 * Time taken to concatenate 100000 Strings using join method (in micro) : 20296
 * Time taken to concatenate REST API Strings using + operator (in micro) : 25
 * Time taken to concatenate REST API Strings using concat method (in micro) : 29
 * Time taken to concatenate REST API Strings using StringBuilder append in micro) : 24
 * Time taken to concatenate REST API String using join method (in micro) : 43
 *
 * Run 2:
 * Time taken to concatenate 100000 Strings using + operator (in micro) : 23620461
 * Time taken to concatenate 100000 Strings using concat method (in micro) : 13772607
 * Time taken to concatenate 100000 Strings using StringBuilder append (in micro) : 8764
 * Time taken to concatenate 100000 Strings using join method (in micro) : 19795
 * Time taken to concatenate REST API Strings using + operator (in micro) : 24
 * Time taken to concatenate REST API Strings using concat method (in micro) : 29
 * Time taken to concatenate REST API Strings using StringBuilder append in micro) : 45
 * Time taken to concatenate REST API String using join method (in micro) : 37
 *
 * Run 3:
 * Time taken to concatenate 100000 Strings using + operator (in micro) : 23391610
 Time taken to concatenate 100000 Strings using concat method (in micro) : 13631612
 Time taken to concatenate 100000 Strings using StringBuilder append (in micro) : 6634
 Time taken to concatenate 100000 Strings using join method (in micro) : 20122
 Time taken to concatenate REST API Strings using + operator (in micro) : 24
 Time taken to concatenate REST API Strings using concat method (in micro) : 29
 Time taken to concatenate REST API Strings using StringBuilder append in micro) : 23
 Time taken to concatenate REST API String using join method (in micro) : 38
 *
 */

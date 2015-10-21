package com.nelswadycki.java.tests;

import java.text.MessageFormat;

public class StringConcatTest {

    private static final Boolean runLongTests = Boolean.TRUE;

    public static void main(String[] args) {
        if (runLongTests) {
            concatenate100000Strings();
        }
        restUriConcatenation();
    }

    private static void restUriConcatenation() {
        long startTime;
        long duration;

        // "/consent/phone/" + criteria.getPhoneNumber() + "/type/" + criteria.getConsentType() + "/company/" + criteria.getCompanyId()
        String s2 = "";
        String phoneNumber = "3125551212";
        String consentType = "1";
        String company = "1";

        // =====================================
        // String Concatenation using + operator
        startTime = System.nanoTime();

        s2 = "/consent/phone/" + phoneNumber + "/type/" + consentType + "/company/" + company;

        duration = (System.nanoTime() - startTime);
        System.out.format("%-81s%8d%n", "Time taken to concatenate REST API Strings using + operator (in nano): ", duration);

        // ============================
        // Using String concat() method
        s2 = "";
        startTime = System.nanoTime();

        s2.concat("/consent/phone/").concat(phoneNumber).concat("/type/").concat(consentType).concat("/company/").concat(company);

        duration = (System.nanoTime() - startTime);
        System.out.format("%-81s%8d%n", "Time taken to concatenate REST API Strings using concat method (in nano): ", duration);

        // ===================================================
        // StringBuilder example to concate two String in Java
        StringBuilder builder2 = new StringBuilder();

        startTime = System.nanoTime();

        builder2.append("/consent/phone/").append(phoneNumber).append("/type/").append(consentType).append("/company/").append(company);

        duration = (System.nanoTime() - startTime);
        System.out.format("%-81s%8d%n", "Time taken to concatenate REST API Strings using StringBuilder append in nano): ", duration);

        // ==========================
        // Using String join() method
        s2 = "";
        startTime = System.nanoTime();

        s2.join("", "/consent/phone/", phoneNumber, "/type/", consentType, "/company/", company);

        duration = (System.nanoTime() - startTime);
        System.out.format("%-81s%8d%n", "Time taken to concatenate REST API String using join method (in nano): ", duration);

        // ======================================
        // Use MessageFormat to replace variables
        String messageToFormat = "/consent/phone/{1}/type/{2}/company/{3}";
        startTime = System.nanoTime();

        String result = MessageFormat.format(messageToFormat, phoneNumber, consentType, company);

        duration = (System.nanoTime() - startTime);
        System.out.format("%-81s%8d%n", "Time taken to format REST API String using MessageFormat (in nano): ", duration);
    }

    private static void concatenate100000Strings() {
        final int ITERATION = 100_000;
        String s = "";

        // String Concatenation using + operator
        long startTime = System.nanoTime();

        for (int i = 0; i < ITERATION; i++) {
            s = s + Integer.toString(i);
        }

        long duration = (System.nanoTime() - startTime) / 1000;
        System.out.format("%-81s%8d%n", "Time taken to concatenate 100000 Integers using + operator (in micro): ", duration);

        // Using String concat() method
        startTime = System.nanoTime();

        for (int i = 0; i < ITERATION; i++) {
            s.concat(Integer.toString(i));
        }
        duration = (System.nanoTime() - startTime) / 1000;
        System.out.format("%-81s%8d%n", "Time taken to concatenate 100000 Integers using concat method (in micro): ", duration);

        // StringBuilder example to concate two String in Java
        StringBuilder builder = new StringBuilder();

        //default size for worst case
        startTime = System.nanoTime();
        for (int i = 0; i < ITERATION; i++) {
            builder.append(i);
        }
        duration = (System.nanoTime() - startTime) / 1000;
        System.out.format("%-81s%8d%n", "Time taken to concatenate 100000 Integers using StringBuilder append (in micro): ", duration);

        // Using the String join() method
        s = "";

        startTime = System.nanoTime();
        for (int i = 0; i < ITERATION; i++) {
            s.join("", Integer.toString(i));
        }
        duration = (System.nanoTime() - startTime) / 1000;
        System.out.format("%-81s%8d%n", "Time taken to concatenate 100000 Integers using join method (in micro): ", duration);
    }

}

/**
 * Results
 *
 * Run 1:
 * Time taken to concatenate 100000 Integers using + operator (in micro):           23533860
 * Time taken to concatenate 100000 Integers using concat method (in micro):        13492754
 * Time taken to concatenate 100000 Integers using StringBuilder append (in micro):     6738
 * Time taken to concatenate 100000 Integers using join method (in micro):             19796
 * Time taken to concatenate REST API Strings using + operator (in nano):               1353
 * Time taken to concatenate REST API Strings using concat method (in nano):             975
 * Time taken to concatenate REST API Strings using StringBuilder append in nano):       515
 * Time taken to concatenate REST API String using join method (in nano):              13862
 * Time taken to format REST API String using MessageFormat (in nano):                564019
 *
 * Run 2:
 * Time taken to concatenate 100000 Integers using + operator (in micro):           23553987
 * Time taken to concatenate 100000 Integers using concat method (in micro):        13253129
 * Time taken to concatenate 100000 Integers using StringBuilder append (in micro):     8315
 * Time taken to concatenate 100000 Integers using join method (in micro):             18533
 * Time taken to concatenate REST API Strings using + operator (in nano):               1328
 * Time taken to concatenate REST API Strings using concat method (in nano):             940
 * Time taken to concatenate REST API Strings using StringBuilder append in nano):       606
 * Time taken to concatenate REST API String using join method (in nano):              98030
 * Time taken to format REST API String using MessageFormat (in nano):                574673
 *
 * Run 3:
 * Time taken to concatenate 100000 Integers using + operator (in micro):           23426195
 * Time taken to concatenate 100000 Integers using concat method (in micro):        13428815
 * Time taken to concatenate 100000 Integers using StringBuilder append (in micro):     6806
 * Time taken to concatenate 100000 Integers using join method (in micro):             17699
 * Time taken to concatenate REST API Strings using + operator (in nano):               1514
 * Time taken to concatenate REST API Strings using concat method (in nano):            1002
 * Time taken to concatenate REST API Strings using StringBuilder append in nano):       542
 * Time taken to concatenate REST API String using join method (in nano):              51595
 * Time taken to format REST API String using MessageFormat (in nano):                637133
 *
 * Run 4:
 * Time taken to concatenate 100000 Integers using + operator (in micro):           23323657
 * Time taken to concatenate 100000 Integers using concat method (in micro):        13522189
 * Time taken to concatenate 100000 Integers using StringBuilder append (in micro):     6372
 * Time taken to concatenate 100000 Integers using join method (in micro):             17590
 * Time taken to concatenate REST API Strings using + operator (in nano):               1446
 * Time taken to concatenate REST API Strings using concat method (in nano):             968
 * Time taken to concatenate REST API Strings using StringBuilder append in nano):       537
 * Time taken to concatenate REST API String using join method (in nano):              45815
 * Time taken to format REST API String using MessageFormat (in nano):                564502
 */

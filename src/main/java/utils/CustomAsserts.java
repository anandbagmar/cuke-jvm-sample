package utils;

import org.apache.log4j.Logger;
import org.junit.Assert;

import java.util.ArrayList;

public class CustomAsserts {
    private static ArrayList<String> verificationFailures = new ArrayList<String>();

    public static void assertTrue(String errorMessage, boolean condition) {
        Logger logger = (Logger) RuntimeUtils.retrieveState("logger");
        try {
            Assert.assertTrue(condition);
        } catch (AssertionError ae) {
            logger.info("*****Custom Assertion Error" + errorMessage + "*****\n" + ae.toString());
            throw ae;
        }
    }

    public static void assertFalse(String failureMessage, boolean condition) {
        assertEquals(failureMessage, false, condition);
    }

    public static void assertEquals(String failureMessage, Object expected, Object actual){
        org.junit.Assert.assertEquals(failureMessage, expected, actual);
    }

    public static void assertContains (String failureMessage, String expectedSubString, String actualCompleteString) {
        failureMessage = failureMessage + "\n\t\tSubString: " + expectedSubString + "\n\t\t  NOT PRESENT IN: "
                + actualCompleteString;
        assertTrue(failureMessage, actualCompleteString.contains(expectedSubString));
    }

    public static void verifyTrue(String failureMessage, boolean condition) {
        verifyEquals(failureMessage, true, condition);
    }


    public static void verifyFalse(String failureMessage, boolean condition) {
        verifyEquals(failureMessage, false, condition);
    }

    public static void verifyEquals(String failureMessage, Object expected, Object actual) {
        try {
            org.junit.Assert.assertEquals(failureMessage, expected, actual);
        } catch (AssertionError ex) {
            String verificationFailureMessage = "\nVerification Failure";
            verificationFailureMessage += "\t" + failureMessage + "\n\t\tExpected: " + expected.toString() + "\n\t\t  Actual: "
                    + actual.toString();
            verificationFailureMessage += "\nException: " + ex.toString();
            addVerificationFailure(verificationFailureMessage);
        }
    }

    public static void verifyContains (String failureMessage, String expectedSubString, String actualCompleteString) {
        failureMessage = failureMessage + "\n\t\tSubString: " + expectedSubString + "\n\t\t  NOT PRESENT IN: "
                + actualCompleteString;
        verifyTrue(failureMessage,actualCompleteString.contains(expectedSubString));
    }

//    public static void assertTrue(String failureMessage, boolean condition){
//        assertEquals(failureMessage, true, condition);
//    }

    private static void addVerificationFailure(String verificationFailureMessage) {
        verificationFailures.add(verificationFailureMessage);
    }
    public static ArrayList<String> getVerificationFailures() {
        return verificationFailures;
    }

    public static void resetVerificationFailures() {
        verificationFailures.clear();
    }

}

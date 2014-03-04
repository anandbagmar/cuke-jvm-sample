package utils;

import org.junit.Assert;

public class CustomAsserts {
    public static void assertTrue(String errorMessage, boolean condition) {
        try {
            Assert.assertTrue(condition);
        } catch (AssertionError ae) {
            System.out.println ("*****Custom Assertion Error" + errorMessage + "*****");
            ae.printStackTrace();
        }
    }

}

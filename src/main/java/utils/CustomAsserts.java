package utils;

import org.apache.log4j.Logger;
import org.junit.Assert;

public class CustomAsserts {
    public static void assertTrue(String errorMessage, boolean condition) {
        Logger logger = (Logger) RuntimeUtils.retrieveState("logger");
        try {
            Assert.assertTrue(condition);
        } catch (AssertionError ae) {
            logger.info("*****Custom Assertion Error" + errorMessage + "*****\n" + ae.toString());
            throw ae;
        }
    }

}

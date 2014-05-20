package utils;

import org.apache.log4j.Logger;

import java.util.Date;

public class DateUtils extends BaseUtils {
    public static String getTodaysDate() {
        logger = (Logger) RuntimeUtils.retrieveState("logger");
        Date todaysDate = new Date();
        String formattedDate = String.format("%te %tb %tY", todaysDate, todaysDate, todaysDate);
        logger.info("formattedDate: " + formattedDate);
        return formattedDate;
    }
}

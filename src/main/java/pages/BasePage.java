package pages;

import org.apache.log4j.Logger;
import utils.RuntimeUtils;

public class BasePage {
    protected Logger logger;

    public BasePage(){
        logger = (Logger) RuntimeUtils.retrieveState("logger");
    }
}

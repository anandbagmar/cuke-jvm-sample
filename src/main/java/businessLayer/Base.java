package businessLayer;

import org.apache.log4j.Logger;
import utils.RuntimeUtils;

public class Base {
    protected Logger logger;

    public Base() {
        logger = (Logger) RuntimeUtils.retrieveState("logger");
    }
}

package flows;

import org.apache.log4j.Logger;
import utils.RuntimeUtils;

public class BaseFlow {
    protected Logger logger;

    public BaseFlow() {
        logger = (Logger) RuntimeUtils.retrieveState("logger");
    }
}

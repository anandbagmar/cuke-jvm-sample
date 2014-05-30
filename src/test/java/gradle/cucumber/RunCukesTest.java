package gradle.cucumber;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.junit.Cucumber;
import cucumber.api.Scenario;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.runner.RunWith;
import utils.DriverUtils;
import utils.RuntimeUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

@RunWith(Cucumber.class)
public class RunCukesTest {
    Logger logger = null;

    @Before()
    public void commonSetup() {
        logger = setupLogger();
        logger.info("In Common Before Hook");
    }

    @Before("@browser")
    public void setUpWebDriver() {
        logger = (Logger) RuntimeUtils.retrieveState("logger");
        logger.info("In @browser Before Hook");
        DriverUtils.resetWebDriver();
    }

    @Before("@sikuli")
    public void setUpSikuliWebDriver() {
        logger = (Logger) RuntimeUtils.retrieveState("logger");
        logger.info("In @sikuli Before Hook");
        DriverUtils.isSikuli = true;
        DriverUtils.resetWebDriver();
    }

    @After("@sikuli")
    public void closeSikuliDriver(){
        DriverUtils.quitDriver();
    }

    @After("@browser")
    public void takeScreenShot(Scenario scenario) {
        logger = (Logger) RuntimeUtils.retrieveState("logger");
        logger.info("In @browser After Hook");
        logger.info("Scenario: " + scenario.toString() + " Failed. Taking screenshot");
        if (scenario.isFailed())
        {
            logger.info("Scenario: " + scenario.toString() + " Failed. Taking screenshot");
            scenario.embed(DriverUtils.takeScreenShot(), "image/png");
        }
        DriverUtils.quitDriver();
    }

    private Logger setupLogger() {
        logger = Logger.getLogger("testExecutionLogger");
        String log4JPropertyFile = "src/main/resources/log4j.properties";
        Properties p = new Properties();

        try {
            p.load(new FileInputStream(log4JPropertyFile));
            PropertyConfigurator.configure(p);
            logger.info("Wow! Logger is configured!");
        } catch (IOException e) {
            e.printStackTrace();
        }
        RuntimeUtils.saveState("logger", logger);
        return logger;
    }
}
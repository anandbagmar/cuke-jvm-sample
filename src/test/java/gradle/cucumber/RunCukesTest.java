package gradle.cucumber;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.junit.Cucumber;
import cucumber.api.Scenario;
import gherkin.deps.com.google.gson.Gson;
import org.junit.runner.RunWith;
import utils.DriverUtils;
import utils.RuntimeUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;


@RunWith(Cucumber.class)
public class RunCukesTest {

    @Before
    public void setUp() {
        DriverUtils.resetWebDriver();
    }

    @After
    public void takeScreenShot(Scenario scenario) {
        if (scenario.isFailed())
        {
            scenario.embed(DriverUtils.takeScreenShot(), "image/png");
        }
        DriverUtils.quitDriver();
    }

    @Before({"@taas"})
    public void setUpTaaS() {
        System.out.println("TaaS Before hook");
        Map<String, String> env = System.getenv();
        for (String envName : env.keySet()) {
            if(envName.startsWith("taas_")) {
                RuntimeUtils.taasParams.put(envName.replaceAll("taas_", ""), env.get(envName));
            }
        }
        if(RuntimeUtils.taasParams.size()>0) {
            System.out.println("Taas Params: ");
            for (String taasParam : RuntimeUtils.taasParams.keySet()) {
                System.out.format("\t%s: value: %s%n", taasParam, RuntimeUtils.taasParams.get(taasParam));
            }
        }
    }

    @After({"@taas"})
    public void taasResponse() {
        System.out.println("TaaS After hook");
        Gson gson = new Gson();
        String jsonOutput = gson.toJson(RuntimeUtils.taasResponse);

        System.out.println("<TaaS Response Start>");
        System.out.println(jsonOutput);
        System.out.println("<TaaS Response Completed>");
    }
}
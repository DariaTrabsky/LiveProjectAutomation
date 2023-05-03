package step_definitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.BrowserUtils;
import utils.CucumbersLogUtils;

public class Hooks {

    @Before
    public void setUp(Scenario scenario){
        BrowserUtils.getDriver();
        CucumbersLogUtils.initScenario(scenario);

    }
    @After
    public void tearDown(Scenario scenario) {
        if(scenario.isFailed()){
            CucumbersLogUtils.logFail(scenario.getName(), true);
        }
        BrowserUtils.quitDriver();
    }
}

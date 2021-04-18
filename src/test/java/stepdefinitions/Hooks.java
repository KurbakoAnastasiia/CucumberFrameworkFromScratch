package stepdefinitions;

import io.cucumber.java.Scenario;
import org.junit.After;
import org.junit.Before;
import testbase.BaseClass;
import utils.CommonMethods;

public class Hooks {

    /**
     * This method open the browser before every test
     */
    @Before
    public void startTest() {
        BaseClass.setUp();
    }

    @After
    public void endTest(Scenario scenario) {
        byte[] screenshot;
        if(scenario.isFailed()) {
            screenshot = CommonMethods.takeScreenshot("failed/" + scenario.getName());
        } else {
            screenshot = CommonMethods.takeScreenshot("passed/" + scenario.getName());
        }
        scenario.attach(screenshot, "image/png", scenario.getName());
        BaseClass.tearDown();
    }
}

package hooks;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.util.Set;

public class CucumberHooks {

    @Before
    public void setUp(Scenario scenario) {
        try {
            //Driver.init();
            //driver.navigate().to(GlobalValues.URL);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @After
    public void tearDown(Scenario scenario) throws Exception {
        /*if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) driver)
                    .getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png");
        }

        driver.quit();
        try {
            Set<String> windows = driver.getWindowHandles();
            for (String window : windows){
                driver.switchTo().window(window);
                driver.close();
            }
        } catch (Exception e) { }
        driver = null;*/

    }

}

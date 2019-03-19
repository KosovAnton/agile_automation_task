package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;

import java.util.concurrent.TimeoutException;

import static utils.GlobalValues.DRIVER;

public class JsUtils {
    public static void waitForPageLoad() {
        // wait for jQuery to load
        ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                try {
                    return ((Long) ((JavascriptExecutor) driver).executeScript("return jQuery.active") == 0);
                } catch (Exception e) {
                    return true;
                }
            }
        };
        // wait for Javascript to load
        ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState")
                        .toString().equals("complete");
            }
        };
        int counter = 0;
        int multiplier = 1;
        try {
            while (true) {
                if (jQueryLoad.apply(DRIVER) && jsLoad.apply(DRIVER)) {
                    return;
                } else {
                    counter++;
                    multiplier += multiplier;
                    if (multiplier > 29) {
                        throw new TimeoutException("Javascript is taking too long to finish");
                    } else {
                        Thread.sleep(1000 * multiplier);
                    }
                }
            }
        } catch (Throwable ex) {

        }
    }
}

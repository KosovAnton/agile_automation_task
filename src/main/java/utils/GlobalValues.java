package utils;

import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.HashMap;
import java.util.Map;

public class GlobalValues {

    public static int DEFAULT_WAITING_TIMEOUT = 15;
    public static String BASE_URL;
    public static String BROWSER;
    public static RemoteWebDriver DRIVER;

    public static Map<String, Object> valuesToBePassedBetweenSteps = new HashMap<>();

    static {
        if (System.getProperty("browser") != null) BROWSER = System.getProperty("browser");
        else BROWSER = Configuration.getProps().getBrowser();
        BASE_URL = Configuration.getProps().getUrl();
    }

}

package driver;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import static utils.GlobalValues.*;

public class Driver {

    public static RemoteWebDriver driver;

    public static void init() {
        URL location = Driver.class.getProtectionDomain().getCodeSource().getLocation();
        String sysProp = System.getProperty("browser");
        String mode = System.getProperty("mode");
        if (sysProp != null) BROWSER = sysProp;
        switch (BROWSER) {
            case "internet explorer":
                /*String tempIE = location.getFile().replace("target", "tools").replace("classes", "IEDriverServer.exe").substring(1, location.getFile().length() + 9);
                System.setProperty("webdriver.ie.driver", tempIE);*/

                InternetExplorerOptions ieOptions = new InternetExplorerOptions();
                ieOptions.setCapability(InternetExplorerDriver.NATIVE_EVENTS, false);
                ieOptions.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
                ieOptions.setCapability("unexpectedAlertBehaviour", "accept");
                ieOptions.setCapability("ignoreProtectedModeSettings", false);
                ieOptions.setCapability("disable-popup-blocking", true);
                ieOptions.setCapability("enablePersistentHover", false);
                ieOptions.destructivelyEnsureCleanSession();
                ieOptions.waitForUploadDialogUpTo(10, TimeUnit.SECONDS);

                try {
                    driver = new RemoteWebDriver(new URL("http://35.163.19.91:4444/wd/hub"), ieOptions);
                    driver.setFileDetector(new LocalFileDetector());
                    driver.manage().window().setSize(new Dimension(1680, 1050));
                } catch (Exception e) {
                    e.printStackTrace();
                }

                /*driver = new InternetExplorerDriver(ieOptions);
                driver.manage().window().setSize(new Dimension(1680,1050));*/
                break;
            case "fire fox":
                String tempFF;
                if (System.getProperties().getProperty("os.name").toLowerCase().contains("mac")) {
                    tempFF = location.getFile().replace("target", "tools").replace("classes", "geckodriver");
                } else {
                    tempFF = location.getFile().replace("target", "tools").replace("classes", "geckodriver.exe").substring(1, location.getFile().length() + 6);
                }
                System.setProperty("webdriver.gecko.driver", tempFF);

                FirefoxOptions cap = new FirefoxOptions()
                        .setProfile(new FirefoxProfile());
                cap.setCapability("acceptInsecureCerts", true);
                cap.setCapability("marionette", true);
                if (mode != null && mode.equals("headless")) {
                    cap.setHeadless(true);
                }
                cap.addPreference("security.sandbox.content.level", 5);
                driver = new FirefoxDriver(cap);
                if (System.getProperties().getProperty("os.name").toLowerCase().contains("mac")) {
                    driver.manage().window().fullscreen();
                } else {
                    driver.manage().window().setSize(new Dimension(1680, 1050));
                }
                break;
            case "chrome":
                String tempCH;
                if (System.getProperties().getProperty("os.name").toLowerCase().contains("mac")) {
                    tempCH = location.getFile().replace("target", "tools").replace("classes", "chromedriver");
                } /*if (System.getProperties().getProperty("os.name").toLowerCase().contains("linux")){
                    tempCH = location.getFile().replace("target", "tools").replace("classes", "chromedriver_lin");
                }*/ else {
                    tempCH = location.getFile().replace("target", "tools").replace("classes", "chromedriver.exe").substring(1, location.getFile().length() + 7);
                }
                System.setProperty("webdriver.chrome.driver", tempCH);
                ChromeOptions options = new ChromeOptions();
                if (mode != null && mode.equals("headless")) {
                    options.addArguments("--headless");
                    options.addArguments("--disable-gpu");
                    options.addArguments("--no-sandbox");
                    options.addArguments("--window-size=1680,1050");
                }
                driver = new ChromeDriver(options);
                if (System.getProperties().getProperty("os.name").toLowerCase().contains("mac")) {
                    driver.manage().window().fullscreen();
                } /*if (System.getProperties().getProperty("os.name").toLowerCase().contains("linux")){
                driver.manage().window().setSize(new Dimension(1680,1050));
                }*/ else {
                    driver.manage().window().setSize(new Dimension(1680, 1050));
                }
                break;
        }
    }
}

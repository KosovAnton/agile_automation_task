package driver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;

import static utils.GlobalValues.DRIVER;

public class Driver {

    public static void init() {
        System.setProperty("webdriver.chrome.driver", new File("chromedriver.exe").getAbsolutePath());
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        DRIVER = new ChromeDriver(options);
        DRIVER.manage().window().maximize();
    }
}

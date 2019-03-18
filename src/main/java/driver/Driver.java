package driver;

import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.net.URL;

import static utils.GlobalValues.DRIVER;

public class Driver {

    public static void init() {
        System.setProperty("webdriver.chrome.driver", new File("chromedriver.exe").getAbsolutePath());
        DRIVER = new ChromeDriver();
        DRIVER.manage().window().maximize();
    }
}

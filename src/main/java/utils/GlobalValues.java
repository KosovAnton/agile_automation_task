package utils;

import driver.Driver;
import org.openqa.selenium.remote.RemoteWebDriver;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class GlobalValues {

    public static String browser;
    public static RemoteWebDriver driver;
    public static String url;
    public static Users users;

    public static Map<String, Object> valuesToBePassedBetweenSteps = new HashMap<>();

    static {

        if (System.getProperty("browser") != null) browser = System.getProperty("browser");
        else browser = Configuration.getProps().getDriver();
        url = Configuration.getProps().getUrl();
        driver = Driver.init();

        File file = new File("users.xml");

        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Users.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            users = (Users) jaxbUnmarshaller.unmarshal(file);
        } catch (JAXBException e) {
            e.printStackTrace();
        }

    }

}

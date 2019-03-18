package utils;

import org.openqa.selenium.remote.RemoteWebDriver;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class GlobalValues {

    public static String BASE_URL;
    public static String BROWSER;
    public static RemoteWebDriver DRIVER;
    public static Users users;

    public static Map<String, Object> valuesToBePassedBetweenSteps = new HashMap<>();

    static {

        if (System.getProperty("browser") != null) BROWSER = System.getProperty("browser");
        else BROWSER = Configuration.getProps().getBrowser();
        BASE_URL = Configuration.getProps().getUrl();

        File file = new File("users.xml");

        /*try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Users.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            users = (Users) jaxbUnmarshaller.unmarshal(file);
        } catch (JAXBException e) {
            e.printStackTrace();
        }*/

    }

}

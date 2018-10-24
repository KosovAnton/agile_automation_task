package utils;

import driver.Driver;
import org.openqa.selenium.remote.RemoteWebDriver;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class GlobalValues {

    public static String URL;
    public static String BROWSER;
    public static Users USERS;
    public static RemoteWebDriver DRIVER;

    static {

        URL = Configuration.getProps().getUrl();
        BROWSER = Configuration.getProps().getDriver();

        File file = new File("users.xml");

        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Users.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            USERS = (Users) jaxbUnmarshaller.unmarshal(file);
        } catch (JAXBException e) {
            e.printStackTrace();
        }

    }

}

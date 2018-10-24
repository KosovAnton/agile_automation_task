package utils;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Users {
    @XmlElementWrapper(name = "users")
    @XmlElement(name = "user")
    public User[] users;

    public User getUserByName(String name) {
        for (User user : users) {
            if (user.name.equals(name)) {
                return user;
            }
        }
        return null;
    }
}

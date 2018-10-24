package utils;

import javax.xml.bind.annotation.XmlElement;

public class User {
    @XmlElement
    public String name;
    @XmlElement
    public String email;
    @XmlElement
    public String password;
}

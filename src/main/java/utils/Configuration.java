package utils;

import ru.yandex.qatools.properties.PropertyLoader;
import ru.yandex.qatools.properties.annotations.Property;
import ru.yandex.qatools.properties.annotations.Resource;

@Resource.Classpath("configuration")
public class Configuration {

    private static Configuration props;

    @Property("url")
    private String url;

    @Property("browser")
    private String browser;

    @Property("remoteDriverUrl")
    private String remoteDriverUrl;


    private Configuration() {
        PropertyLoader.populate(this);
    }

    public static synchronized Configuration getProps() {
        if (props == null) {
            props = new Configuration();
        }
        return props;
    }

    public String getUrl() {
        return url;
    }

    public String getBrowser() {
        return browser;
    }

    public String getRemoteDriverUrl() {
        return remoteDriverUrl;
    }
}

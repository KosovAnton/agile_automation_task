package utils;

import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.HashMap;
import java.util.Map;

public class GlobalValues {

    public final static String GRAPH_FB_BASE_URL = "https://graph.facebook.com/v3.2";
    public final static String GRAPH_FB_PAGE_ACCESS_TOKEN =
            "EAAKtMMcs3S4BAEPkWDCJ3u57vTrpZC0ZB5LvpHMEgeGus4P3EEZAUci4vNqmSNtNCGwDaNnRXQeJ51Ac6UpaRMJZAZCJgg8Bq5REpVJQtoI6VXHuYmThaJ7O8fcXt8nsenpyy5fY4Rbh9IZCEg3BH4XrxN9cFiZBCIbAWMwn4jj8bxig5hUKmL4wRFQZClniHYHivnkSRFEzYwZDZD";

    public static RemoteWebDriver DRIVER;
    public static int DEFAULT_WAITING_TIMEOUT = 10;
    public static String BASE_URL = "https://www.facebook.com";

    public static Map<String, Object> valuesToBePassedBetweenSteps = new HashMap<>();

}

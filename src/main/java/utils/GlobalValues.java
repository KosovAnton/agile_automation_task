package utils;

import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.HashMap;
import java.util.Map;

public class GlobalValues {

    public final static String GRAPH_FB_BASE_URL = "https://graph.facebook.com/v3.2";
    public final static String GRAPH_FB_PAGE_ACCESS_TOKEN =
            "EAAKtMMcs3S4BAKql0ApJKJuV3ZAjWYoNq3uNU5NKDWXBzeXKjqlsr5USXlued3gpSENDbZAE0frPRJZAT0PyqERygiAZBRWoAk1H5ZASaKF1u8EkbRqBcJSmAzfLECHARkOxdO8aiQZAYkFSmQiIpZBlw9ZCnPqfoyJjqEXc7v5YZBewLvh53ech91hQsDF3PdZCrojaqdXT6xWgZDZD";

    public static RemoteWebDriver DRIVER;
    public static int DEFAULT_WAITING_TIMEOUT = 10;
    public static String BASE_URL = "https://www.facebook.com";

    public static Map<String, Object> valuesToBePassedBetweenSteps = new HashMap<>();

}

package utils;

import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.HashMap;
import java.util.Map;

public class GlobalValues {

    public final static String GRAPH_FB_BASE_URL = "https://graph.facebook.com/v3.2";
    public final static String GRAPH_FB_PAGE_ACCESS_TOKEN = "EAAL2DlwBZAgkBACnZAwXpZC03cVM5BR8xPJI2RX0XZAGsZC7fpBoxTMQRrJqq1dJbRrTF7ZAofAMFiASTpMJi22sg0HVSQ6PIKaHuYjDGCOy8gnm1mTBqZCj8P6yfhZC8ZC1Eozj6WsXjSPLu9WzL4KfJPj3eyxZB7mSDQy0gZBBm6RUnZCZBN0PhZBa9LHnWDZBT6esufo0UVhjCXjuQZDZD";

    public static RemoteWebDriver DRIVER;
    public static int DEFAULT_WAITING_TIMEOUT = 10;
    public static String BASE_URL = "https://www.facebook.com";

    public static Map<String, Object> valuesToBePassedBetweenSteps = new HashMap<>();

}

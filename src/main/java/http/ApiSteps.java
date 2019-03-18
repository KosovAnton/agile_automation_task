package http;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static http.HttpExecutor.executePost;
import static utils.GlobalValues.BASE_URL;

public class ApiSteps {
    public static void login(String email, String pass) throws IOException {
        List<NameValuePair> credentials = new ArrayList<>();
        credentials.add(new BasicNameValuePair("email", email));
        credentials.add(new BasicNameValuePair("pass", pass));
        HttpResponse response = executePost(BASE_URL + "login/device-based/regular/login", credentials);
    }

    public static void postMessage(String message) throws IOException {
        HttpResponse response = executePost(BASE_URL + "login/device-based/regular/login");
    }
}

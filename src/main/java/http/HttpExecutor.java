package http;

import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.CookieStore;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.HTTP;

import java.io.IOException;
import java.util.List;

public class HttpExecutor {

    private static HttpPost httpPost;

    public static HttpResponse executePost(String url, List<NameValuePair> entry) throws IOException {
        DefaultHttpClient httpClient = new DefaultHttpClient();
        httpPost = new HttpPost(url);
        httpPost.setEntity(new UrlEncodedFormEntity(entry, HTTP.UTF_8));
        HttpResponse response = httpClient.execute(httpPost);
        return response;
    }

    public static HttpResponse executePost(String url) throws IOException {
        DefaultHttpClient httpClient = new DefaultHttpClient();
        httpPost = new HttpPost(url);
        //httpPost.setEntity(new UrlEncodedFormEntity(entry, HTTP.UTF_8));
        HttpResponse response = httpClient.execute(httpPost);
        /*List<Cookie> cookies = httpClient.getCookieStore().getCookies();
        if (cookies.isEmpty()) {
            System.out.println("None");
        } else {
            for (int i = 0; i < cookies.size(); i++) {
                System.out.println("- " + cookies.get(i).toString());
            }
        }

        Header[] headers = response.getAllHeaders();
        for (int i = 0; i < headers.length; i++) {
            System.out.println(headers[i].getName() + " " + headers[i].getValue() + System.lineSeparator());
        }*/

        return response;
    }

}

package stepdefinitions.API;

import com.jayway.restassured.response.ValidatableResponse;
import com.jayway.restassured.specification.RequestSpecification;
import com.jayway.restassured.response.Response;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;

public class FeedStepdefs {

    private String pageId = "833491486991881";
    private Response response;
    private ValidatableResponse json;
    private RequestSpecification request;

    private static String PageAccessToken = "EAAL2DlwBZAgkBACnZAwXpZC03cVM5BR8xPJI2RX0XZAGsZC7fpBoxTMQRrJqq1dJbRrTF7ZAofAMFiASTpMJi22sg0HVSQ6PIKaHuYjDGCOy8gnm1mTBqZCj8P6yfhZC8ZC1Eozj6WsXjSPLu9WzL4KfJPj3eyxZB7mSDQy0gZBBm6RUnZCZBN0PhZBa9LHnWDZBT6esufo0UVhjCXjuQZDZD";
    private static String UserEmail = "open_eitdzfw_user@tfbnw.net";
    private static String UserPassword = "testuser123";
    private static String GraphBaseUrl = "https://graph.facebook.com/";
    private static String GraphVersion = "v3.2";

    @Given("^API User$")
    public void apiUser() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }
}

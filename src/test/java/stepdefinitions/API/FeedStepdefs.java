package stepdefinitions.API;

import com.jayway.restassured.response.Response;
import com.jayway.restassured.response.ValidatableResponse;
import com.jayway.restassured.specification.RequestSpecification;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

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

    @Given("^API User sends request to create post with message \"([^\"]*)\"$")
    public void apiUserSendsRequestToCreatePostWithMessage(String text) throws Throwable {
    }

    @And("^API User receives response with status code \"([^\"]*)\"$")
    public void apiUserReceivesResponseWithStatusCode(String code) throws Throwable {
    }

    @Then("^API User verifies that feed contains post with message \"([^\"]*)\"$")
    public void apiUserVerifiesThatFeedContainsPostWithMessage(String arg0) throws Throwable {
    }

    @Given("^API User sends request to update post message \"([^\"]*)\" with text \"([^\"]*)\"$")
    public void apiUserSendsRequestToUpdatePostMessageWithText(String currentText, String newText) throws Throwable {
    }

    @Given("^API User sends request to delete post with message \"([^\"]*)\"$")
    public void apiUserSendsRequestToDeletePostWithMessage(String text) throws Throwable {
    }

    @Then("^API User verifies that feed does not contain post with message \"([^\"]*)\"$")
    public void apiUserVerifiesThatFeedDoesNotContainPostWithMessage(String text) throws Throwable {
    }
}

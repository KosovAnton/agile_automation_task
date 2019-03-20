package stepdefinitions.API;

import com.jayway.restassured.builder.RequestSpecBuilder;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.response.ValidatableResponse;
import com.jayway.restassured.specification.RequestSpecification;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import utils.GlobalValues;

public class FeedStepdefs {

    RequestSpecification requestSpec = new RequestSpecBuilder()
            .setBaseUri(GlobalValues.GRAPH_FB_BASE_URL)
            .setAccept(ContentType.JSON)
            .setContentType(ContentType.ANY)
            .addHeader("", "Bearer " + GlobalValues.GRAPH_FB_PAGE_ACCESS_TOKEN)
            .build();

    private String pageId = "833491486991881";
    private Response response;
    private ValidatableResponse json;
    private RequestSpecification request;

    private static String UserEmail = "open_eitdzfw_user@tfbnw.net";
    private static String UserPassword = "testuser123";

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

package stepdefinitions.API;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.restassured.response.ValidatableResponse;
import models.Post;
import org.junit.Assert;

import java.util.List;

import static http.ApiSteps.*;
import static org.hamcrest.Matchers.equalTo;

public class FeedStepdefs {

    private ValidatableResponse response;
    private String postId;
    private List<Post> feed;

    @Given("^API User sends request to create post with message \"([^\"]*)\"$")
    public void apiUserSendsRequestToCreatePostWithMessage(String text) {
        response = createPost(text);
    }

    @And("^API User receives response with status code \"([^\"]*)\"$")
    public void apiUserReceivesResponseWithStatusCode(int code) {
        response.statusCode(code);
        postId = response.extract().path("id");
    }

    @Then("^API User verifies that feed contains post with message \"([^\"]*)\"$")
    public void apiUserVerifiesThatFeedContainsPostWithMessage(String text) {
        Assert.assertTrue("User feed does not contain post with message: '" + text + "', and id: " + postId,
                getUserFeed().stream().anyMatch(post -> post.getMessage().equals(text) && post.getId().equals(postId)));
    }

    @Given("^API User sends request to update post message \"([^\"]*)\" with text \"([^\"]*)\"$")
    public void apiUserSendsRequestToUpdatePostMessageWithText(String currentText, String newText) {
        updatePost(currentText, newText).body("success", equalTo(true));
    }

    @Given("^API User sends request to delete post with message \"([^\"]*)\"$")
    public void apiUserSendsRequestToDeletePostWithMessage(String text) {
        deletePost(text).body("success", equalTo(true));
    }

    @Then("^API User verifies that feed does not contain post with message \"([^\"]*)\"$")
    public void apiUserVerifiesThatFeedDoesNotContainPostWithMessage(String text) {
        Assert.assertTrue("User feed still contains post with message: '" + text + "', and id: " + postId,
                getUserFeed().stream().noneMatch(post -> post.getMessage().equals(text) && post.getId().equals(postId)));
    }
}

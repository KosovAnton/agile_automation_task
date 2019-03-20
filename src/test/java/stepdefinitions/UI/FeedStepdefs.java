package stepdefinitions.UI;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import html.blocks.PostedMessage;
import html.pages.ProfilePage;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class FeedStepdefs {

    ProfilePage profilePage = new ProfilePage();

    @And("^User creates post with text \"([^\"]*)\"$")
    public void userCreatesPostWithText(String postText) {
        List<PostedMessage> actualPosts = profilePage.createPost(postText);
        assertTrue("User's feed does not contain appropriate post: " + postText,
                actualPosts.stream().anyMatch(post -> post.getPostedText().equals(postText)));
    }

    @When("^User updates post \"([^\"]*)\" with text \"([^\"]*)\"$")
    public void userUpdatesPostWithText(String currentText, String newText) {
        List<PostedMessage> actualPosts = profilePage.updatePost(currentText, newText);
        assertTrue("User's feed does not contain appropriate post: " + currentText + newText,
                actualPosts.stream().anyMatch(post -> post.getPostedText().equals(currentText + newText)));
    }

    @Then("^User deletes post with text message \"([^\"]*)\"$")
    public void userDeletesPostWithTextMessage(String postText) {
        List<PostedMessage> actualPosts = profilePage.deletePost(postText);
        assertTrue("User's feed still contains appropriate post: " + postText,
                actualPosts.stream().noneMatch(post -> post.getPostedText().equals(postText)));
    }
}

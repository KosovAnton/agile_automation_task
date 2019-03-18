package stepdefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import html.pages.ProfilePage;

public class PostMessageStepdefs {

    ProfilePage profilePage = new ProfilePage();

    @And("^User creates post with text \"([^\"]*)\"$")
    public void userCreatesPostWithText(String text) {
        profilePage.postMessage(text);
    }

    @And("^User updates post \"([^\"]*)\" with text \"([^\"]*)\"$")
    public void userUpdatesPostWithText(String currentText, String newText) {
        profilePage.updateMessage(currentText, newText);
    }
}

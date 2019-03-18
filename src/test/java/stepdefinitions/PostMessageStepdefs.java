package stepdefinitions;

import cucumber.api.java.en.And;
import html.pages.HomePage;
import html.pages.ProfilePage;

public class PostMessageStepdefs {

    ProfilePage profilePage = new ProfilePage();

    @And("^User posts new message with text \"([^\"]*)\"$")
    public void userPostsNewMessageWithText(String text) {
        profilePage.postNewMessage(text);
    }
}

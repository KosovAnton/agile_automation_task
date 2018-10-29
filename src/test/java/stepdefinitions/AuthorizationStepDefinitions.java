package stepdefinitions;

import cucumber.api.java.en.Given;
import html.pages.AuthorizationPage;

import static utils.GlobalValues.*;

public class AuthorizationStepDefinitions {

    AuthorizationPage authorizationPage = new AuthorizationPage();

    @Given("^I am on a FaceBook as not authorized user$")
    public void notAuthorizedInFacebook(){
        driver.get(url);
        authorizationPage.getLoginHeader().logIn("wefwf","wgwgwgwg");
    }
}
